/*
 * Copyright (c) 2014 by DTT Technology Joint Stock Company (http://dtt.vn/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package vn.dtt.cmon.portlet.endorse.business;


import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;

import vn.dtt.cmon.dao.cd.model.CongDan;
import vn.dtt.cmon.dao.cd.model.CongDanClp;
import vn.dtt.cmon.dao.cd.model.DoiTuongSuDung;
import vn.dtt.cmon.dao.cd.model.YeuCauDangKyCongDan;
import vn.dtt.cmon.dao.cd.service.CongDanLocalServiceUtil;
import vn.dtt.cmon.dao.cd.service.DoiTuongSuDungLocalServiceUtil;
import vn.dtt.cmon.dao.cd.service.YeuCauDangKyCongDanLocalServiceUtil;
import vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDungClp;
import vn.dtt.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import vn.dtt.cmon.portlet.endorse.util.ElectricCodeGeneratorUtil;
import vn.dtt.cmon.portlet.endorse.util.EncryptionUtil;
import vn.dtt.cmon.utils.Constaints;
import vn.dtt.cmon.utils.DateUtil;
import vn.dtt.cmon.utils.StringUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
/** 
 * EndorsementBs class
 * 
 * This class is used endore citizen
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class EndorsementBs {
	
	/** Citizen sequence */
	public static final String CITIZEN_SEQUENCE = "csms_congdan";
	
	/** Tai khoan nguoi dung sequence */
	public static final String TAIKHOANNGUOIDUNG_SEQUENCE = "cmon_taikhoannguoidung";
	
	
	
	private ActionRequest actionRequest = null;
	
	/**
	 * Constructor
	 * 
	 * @param actionRequest
	 */
	public EndorsementBs(ActionRequest actionRequest) {
		this.actionRequest = actionRequest;
	}
	
	/**
	 * This is function Create account on egovcore
	
	 * 
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 
	 * @param portalUserId
	 * @param password
	 * @param yeuCau
	 * @param actionRequest
	 * @throws Exception
	 */
	public long createTaiKhoan(long portalUserId, String fullName, String email, String password) throws Exception {
			
		// Check if login name exists
		TaiKhoanNguoiDung taiKhoan = TaiKhoanNguoiDungLocalServiceUtil.findByTenDangNhap(email);
		String maOrg ="CD";
		if (maOrg.length() == 0) {
			maOrg = "CD";
		}
		DoiTuongSuDung doiTuong = DoiTuongSuDungLocalServiceUtil.findByMa(maOrg);
		if ( taiKhoan != null ) {
			// Incase taikhoan exists, only update the password and name
			taiKhoan.setTenNguoiDung(fullName);
			
			// update password
			String encryptedPassword = EncryptionUtil.encrypt(password);
			taiKhoan.setMatKhau(encryptedPassword);
			
			// Update loai doi tuong
			taiKhoan.setLoaiDoiTuongId(doiTuong.getId());
			
			// Update the link to liferay user id
			taiKhoan.setTaiKhoanNguoiDungId(portalUserId);
			
			// Update to DB
			TaiKhoanNguoiDungLocalServiceUtil.updateTaiKhoanNguoiDung(taiKhoan);
			
			return taiKhoan.getId();			
		}
		
		// Insert nguoi dung here
		taiKhoan = new TaiKhoanNguoiDungClp();
		
		taiKhoan.setId(CounterLocalServiceUtil.increment(TAIKHOANNGUOIDUNG_SEQUENCE));	
		
		taiKhoan.setTenDangNhap(email);		
		
		// Encrypt the password
		String encryptedPassword = EncryptionUtil.encrypt(password);
		
		taiKhoan.setMatKhau(encryptedPassword);
		
		taiKhoan.setTenNguoiDung(fullName);
		
		taiKhoan.setEmail(email);
		
		taiKhoan.setTrangThai(1);// 1: active
		
		taiKhoan.setLoaiDoiTuongId(doiTuong.getId());
		
		taiKhoan.setTaiKhoanNguoiDungId(portalUserId);
		
		// Common columns
		Date currentDate = new Date();

		taiKhoan.setNgayTao(currentDate);

		
		taiKhoan.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(this.actionRequest);
		
		if ( currentUser != null) {
			taiKhoan.setNguoiTao(currentUser.getEmailAddress());
			
			taiKhoan.setNguoiSua(currentUser.getEmailAddress());			
		} else {
			// This is for test without logging in		
			taiKhoan.setNguoiTao("DUMMY");
			
			taiKhoan.setNguoiSua("DUMMY");	
		}
		
		taiKhoan.setDaXoa(0); // Un deleted
		
		return TaiKhoanNguoiDungLocalServiceUtil.addTaiKhoanNguoiDung(taiKhoan).getId();
	}
	
	
	
	
	/**
	 * This is function Create info citizen on egovcore
	
	 * 
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 
	 * @param yeuCau
	 * @param userId
	 * @param request
	 * @return
	 * @throws SystemException
	 * @throws NumberFormatException
	 * @throws PortalException
	 */
	public long createCitizen(YeuCauDangKyCongDan yeuCau, long userId, String maCongDan) throws SystemException, NumberFormatException, PortalException {
		CongDan congDan = null;		
		// Check if the citizen exists or not
		if (Validator.isNotNull(maCongDan)) {
			congDan = CongDanLocalServiceUtil.findByMa(maCongDan);
			
			if ( congDan != null) {
				
				// update tai khoan nguoi dung id
				congDan.setTaiKhoanNguoiDungId(userId);
				
				//Update
				CongDanLocalServiceUtil.updateCongDan(congDan);
				
				return congDan.getId();				
				
			}
		}
		
		congDan = new CongDanClp();
		
		long id = CounterLocalServiceUtil.increment(CITIZEN_SEQUENCE);
		
		congDan.setId( id );
		
		System.out.println("\n ========yeuCau.getIDTinhThanhThuongTru() :" + yeuCau.getIDTinhThanhThuongTru());
		congDan.setMa( ElectricCodeGeneratorUtil.generateCode(yeuCau.getIDTinhThanhThuongTru(), yeuCau.getNgaySinh()));	
		
		congDan.setHo(yeuCau.getHoCongDan());
		
		congDan.setDem( yeuCau.getTenDem());
		
		congDan.setTen(yeuCau.getTenCongDan());
		
		congDan.setTenDayDu(yeuCau.getHoCongDan() + StringPool.SPACE +yeuCau.getTenDem() + StringPool.SPACE + yeuCau.getTenCongDan());
		
		congDan.setNgaySinh(yeuCau.getNgaySinh());
		
		congDan.setSoCmnd(yeuCau.getSoCmnd());
		
		congDan.setNgayCapCmnd(yeuCau.getNgayCapCmnd());
		
		congDan.setGhiChuCmnd(yeuCau.getGhiChuCmnd());
		
		congDan.setSoHoChieu(yeuCau.getSoHoChieu());
		
		congDan.setNgayCapHoChieu(yeuCau.getNgayCapHoChieu());
		
		congDan.setNgayHetHanHoChieu(yeuCau.getNgayHetHanHoChieu());
		
		congDan.setGhiChuHoChieu(yeuCau.getGhiChuHoChieu());
		
		congDan.setSoBaoHiemYTe(yeuCau.getSoBaoHiemYte());
		
		congDan.setMaSoThueCaNhan(yeuCau.getMaSoThueCaNhan());
		
		congDan.setDiaChiThuongTru(yeuCau.getMoTaDiaChiThuongTru());
		
		congDan.setDiaChiHienNay(yeuCau.getMoTaDiaChiHienTai());
		
		congDan.setDienThoaiCoDinh(yeuCau.getDienThoaiCoDinh());
		
		congDan.setDienThoaiDiDong(yeuCau.getDienThoaiDiDong());
	
		
		congDan.setSoHoKhau(yeuCau.getSoHoKhau());
		
		congDan.setLaChuHo(yeuCau.getChuHo());
		
		congDan.setEmail(yeuCau.getEmail());
		
		if (yeuCau.getIDDanToc() != null && yeuCau.getIDDanToc() > 0)
			congDan.setDanTocId(yeuCau.getIDDanToc());
		if (yeuCau.getIDPhuongXaHienTai() != null && yeuCau.getIDPhuongXaHienTai() > 0)
		congDan.setDiaChiHienNayXaId(yeuCau.getIDPhuongXaHienTai());
		if (yeuCau.getIDQuanHuyenHienTai() != null && yeuCau.getIDQuanHuyenHienTai() > 0)
		congDan.setDiaChiHienNayHuyenId(yeuCau.getIDQuanHuyenHienTai());
		if (yeuCau.getIDTinhThanhHienTai() != null && yeuCau.getIDTinhThanhHienTai() > 0)
		congDan.setDiaChiHienNayTinhId(yeuCau.getIDTinhThanhHienTai());
		if (yeuCau.getIDQuanHuyenThuongTru() != null && yeuCau.getIDQuanHuyenThuongTru() > 0)
		congDan.setDiaChiThuongTruHuyenId(yeuCau.getIDQuanHuyenThuongTru());
		if (yeuCau.getIDPhuongXaThuongTru() != null && yeuCau.getIDPhuongXaThuongTru() > 0)
		congDan.setDiaChiThuongTruXaId(yeuCau.getIDPhuongXaThuongTru());
		if (yeuCau.getIDTinhThanhThuongTru() != null && yeuCau.getIDTinhThanhThuongTru() > 0)
		congDan.setDiaChiThuongTruTinhId(yeuCau.getIDTinhThanhThuongTru());
		congDan.setGioiTinh(yeuCau.getGioiTinh());
		if (yeuCau.getIDNgheNghiep() != null && yeuCau.getIDNgheNghiep() > 0)
		congDan.setNgheNghiepId(yeuCau.getIDNgheNghiep());
		if (yeuCau.getIDNoiCapCmnd() != null && yeuCau.getIDNoiCapCmnd() > 0)
		congDan.setNoiCapCmndId(yeuCau.getIDNoiCapCmnd());
		if (yeuCau.getIDNoiCapHoChieu() != null && yeuCau.getIDNoiCapHoChieu() > 0)
		congDan.setNoiCapHoChieuId(yeuCau.getIDNoiCapHoChieu());
		if (yeuCau.getIDTinhThanhNoiSinh() != null && yeuCau.getIDTinhThanhNoiSinh() > 0)
		congDan.setNoiSinhTinhId(yeuCau.getIDTinhThanhNoiSinh());
		if (yeuCau.getIDPhuongXaNoiSinh() != null && yeuCau.getIDPhuongXaNoiSinh() > 0)
		congDan.setNoiSinhXaId(yeuCau.getIDPhuongXaNoiSinh());
		if (yeuCau.getIDQuanHuyenNoiSinh() != null && yeuCau.getIDQuanHuyenNoiSinh() > 0)
		congDan.setNoiSinhHuyenId(yeuCau.getIDQuanHuyenNoiSinh());
		
		congDan.setNoiSinhChiTiet(yeuCau.getMoTaDiaChiNoiSinh());
		if (yeuCau.getIDQuanHe() != null && yeuCau.getIDQuanHe() > 0)
		congDan.setQuanHeChuHoId(yeuCau.getIDQuanHe());
		if (yeuCau.getIDQuocTich() != null && yeuCau.getIDQuocTich() > 0) {
			congDan.setQuocTichId(yeuCau.getIDQuocTich());
		} else {
			String idStr = String.valueOf(Constaints.VIETNAM);
			
			System.out.println("\n===== id viet nam:" + idStr);
			if (Validator.isNotNull(idStr)) {
				try {
					congDan.setQuocTichId(Long.parseLong(idStr));
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		congDan.setTaiKhoanNguoiDungId(userId);	
		
		if (yeuCau.getTinhTrangHonNhan() != null && yeuCau.getTinhTrangHonNhan() > 0)
			congDan.setTinhTrangHonNhanId(yeuCau.getTinhTrangHonNhan());
		
		try {
			
			System.out.println("\n==== ton giao:" + yeuCau.getIDTonGiao());
			congDan.setTonGiaoId(yeuCau.getIDTonGiao());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (yeuCau.getIDTrinhDoChuyenMon() != null && yeuCau.getIDTrinhDoChuyenMon() > 0)
		congDan.setTrinhDoChuyenMonId(yeuCau.getIDTrinhDoChuyenMon());
		if (yeuCau.getIDTrinhDoHocVan() != null && yeuCau.getIDTrinhDoHocVan() > 0)
		congDan.setTrinhDoHocVanId(yeuCau.getIDTrinhDoHocVan());
		
		Date currentDate = new Date();		
	
		congDan.setNgayTao(currentDate);
		
		congDan.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(this.actionRequest);
		
		if ( currentUser != null) {		
			// Nguoi chung thuc
			congDan.setNguoiTao(currentUser.getEmailAddress());
			congDan.setNguoiSua(currentUser.getEmailAddress());			
		} else {
			congDan.setNguoiTao("DUMMY");
			congDan.setNguoiSua("DUMMY");	
		}
		
		congDan.setDaXoa(0);
		
		System.out.println("\n begin insert cong dan :" + congDan);
		CongDanLocalServiceUtil.addCongDan(congDan);
		
	
		return congDan.getId();		
	}
	
	/**
	 * This is function create account on Portal
	
	 * 
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 
	 * @param yeuCau
	 * @param actionRequest
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 * @throws IOException
	 */
	public long createPortalCitizenUser( YeuCauDangKyCongDan yeuCau, String password ) throws SystemException, PortalException, IOException {
		// Create portal user
		CitizenUserBs user = new CitizenUserBs();
		
		// Full name
		user.setFullName( yeuCau.getHoCongDan() + StringPool.SPACE + yeuCau.getTenDem() + StringPool.SPACE + yeuCau.getTenCongDan());
		
		// Email
		user.setEmail( yeuCau.getEmail() );
		
		// Anh chan dung
		byte[] avatar = (byte[])actionRequest.getPortletSession().getAttribute("PROFILE_PIC");
		
		if ( avatar != null && avatar.length > 0 ){
			user.setAvatar(avatar);
		}
		
		// Ngay sinh
		user.setBirthDate(yeuCau.getNgaySinh());
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		// Create portal user
		return user.createCitizenInLiferay(Constaints.passwordDefault, themeDisplay, yeuCau);
	}
	
	/**
	 * This is function update info on request
	
	 * 
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 
	 * @param userRequest
	 * @param actionRequest
	 * @throws SystemException 
	 * @throws PortalException 
	 * @throws ParseException 
	 */
	public YeuCauDangKyCongDan updateUserRequest( Map <String, String> userRequest ) throws PortalException, SystemException, ParseException {
		
		// Get the request id from URL parameter
		long reqId = Long.parseLong(userRequest.get("ID"));
		
		
		// Get record from DB
		YeuCauDangKyCongDan yeuCau = YeuCauDangKyCongDanLocalServiceUtil.getYeuCauDangKyCongDan(reqId);
		
		String ho = userRequest.get("HOCONGDAN");
		yeuCau.setHoCongDan(ho);
		
		String tenDem = userRequest.get("TENDEM");
		yeuCau.setTenDem(tenDem);
		
		String ten = userRequest.get("TENCONGDAN");
		yeuCau.setTenCongDan(ten);
		
		StringBuilder fullName = new StringBuilder();
		fullName.append(ho);
		if (!Validator.isNull(tenDem)) {
			if (fullName.length() > 0) {
				fullName.append(" ");
			}
			fullName.append(tenDem);
		}
		if (!Validator.isNull(ten)) {
			if (fullName.length() > 0) {
				fullName.append(" ");
			}
			fullName.append(ten);
		}
		yeuCau.setHoVaTen(fullName.toString());
		
		yeuCau.setSoCmnd(userRequest.get("SOCMND"));
		
		if (Validator.isNotNull(userRequest.get("NGAYCAPCMND")))
			yeuCau.setNgayCapCmnd(DateUtil.parseStringToDate(userRequest.get("NGAYCAPCMND")));
		
		if (Validator.isNotNull(userRequest.get("IDNOICAPCMND")))
		yeuCau.setIDNoiCapCmnd(Long.parseLong(userRequest.get("IDNOICAPCMND")));
		
		yeuCau.setGhiChuCmnd(userRequest.get("GHICHUCMND"));
		
		yeuCau.setEmail(userRequest.get("EMAIL"));
		
		yeuCau.setSoHoChieu(userRequest.get("SOHOCHIEU"));
		
		if ( Validator.isNotNull(userRequest.get("NGAYCAPHOCHIEU"))) {
			yeuCau.setNgayCapHoChieu(DateUtil.parseStringToDate(userRequest.get("NGAYCAPHOCHIEU")));
		}
		if (Validator.isNotNull(userRequest.get("IDNOICAPHOCHIEU")))
		yeuCau.setIDNoiCapHoChieu((Long.parseLong(userRequest.get("IDNOICAPHOCHIEU"))));
		
		if ( Validator.isNotNull(userRequest.get("NGAYHETHANHOCHIEU"))) {
			yeuCau.setNgayHetHanHoChieu(DateUtil.parseStringToDate(userRequest.get("NGAYHETHANHOCHIEU")));
		}
		
		yeuCau.setGhiChuHoChieu(userRequest.get("GHICHUHOCHIEU"));
		if (Validator.isNotNull(userRequest.get("IDGIOITINH")))
		yeuCau.setGioiTinh(Integer.parseInt(userRequest.get("IDGIOITINH")));
		if (Validator.isNotNull(userRequest.get("IDDANTOC")))
		yeuCau.setIDDanToc(Long.parseLong(userRequest.get("IDDANTOC")));
		if (Validator.isNotNull(userRequest.get("IDTONGIAO")))
		yeuCau.setIDTonGiao(Long.parseLong(userRequest.get("IDTONGIAO")));
		if (Validator.isNotNull(userRequest.get("IDQUOCTICH")))
		yeuCau.setIDQuocTich(Long.parseLong(userRequest.get("IDQUOCTICH")));
		if (Validator.isNotNull(userRequest.get("NGAYSINH")))
		yeuCau.setNgaySinh(DateUtil.parseStringToDate(userRequest.get("NGAYSINH")));
		
		yeuCau.setDienThoaiCoDinh(userRequest.get("DIENTHOAICODINH"));
		
		yeuCau.setDienThoaiDiDong(userRequest.get("DIENTHOAIDIDONG"));
		if (Validator.isNotNull(userRequest.get("IDTRINHDOHOCVAN")))
		yeuCau.setIDTrinhDoHocVan(Long.parseLong(userRequest.get("IDTRINHDOHOCVAN")));
		
		yeuCau.setSoBaoHiemYte(userRequest.get("SOBAOHIEMYTE"));
		
		yeuCau.setMaSoThueCaNhan(userRequest.get("MASOTHUECANHAN"));
		if (Validator.isNotNull(userRequest.get("IDNGHENGHIEP")))
		yeuCau.setIDNgheNghiep(Long.parseLong(userRequest.get("IDNGHENGHIEP")));
		if (Validator.isNotNull(userRequest.get("IDTRINHDOCHUYENMON")))
		yeuCau.setIDTrinhDoChuyenMon(Long.parseLong(userRequest.get("IDTRINHDOCHUYENMON")));
		if (Validator.isNotNull(userRequest.get("IDTINHTRANGHONNHAN")))
		yeuCau.setTinhTrangHonNhan(Long.parseLong(userRequest.get("IDTINHTRANGHONNHAN")));
		if (Validator.isNotNull(userRequest.get("IDTINHTHANHNOISINH")))
		yeuCau.setIDTinhThanhNoiSinh(Long.parseLong(userRequest.get("IDTINHTHANHNOISINH")));
		if (Validator.isNotNull(userRequest.get("IDQUANHUYENNOISINH")))
		yeuCau.setIDQuanHuyenNoiSinh(Long.parseLong(userRequest.get("IDQUANHUYENNOISINH")));
		if (Validator.isNotNull(userRequest.get("IDPHUONGXANOISINH")))
		yeuCau.setIDPhuongXaNoiSinh(Long.parseLong(userRequest.get("IDPHUONGXANOISINH")));
		
		yeuCau.setMoTaDiaChiNoiSinh(userRequest.get("MOTADIACHINOISINH"));
		if (Validator.isNotNull(userRequest.get("IDTINHTHANHTHUONGTRU")))
		yeuCau.setIDTinhThanhThuongTru(Long.parseLong(userRequest.get("IDTINHTHANHTHUONGTRU")));
		if (Validator.isNotNull(userRequest.get("IDQUANHUYENTHUONGTRU")))
		yeuCau.setIDQuanHuyenThuongTru(Long.parseLong(userRequest.get("IDQUANHUYENTHUONGTRU")));
		if (Validator.isNotNull(userRequest.get("IDPHUONGXATHUONGTRU")))
		yeuCau.setIDPhuongXaThuongTru(Long.parseLong(userRequest.get("IDPHUONGXATHUONGTRU")));
		
		yeuCau.setMoTaDiaChiThuongTru(userRequest.get("MOTADIACHITHUONGTRU"));
		if (Validator.isNotNull(userRequest.get("IDTINHTHANHHIENTAI")))
		yeuCau.setIDTinhThanhHienTai(Long.parseLong(userRequest.get("IDTINHTHANHHIENTAI")));
		if (Validator.isNotNull(userRequest.get("IDQUANHUYENHIENTAI")))
		yeuCau.setIDQuanHuyenHienTai(Long.parseLong(userRequest.get("IDQUANHUYENHIENTAI")));
		if (Validator.isNotNull(userRequest.get("IDPHUONGXAHIENTAI")))
		yeuCau.setIDPhuongXaHienTai(Long.parseLong(userRequest.get("IDPHUONGXAHIENTAI")));
		
		yeuCau.setMoTaDiaChiHienTai(userRequest.get("MOTADIACHIHIENTAI"));
		
		yeuCau.setHoVaTenCha(userRequest.get("HOVATENCHA"));
		
		yeuCau.setMaCongDanCha(userRequest.get("MACONGDANCHA"));
		
		yeuCau.setHoVaTenMe(userRequest.get("HOVATENME"));
		
		yeuCau.setMaCongDanMe(userRequest.get("MACONGDANME"));
		
		yeuCau.setHoVaTenVoChong(userRequest.get("HOVATENVOCHONG"));
		
		yeuCau.setMaCongDanVoChong(userRequest.get("MACONGDANVOCHONG"));
		
		yeuCau.setSoHoKhau(userRequest.get("SOHOKHAU"));
		if (Validator.isNotNull(userRequest.get("CHUHO")))
		yeuCau.setChuHo(Integer.parseInt(userRequest.get("CHUHO")));
		if (Validator.isNotNull(userRequest.get("IDQUANHE")))
		yeuCau.setIDQuanHe(Long.parseLong(userRequest.get("IDQUANHE")));
		
		yeuCau.setNgaySua(new Date());
		
		yeuCau.setTrangThaiYeuCau(StringUtil.TRANG_THAI_YEU_CAU_DK_CONG_DAN_DA_CHUNG_THUC); // Endorsed
		
		User currentUser = PortalUtil.getUser(actionRequest);
		
		if ( currentUser != null) {		
			yeuCau.setNguoiSua(currentUser.getEmailAddress());			
		}
		
		
		YeuCauDangKyCongDanLocalServiceUtil.updateYeuCauDangKyCongDan(yeuCau);		

		return yeuCau;
	}
	
	/**
	 * This is function check exist citizen in system
	
	 * 
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 
	 * @param ho
	 * @param dem
	 * @param ten
	 * @param soCmnd
	 * @param ngaySinh
	 * @return
	 * @throws ParseException
	 */
	public String citizenExists(String ho, String dem, String ten, String soCmnd, String ngaySinh) throws ParseException{
		
		Date birthDay = DateUtil.parseStringToDate(ngaySinh);
		
		ho = ho.toUpperCase();
		
		dem = dem.toUpperCase();
		
		ten = ten.toUpperCase();
		
		// Check in database if there's existing person with the same birth day and province code
		DynamicQuery queryCongDan = DynamicQueryFactoryUtil.forClass(CongDan.class);
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ngaySinh").eq(birthDay));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ho").eq(ho));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("dem").eq(dem));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ten").eq(ten));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("soCmnd").eq(soCmnd));
		
		List<CongDan> results = null;
		
		try {
			results = CongDanLocalServiceUtil.dynamicQuery(queryCongDan);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( results == null ||  results.size() < 1) {
			return StringPool.BLANK;
		}
		
		// Return the id
		return (results.get(0)).getMa();
	}
}
