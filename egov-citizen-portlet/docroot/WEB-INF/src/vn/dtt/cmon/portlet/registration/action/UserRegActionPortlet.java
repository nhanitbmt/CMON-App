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

package vn.dtt.cmon.portlet.registration.action;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import vn.dtt.cmon.dao.cd.model.CongDan;
import vn.dtt.cmon.dao.cd.model.YeuCauDangKyCongDan;
import vn.dtt.cmon.dao.cd.model.YeuCauDangKyCongDanClp;
import vn.dtt.cmon.dao.cd.service.CongDanLocalServiceUtil;
import vn.dtt.cmon.dao.cd.service.YeuCauDangKyCongDanLocalServiceUtil;
import vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh;
import vn.dtt.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;
import vn.dtt.cmon.portlet.endorse.util.AuthenticateCodeUtil;
import vn.dtt.cmon.portlet.registration.util.CheckCaptchaUtil;
import vn.dtt.cmon.portlet.registration.util.UserParamUtil;
import vn.dtt.cmon.utils.Constaints;
import vn.dtt.cmon.utils.DateUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/** 
 * User registration class
 * 
 * This class contains all logics related to user registation
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  24-April-2013  Nam Dinh    Create new
 */
public class UserRegActionPortlet extends MVCPortlet {
	
	/** Key to generate id on csms_yeucaudangkycongdan table */
	private static final String CSMS_YEUCAUDANGKYCONGDAN_SEQUENCE = "CSMS_YEUCAUDANGKYCONGDAN";
	
	
	
	/** Request for both account and citizen information type */
	private static final int ACCOUNT_AND_CITIZEN_TYPE = 0;
	
	private static Log _log = LogFactoryUtil.getLog(UserRegActionPortlet.class);
	
	
	/** 
	
	 *	this is function return json for ajax when user click reload captcha 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Binh.Nt    Create new
	 */
	public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException, PortletException {
		// Get resource id
		String resourceId = resourceRequest.getResourceID();
		
		// Generate captcha image and return to client
		if ("captcha".equals(resourceId)) {
			try {
				CaptchaUtil.serveImage(resourceRequest, resourceResponse);
			} catch (Exception e) {            
				
			}
			
			return;
		}
		
		// Process Jason feed
		JSONObject  jsonFeed = JSONFactoryUtil.createJSONObject();
		if ( "fetchDonViHanhChinh".equals(resourceId) ) {		
			// Get country code from URL
			long parentId = ParamUtil.getInteger(resourceRequest, "parentId");
			
			// Create Jason array o bject
			JSONArray donViHanhChinhArray = JSONFactoryUtil.getJSONFactory().createJSONArray();	
			
			// Query all sub don vi hanh chinh using parent id
			List<DonViHanhChinh> donviHanhChinhList = null;

			donviHanhChinhList = DonViHanhChinhLocalServiceUtil.findByChaId(parentId,Constaints.ACTIVATED);			

			// Store all data to jSon object
			for (DonViHanhChinh donViHanhChinh : donviHanhChinhList) {
				donViHanhChinhArray.put( donViHanhChinh.getId() + ":"  + donViHanhChinh.getTen());
			}
		
			jsonFeed.put("donViHanhChinhArray", donViHanhChinhArray );	
		}		
				
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
	}
	
	/** 
	 
	 * This is function input data for userRequest show info citizen. 
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Thanh.Do    Create new
	 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws PortalException
	 * @throws SystemException
	 * @throws ParseException
	 */
	public void inputBasic(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException, ParseException {
		// Get the object from session
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
		
		// Get all parameters from request
		String hoCongDan = ParamUtil.getString(actionRequest, "ho").trim().toUpperCase();
		userRequest.put("HOCONGDAN", hoCongDan);
		
		String tenDem = ParamUtil.getString(actionRequest, "dem").trim().toUpperCase();
		userRequest.put("TENDEM", tenDem);		
		
		String tenCongDan = ParamUtil.getString(actionRequest, "ten").trim().toUpperCase();
		userRequest.put("TENCONGDAN", tenCongDan);
		
		String soCmnd = ParamUtil.getString(actionRequest, "soCmnd").trim();
		userRequest.put("SOCMND", soCmnd);			
		
		String email = ParamUtil.getString(actionRequest, "email").trim();
		userRequest.put("EMAIL", email);		
		
		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh").trim();
		userRequest.put("NGAYSINH", ngaySinh);
		
		String ngayCapCmnd = ParamUtil.getString(actionRequest, "ngayCapCmnd").trim();
		userRequest.put("NGAYCAPCMND", ngayCapCmnd);
		
		String gioiTinh = ParamUtil.getString(actionRequest, "gioiTinh");
		if ( Validator.isNotNull(gioiTinh)) {
			userRequest.put("IDGIOITINH", gioiTinh);
		}
		
		String danToc = ParamUtil.getString(actionRequest, "danToc");
		if ( Validator.isNotNull(danToc)) {
			userRequest.put("IDDANTOC", danToc);
		}
		
		String tonGiao = ParamUtil.getString(actionRequest, "tonGiao");
		if ( Validator.isNotNull(tonGiao)) {
			userRequest.put("IDTONGIAO", tonGiao);
		}
		
		String tinhThuongTru = ParamUtil.getString(actionRequest, "tinhThuongTru");
		if ( Validator.isNotNull(tinhThuongTru)) {
			userRequest.put("IDTINHTHANHTHUONGTRU", tinhThuongTru);
		}
		
		String huyenThuongTru = ParamUtil.getString(actionRequest, "huyenThuongTru");
		if ( Validator.isNotNull(huyenThuongTru)) {
			userRequest.put("IDQUANHUYENTHUONGTRU", huyenThuongTru);
		}
		
		String xaThuongTru = ParamUtil.getString(actionRequest, "xaThuongTru");
		if ( Validator.isNotNull(xaThuongTru)) {
			userRequest.put("IDPHUONGXATHUONGTRU", xaThuongTru);
		}
		
		String motaThuongTru = ParamUtil.getString(actionRequest, "motaThuongTru").trim();
		userRequest.put("MOTADIACHITHUONGTRU", motaThuongTru);
		
		// Set the data back to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_OBJECT", userRequest);

		// BinhNT add 2013-12-22 
		String reloadcapchar = ParamUtil.getString(actionRequest, "reloadcapchar").trim();
		if (reloadcapchar.trim().compareTo("reloadcapchar") == 0) {
			String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
			actionResponse.sendRedirect(redirectUrl);
			return;
		}
		// End BinhNT Add 2013-12-22
		// Validate captcha
		if ( !CheckCaptchaUtil.isTrue(actionRequest, "captcha") ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.captcha");	
		}
		
		// Check Ho cong dan
		if (Validator.isNull(hoCongDan)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.hoCongDan");
		}
		
		// Check ten cong dan
		if (Validator.isNull(tenCongDan)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tenCongDan");
		}
		
		// Check so cmnd
		if (Validator.isNull(soCmnd) || !Validator.isNumber(soCmnd) ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.soCmnd");
		}
		
		if (soCmnd.trim().length() <9 || soCmnd.trim().length() > 12) {
			SessionErrors.add(actionRequest, "err.soCmndVoPhaiNamTrongKhoangTuChinDenMuoiHaiChuSo");
		}
				
		// Check email
		if (!Validator.isEmailAddress(email)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email");
		}		
		
		// Check ngay sinh
		if (Validator.isNull(ngaySinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngaySinh");
		}
		
		// In case there's error		
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");

		if ( !SessionErrors.isEmpty(actionRequest)) {
			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
		// Validate data against DB
		
		// Validate birth date
		
		Date birthDate = null;
		
		try {
			birthDate = DateUtil.parseStringToDate(ngaySinh);
		} catch (Exception e) {
			// Error never happen so this exception will be swallow
		}
		
		if ( birthDate.compareTo(new Date()) > 0) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngaySinh.greaterThanCurrent");
		}
		

		List<CongDan> congDan = CongDanLocalServiceUtil.findByEmail(email);
		if (congDan.size() > 0){
			if (this.cmndExists(soCmnd)) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.requestExists");
			}
			// Check email if exists in CSMS cong dan
			if ( this.checkExistEmail(email)) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email.alreadyOwned");
			}
		}
		
		
		
		if ( !SessionErrors.isEmpty(actionRequest)) {
			actionResponse.sendRedirect(redirectUrl);
			return;
		}
		
		// Check if citizen exists or not
		//String maCongDan = this.citizenExists(hoCongDan, tenDem, tenCongDan, soCmnd, ngaySinh);
		String maCongDan = this.checkExistCitizen(soCmnd, ngaySinh);
		_log.info("ma cong dan:" +maCongDan);
		if ( Validator.isNull(maCongDan)) {
			_log.info("chua co thong tin trong csms_congdan");
			// Redirect to input detail confirm
			String inputDetailDialogUrl = ParamUtil.getString(actionRequest, "inputDetailDialogUrl");
			
			PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			
			actionResponse.sendRedirect(inputDetailDialogUrl);
			
			return;
		}
		
		else {
			CongDan congDan1 = CongDanLocalServiceUtil.findByMa(maCongDan);
			_log.info("congDan1: "+congDan1);
			
			// Check email if exists in CSMS cong dan
			if ( congDan1.getEmail().length() >0) {
				_log.info("da co tai khoan csms_congdan");
				String accountExistDialog = ParamUtil.getString(actionRequest, "accountExistDialog");
				
				PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
				SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.sendRedirect(accountExistDialog);
				return;
			} else {
				_log.info("chua co tai khoan trong csms_congdan");
				String inputDetailDialogUrlExistInCongDan = ParamUtil.getString(actionRequest, "inputDetailDialogUrlExistInCongDan");
				
				PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
				SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.sendRedirect(inputDetailDialogUrlExistInCongDan);
				return;

			}		
			
		}
		
	
	}
		
	/** 
	
	 * This is function show info citizen 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Thanh.Do    Create new
	
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws PortalException
	 * @throws SystemException
	 * @throws ParseException
	 */
	public void inputDetail(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException, ParseException {
		// Get the object from session
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
		
		// Get all parameters from request
		String hoCongDan = ParamUtil.getString(actionRequest, "ho").trim().toUpperCase();
		userRequest.put("HOCONGDAN", hoCongDan);
		
		String tenDem = ParamUtil.getString(actionRequest, "dem").trim().toUpperCase();
		userRequest.put("TENDEM", tenDem);		
		
		String tenCongDan = ParamUtil.getString(actionRequest, "ten").trim().toUpperCase();
		userRequest.put("TENCONGDAN", tenCongDan);
		
		String soCmnd = ParamUtil.getString(actionRequest, "soCmnd").trim();
		userRequest.put("SOCMND", soCmnd);
		
		String ngayCapCmnd = ParamUtil.getString(actionRequest, "ngayCapCmnd").trim();
		userRequest.put("NGAYCAPCMND", ngayCapCmnd);
		
		String noiCapCmnd = ParamUtil.getString(actionRequest, "noiCapCmnd").trim();
		if ( Validator.isNotNull(noiCapCmnd)) {
			userRequest.put("IDNOICAPCMND", noiCapCmnd);
		}
		
		String email = ParamUtil.getString(actionRequest, "email").trim();
		userRequest.put("EMAIL", email);
		

		
		String gioiTinh = ParamUtil.getString(actionRequest, "gioiTinh");
		if ( Validator.isNotNull(gioiTinh)) {
			userRequest.put("IDGIOITINH", gioiTinh);
		}
		
		String danToc = ParamUtil.getString(actionRequest, "danToc");
		if ( Validator.isNotNull(danToc)) {
			userRequest.put("IDDANTOC", danToc);
		}
		
		String tonGiao = ParamUtil.getString(actionRequest, "tonGiao");
		if ( Validator.isNotNull(tonGiao)) {
			userRequest.put("IDTONGIAO", tonGiao);
		}
		
		String quocTich = ParamUtil.getString(actionRequest, "quocTich");
		if ( Validator.isNotNull(quocTich)) {
			userRequest.put("IDQUOCTICH", String.valueOf(Constaints.VIETNAM));
		}
		
		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh");
		userRequest.put("NGAYSINH", ngaySinh);
	
		
		String tinhThuongTru = ParamUtil.getString(actionRequest, "tinhThuongTru");
		if ( Validator.isNotNull(tinhThuongTru)) {
			userRequest.put("IDTINHTHANHTHUONGTRU", tinhThuongTru);
		}
		
		String huyenThuongTru = ParamUtil.getString(actionRequest, "huyenThuongTru");
		if ( Validator.isNotNull(huyenThuongTru)) {
			userRequest.put("IDQUANHUYENTHUONGTRU", huyenThuongTru);
		}
		
		String xaThuongTru = ParamUtil.getString(actionRequest, "xaThuongTru");
		if ( Validator.isNotNull(xaThuongTru)) {
			userRequest.put("IDPHUONGXATHUONGTRU", xaThuongTru);
		}
		
		String motaThuongTru = ParamUtil.getString(actionRequest, "motaThuongTru").trim();
		userRequest.put("MOTADIACHITHUONGTRU", motaThuongTru);


		// Set the data back to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_OBJECT", userRequest);
		
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		
		// BinhNT add 2013-12-22 
		String reloadcapchar = ParamUtil.getString(actionRequest, "reloadcapchar").trim();
		if (reloadcapchar.trim().compareTo("reloadcapchar") == 0) {
			
			String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
			actionResponse.sendRedirect(redirectUrl);
			return;
		}

		// Validate captcha
		if ( !CheckCaptchaUtil.isTrue(actionRequest, "captcha") ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.captcha");	
		}
		
		// Check Ho cong dan
		if (Validator.isNull(hoCongDan)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.hoCongDan");
		}
		
		// Check ten cong dan
		if (Validator.isNull(tenCongDan)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tenCongDan");
		}
		
		// Check so cmnd
		if (Validator.isNull(soCmnd) || !Validator.isNumber(soCmnd) ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.soCmnd");
		}
		
		// Check ngay cap CMND
		if (Validator.isNull(ngayCapCmnd) ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngayCapCmnd");
		}
		
		long noiCapCmnd1 = ParamUtil.getLong(actionRequest, "noiCapCmnd");
		// Check noi cap cmnd
		if (noiCapCmnd1 == 0) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.noiCapCmnd");
		}
		
		
		
		if (soCmnd.trim().length() < 9 || soCmnd.trim().length() > 12) {
			SessionErrors.add(actionRequest, "err.soCmndVoPhaiNamTrongKhoangTuChinDenMuoiHaiChuSo");
		}
				
		// Check email
		if (!Validator.isEmailAddress(email)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email");
		}		
		
		// Check gioi tinh
		if (Validator.isNull(gioiTinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.gioiTinh");
		}
	
		// Check ngay sinh
		if (Validator.isNull(ngaySinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngaySinh");
		}
		

		// Check tinh thuong tru
		if (Validator.isNull(tinhThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tinhThuongTru");
		}
		
		// Check huyen thuong tru
		if (Validator.isNull(huyenThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.huyenThuongTru");
		}
		
		// Check xa thuong tru
		if (Validator.isNull(xaThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.xaThuongTru");
		}

		
		// Check mo ta dia chi thuong tru
		if (Validator.isNull(motaThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.motaThuongTru");
		}
		
	
		// In case there's error		
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if ( !SessionErrors.isEmpty(actionRequest)) {
			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
		// Check data against DB
		
		// Validate birth date
		
		Date birthDate = null;
		
		try {
			birthDate =  DateUtil.parseStringToDate(ngaySinh);
		} catch (Exception e) {
			// Error never happen so this exception will be swallow
		}
		
		if ( birthDate.compareTo(new Date()) > 0) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngaySinh.greaterThanCurrent");
		}
		
	
		List<CongDan> congDan = CongDanLocalServiceUtil.findByEmail(email);
		if (congDan.size() > 0){
			if (this.cmndExists(soCmnd)) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.requestExists");
			}
			// Check email if exists in CSMS cong dan
			if ( this.checkExistEmail(email)) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email.alreadyOwned");
			}
			
		}
		
		if ( !SessionErrors.isEmpty(actionRequest)) {
			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
			
		String maCongDan = this.checkExistCitizen(soCmnd, ngaySinh);
		
		// Generate authentication code
		//String authCode = AuthenticateCodeUtil.generateAuthCode();
		String authCode = ParamUtil.getString(actionRequest, "authCode");
		// Update yeu cau dang ky to DB		
		//long reqId = this.createUserRequest(maCongDan, authCode, userRequest, actionRequest);
		this.createYeuCauDangKy(maCongDan, authCode, userRequest, actionRequest);
		// Update profile picture
		//this.updateAnhChanDung(reqId, actionRequest);
		actionRequest.getPortletSession().removeAttribute("PROFILE_PIC");
		
		actionRequest.getPortletSession().removeAttribute("USER_REQUEST_OBJECT");
		
		String accountCreationUrl = ParamUtil.getString(actionRequest, "accountCreationUrl");
		
		accountCreationUrl = accountCreationUrl.replace("DUMMY_AUTH_CODE", authCode);
		
		accountCreationUrl.replace("Userregistrationportlet_WAR_cmonappportlet", "");
		// Send email and redirect
		if ( Validator.isNotNull(maCongDan)){	
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email.alreadyOwned");
			
		}
		
		// Redirect to success URL
		String citizenRegisterSuccessUrl = ParamUtil.getString(actionRequest, "citizenRegisterSuccessUrl");
		
		actionResponse.sendRedirect(citizenRegisterSuccessUrl);	
		
	}
	
	
	
	/** 
	
	 * This is function create request registration  
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Thanh .Do    Create new
	
	 * @param maCongDan
	 * @param authCode
	 * @param userRequest
	 * @param request
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 */
	private void createYeuCauDangKy(String maCongDan, String authCode, Map<String, String> userRequest, ActionRequest request) throws SystemException, ParseException, PortalException {
		
		YeuCauDangKyCongDan yeuCau = new YeuCauDangKyCongDanClp();
		
		yeuCau.setId(CounterLocalServiceUtil.increment(CSMS_YEUCAUDANGKYCONGDAN_SEQUENCE));
		
		Date currentDate = new Date();
		yeuCau.setNgayYeuCau(currentDate);
		
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
		
		yeuCau.setEmail(userRequest.get("EMAIL"));
		
		
		Date birthDay = DateUtil.parseStringToDate(userRequest.get("NGAYSINH"));
		
		yeuCau.setNgaySinh(birthDay);
		
		yeuCau.setLoaiYeuCau(ACCOUNT_AND_CITIZEN_TYPE); // 1: Generate account immediately
		
		yeuCau.setTrangThaiYeuCau(0); // 0: Newly
		
		yeuCau.setXoa(0);
		
		yeuCau.setNgayTao(currentDate);
		
		yeuCau.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(request);
		
		if ( currentUser != null) {		
			yeuCau.setNguoiTao(currentUser.getFullName());
			
			yeuCau.setNguoiSua(currentUser.getFullName());			
		} else {
			yeuCau.setNguoiTao("DUMMY");
			
			yeuCau.setNguoiSua("DUMMY");
		}
		
		yeuCau.setMaCongDan(maCongDan);
		
		yeuCau.setMaXacNhan(authCode);
		
		// ngaySinh - String
		String ngayCapCmnd = ParamUtil.getString(request, "ngayCapCmnd").trim();
		yeuCau.setNgayCapCmnd(DateUtil.parseStringToDate(ngayCapCmnd));

		// soCmnd - String
		long noiCapCmnd = ParamUtil.getLong(request, "noiCapCmnd");
		yeuCau.setIDNoiCapCmnd(noiCapCmnd);
		
		// gioiTinh - String
		int gioiTinh = ParamUtil.getInteger(request, "gioiTinh");
		yeuCau.setGioiTinh(gioiTinh);

		// gioiTinh - String
		long danToc = ParamUtil.getLong(request, "danToc");
		yeuCau.setIDDanToc(danToc);
		
		// tonGiao - String
		long tonGiao = ParamUtil.getLong(request, "tonGiao");
		yeuCau.setIDTonGiao(tonGiao);
		yeuCau.setIDQuocTich(Constaints.VIETNAM);
		// tinhThuongTru - String
		long tinhThuongTru = ParamUtil.getLong(request, "tinhThuongTru");
		yeuCau.setIDTinhThanhThuongTru(tinhThuongTru);
		
		// huyenThuongTru - String
		long huyenThuongTru = ParamUtil.getLong(request, "huyenThuongTru");
		yeuCau.setIDQuanHuyenThuongTru(huyenThuongTru);
		
		// xaThuongTru - String
		long xaThuongTru = ParamUtil.getLong(request, "xaThuongTru");
		yeuCau.setIDPhuongXaThuongTru(xaThuongTru);
				
		// motaThuongTru - String
		String motaThuongTru = ParamUtil.getString(request, "motaThuongTru").trim();
		yeuCau.setMoTaDiaChiThuongTru(motaThuongTru);

		// Insert to DB
		YeuCauDangKyCongDanLocalServiceUtil.addYeuCauDangKyCongDan(yeuCau);
	}
	
	
	
	/** 
	
	 * This is function check exit citizen in system
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Thanh .Do    Create new
	
	 * @param ho
	 * @param dem
	 * @param ten
	 * @param soCmnd
	 * @param ngaySinh
	 * @return
	 * @throws ParseException
	 */
	private String checkExistCitizen(String soCmnd, String ngaySinh) throws ParseException{
		
		
		Date birthDay =  DateUtil.parseStringToDate(ngaySinh);
		
		// Check in database if there's existing person with the same birth day and province code
		DynamicQuery queryCongDan = DynamicQueryFactoryUtil.forClass(CongDan.class);
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ngaySinh").eq(birthDay));
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
	
	

	/** 
	
	 * This is function check exit email  in system
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Thanh .Do    Create new
	**/
	
	private boolean checkExistEmail(String email) throws SystemException{
		if (Validator.isNull(email)) {
			return false;
		}
		
		// Query all cong dan with email
		List<CongDan> congDanLst = CongDanLocalServiceUtil.findByEmail(email);
		
		// Get the first one
		if ( congDanLst.size() < 1) {
			return false;
		}
		
		CongDan congDan = congDanLst.get(0);
		_log.info("email trong csms_congdan:" +congDan.getEmail());
		
		// Check if email exists
		if ( email.equals(congDan.getEmail())) {
			// Check if email is owned by another person or not
			return true;		
		}
		
		return false;		
	}
	
	
	
	
	
/** 
	
	 * This is function check exit cmnd  in system
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Thanh .Do    Create new
	**/
	private boolean cmndExists(String soCmnd) {

		if (Validator.isNull(soCmnd)) {
			return false;
		}
		
		// Query all cong dan with email
		List<CongDan> congDanLst = null;
	
		congDanLst = CongDanLocalServiceUtil.findByCMND(soCmnd);
		
		// Get the first one
		if ( congDanLst.size() < 1) {
			return false;
		}
		
		CongDan congDan = congDanLst.get(0);
		_log.info("so smnd trong csms_congdan:" +congDan.getSoCmnd());
		
		// Check if email exists
		if ( soCmnd.equals(congDan.getSoCmnd())) {
			// Check if email is owned by another person or not
			return true;		
		}
		
		return false;		
	}
	
	
	
	
	/**
	 * This method will handle event when user click to a link in mail
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception 
	 */
	public void endorse(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		String jspErrPage = "/html/portlet/registration/err_page.jsp";
		
		String jspSuccessPage = "/html/portlet/registration/success_page.jsp";
				
		String authCode = ParamUtil.getString(actionRequest, "authCode");
		System.out.println("authCode in endorse:" +authCode);
		// Check parameter
		if (Validator.isNull(authCode)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.endorse.err.request.notExists");
		}
		
		// Check if yeu cau exists in DB
		 List<YeuCauDangKyCongDan> yeuCauLst = YeuCauDangKyCongDanLocalServiceUtil.findByMaXacNhan(authCode);
		 
		 if ( yeuCauLst.size() < 1) {
			 SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.endorse.err.request.notExists");
		 }
		 
		// Take the first record
		 YeuCauDangKyCongDan yeuCau = yeuCauLst.get(0);

		 
		 // Check loai yeu cau
		 int type = yeuCau.getLoaiYeuCau();
		 if (type == ACCOUNT_AND_CITIZEN_TYPE) {
			 yeuCau.setTrangThaiYeuCau(1); // 1: Email confirmed
			 
			 // Update the request
			 YeuCauDangKyCongDanLocalServiceUtil.updateYeuCauDangKyCongDan(yeuCau);
			 
			 // Redirect
			 actionResponse.setRenderParameter("jspPage", jspSuccessPage);
			 //actionResponse.sendRedirect(jspSuccessPage);
			 actionResponse.setRenderParameter("type", "0");
			 actionResponse.setRenderParameter("authCode", authCode);
				
			//return;
		 }
		 
			
	}
	
	/** 
	
	 * This is save request registration 
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Thanh .Do    Create new
	**/
	
	
	public void saveYeuCauDangKyCongDan(ActionRequest actionRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		
		String soCmnd = ParamUtil.getString(actionRequest, "soCmnd").trim();
		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh").trim();
		
		// email - String
		String email = ParamUtil.getString(actionRequest, "email").trim();
		// ho - String
		String ho = ParamUtil.getString(actionRequest, "ho").trim();
		// email - String
		String dem = ParamUtil.getString(actionRequest, "dem").trim();
		// ho - String
		String ten = ParamUtil.getString(actionRequest, "ten").trim();

		if (validatorsYeuCauDangKyCongDan(actionRequest)) {
			saveYeuCauDangKyCongDanToDB(actionRequest, httpReq);

			String maCongDan = this.checkExistCitizen(soCmnd, ngaySinh);
			// Generate authentication code
			String authCode = AuthenticateCodeUtil.generateAuthCode();
			
			String accountCreationUrl = ParamUtil.getString(actionRequest, "accountCreationUrl");
			
			accountCreationUrl = accountCreationUrl.replace("DUMMY_AUTH_CODE", authCode);
			
			String uri =  actionRequest.getScheme() + "://" +   actionRequest.getServerName() ;
			// Send email and redirect
			if ( Validator.isNotNull(maCongDan)){			
				// Send email here
				
				
				// Redirect to success page	
				String accountRegisterSuccessUrl = ParamUtil.getString(actionRequest, "accountRegisterSuccessUrl");
				
				// Redirect to account register success page
				httpReq.sendRedirect(accountRegisterSuccessUrl);
				
				return;
			}
			
			// Send email incase of register both citizen and account
				
			
			// Redirect to success URL
			String citizenRegisterSuccessUrl = ParamUtil.getString(actionRequest, "citizenRegisterSuccessUrl");
			
			httpReq.sendRedirect(citizenRegisterSuccessUrl);
			
		} else {
			
			httpReq.setRenderParameter("jspPage", "/html/portlet/registration/input_detail_exist_congdan.jsp");
		}
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
/** 
	
	 * This is function validator info registration
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Thanh .Do    Create new
	**/
	private static boolean validatorsYeuCauDangKyCongDan(ActionRequest actionRequest) throws SystemException {
		boolean valid = true;
		
		// Validate captcha
		if ( !CheckCaptchaUtil.isTrue(actionRequest, "captcha") ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.captcha");	
			valid = false;
		}
		
		// Check Ho cong dan
		String ho = ParamUtil.getString(actionRequest, "ho").trim();
		if (Validator.isNull(ho)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.hoCongDan");
			valid = false;
		}
		
		// Check ten cong dan
		String ten = ParamUtil.getString(actionRequest, "ten").trim();
		if (Validator.isNull(ten)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tenCongDan");
			valid = false;
		}
		
		// Check so cmnd
		String soCmnd = ParamUtil.getString(actionRequest, "soCmnd").trim();
		if (Validator.isNull(soCmnd) || !Validator.isNumber(soCmnd) ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.soCmnd");
			valid = false;
		}
		
		// Check ngay cap CMND
		String ngayCapCmnd = ParamUtil.getString(actionRequest, "ngayCapCmnd").trim();
		if (Validator.isNull(ngayCapCmnd) ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngayCapCmnd");
			valid = false;
		}
		
		// Check noi cap cmnd
		long noiCapCmnd = ParamUtil.getLong(actionRequest, "noiCapCmnd");
		if (noiCapCmnd ==0) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.noiCapCmnd");
		}
		

		if (soCmnd.trim().length() < 9 || soCmnd.trim().length() > 12) {
			SessionErrors.add(actionRequest, "err.soCmndVoPhaiNamTrongKhoangTuChinDenMuoiHaiChuSo");
			valid = false;
		}
				
		// Check email
		String email = ParamUtil.getString(actionRequest, "email").trim();
		if (!Validator.isEmailAddress(email)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email");
			valid = false;
		}		

		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh").trim();
		if (Validator.isNull(ngaySinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngaySinh");
			valid = false;
		}
		
		String tinhThuongTru = ParamUtil.getString(actionRequest, "tinhThuongTru");
		String huyenThuongTru = ParamUtil.getString(actionRequest, "huyenThuongTru");
		String xaThuongTru = ParamUtil.getString(actionRequest, "xaThuongTru");
		
		String motaThuongTru = ParamUtil.getString(actionRequest, "motaThuongTru").trim();
		if (Validator.isNull(motaThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.motaThuongTru");
			valid = false;
		}
		
		if (Validator.isNull(tinhThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tinhThuongTru");
			valid = false;
		}
		
		// Check huyen thuong tru
		if (Validator.isNull(huyenThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.huyenThuongTru");
			valid = false;
		}
		
		// Check xa thuong tru
		if (Validator.isNull(xaThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.xaThuongTru");
			valid = false;
		}
		
		// Check data against DB
		
		// Validate birth date
		
		Date birthDate = null;
		
		try {
			birthDate =  DateUtil.parseStringToDate(ngaySinh);
		} catch (Exception e) {
			// Error never happen so this exception will be swallow
		}
		
		if ( birthDate.compareTo(new Date()) > 0) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngaySinh.greaterThanCurrent");
			valid = false;
		}
		


		if (!valid) {
			UserParamUtil.setParams(actionRequest);
			Iterator<String> error = SessionErrors.iterator(actionRequest);
			while (error.hasNext()) {
				_log.info("validate false :"+ error.next());

			}
		}
		return valid;
	}
	
/** 
	
	 * This is function save registration to database
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Thanh .Do    Create new
	**/
	
	public static YeuCauDangKyCongDan saveYeuCauDangKyCongDanToDB(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		long idYeuCauDangKyCongDan = ParamUtil.getLong(resourceRequest, "yeuCauDangKyCongDanId");
		
		YeuCauDangKyCongDan yeuCauDangKyCongDan =null;
		
		
		if (idYeuCauDangKyCongDan > 0) {
			yeuCauDangKyCongDan = YeuCauDangKyCongDanLocalServiceUtil.fetchYeuCauDangKyCongDan(idYeuCauDangKyCongDan);
		} else {
			yeuCauDangKyCongDan = new YeuCauDangKyCongDanClp();
			yeuCauDangKyCongDan.setId(CounterLocalServiceUtil.increment(CSMS_YEUCAUDANGKYCONGDAN_SEQUENCE));
		}

		// email - String
		String email = ParamUtil.getString(resourceRequest, "email").trim();
		yeuCauDangKyCongDan.setEmail(email);

		// ho - String
		String ho = ParamUtil.getString(resourceRequest, "ho").trim();
		yeuCauDangKyCongDan.setHoCongDan(ho);
		
		// email - String
		String dem = ParamUtil.getString(resourceRequest, "dem").trim();
		yeuCauDangKyCongDan.setTenDem(dem);

		// ho - String
		String ten = ParamUtil.getString(resourceRequest, "ten").trim();
		yeuCauDangKyCongDan.setTenCongDan(ten);
		
		// ngaySinh - String
		String ngaySinh = ParamUtil.getString(resourceRequest, "ngaySinh").trim();
		yeuCauDangKyCongDan.setNgaySinh(DateUtil.parseStringToDate(ngaySinh));

		// soCmnd - String
		String soCmnd = ParamUtil.getString(resourceRequest, "soCmnd").trim();
		yeuCauDangKyCongDan.setSoCmnd(soCmnd);
		
		// ngaySinh - String
		String ngayCapCmnd = ParamUtil.getString(resourceRequest, "ngayCapCmnd").trim();
		yeuCauDangKyCongDan.setNgayCapCmnd(DateUtil.parseStringToDate(ngayCapCmnd));

		// soCmnd - String
		long noiCapCmnd = ParamUtil.getLong(resourceRequest, "noiCapCmnd");
		yeuCauDangKyCongDan.setIDNoiCapCmnd(noiCapCmnd);
		
		// gioiTinh - String
		int gioiTinh = ParamUtil.getInteger(resourceRequest, "gioiTinh");
		yeuCauDangKyCongDan.setGioiTinh(gioiTinh);

		// gioiTinh - String
		long danToc = ParamUtil.getLong(resourceRequest, "danToc");
		yeuCauDangKyCongDan.setIDDanToc(danToc);
		
		// tonGiao - String
		long tonGiao = ParamUtil.getLong(resourceRequest, "tonGiao");
		yeuCauDangKyCongDan.setIDTonGiao(tonGiao);
		
		// tinhThuongTru - String
		long tinhThuongTru = ParamUtil.getLong(resourceRequest, "tinhThuongTru");
		yeuCauDangKyCongDan.setIDTinhThanhThuongTru(tinhThuongTru);
		
		// huyenThuongTru - String
		long huyenThuongTru = ParamUtil.getLong(resourceRequest, "huyenThuongTru");
		yeuCauDangKyCongDan.setIDQuanHuyenThuongTru(huyenThuongTru);
		
		// xaThuongTru - String
		long xaThuongTru = ParamUtil.getLong(resourceRequest, "xaThuongTru");
		yeuCauDangKyCongDan.setIDPhuongXaThuongTru(xaThuongTru);
				
		// motaThuongTru - String
		String motaThuongTru = ParamUtil.getString(resourceRequest, "motaThuongTru").trim();
		yeuCauDangKyCongDan.setMoTaDiaChiThuongTru(motaThuongTru);

		if (idYeuCauDangKyCongDan > 0) {
			yeuCauDangKyCongDan = YeuCauDangKyCongDanLocalServiceUtil.updateYeuCauDangKyCongDan(yeuCauDangKyCongDan);
		} else {
			yeuCauDangKyCongDan = YeuCauDangKyCongDanLocalServiceUtil.addYeuCauDangKyCongDan(yeuCauDangKyCongDan);
		}
		return yeuCauDangKyCongDan;
	}
}
