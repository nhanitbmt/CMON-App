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


package vn.dtt.cmon.dao.qlhc.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import vn.dtt.cmon.dao.qlhc.NoSuchDonViHanhChinhException;
import vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh;
import vn.dtt.cmon.dao.qlhc.service.base.DonViHanhChinhLocalServiceBaseImpl;
import vn.dtt.cmon.dao.qlhc.service.persistence.DonViHanhChinhFinderUtil;

/**
 * The implementation of the don vi hanh chinh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.qlhc.service.DonViHanhChinhLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see vn.dtt.cmon.dao.qlhc.service.base.DonViHanhChinhLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil
 */
public class DonViHanhChinhLocalServiceImpl
	extends DonViHanhChinhLocalServiceBaseImpl {

	public List<DonViHanhChinh> findByChaId(long chaId,int daXoa){

		try {
			return donViHanhChinhPersistence.findByChaId(chaId,daXoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<DonViHanhChinh> findByQuocGiaId(long quocGiaId, long capDonViHanhChinhId, int daXoa){

		try {
			return donViHanhChinhPersistence.findByByQuocId(quocGiaId, capDonViHanhChinhId, daXoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<DonViHanhChinh> findByDaXoa(int daXoa) throws SystemException {

		return donViHanhChinhPersistence.findByTrangThai(daXoa);
	}
	
	public DonViHanhChinh findByMaDVHC(String ma) throws SystemException, NoSuchDonViHanhChinhException {

		return donViHanhChinhPersistence.findByMaDVHC(ma);
	}
	
	public DonViHanhChinh findByTenDVHC(String ten) throws SystemException, NoSuchDonViHanhChinhException {

		return donViHanhChinhPersistence.findByTenDVHC(ten);
	}
	
	public java.util.List<vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh> getDanhSachTinhThanh(){
		return DonViHanhChinhFinderUtil.dsTinhThanh();
	}
	
	public List<DonViHanhChinh> getDSDonViHanhChinhTheoCapId(Long capId,int daXoa){
		try {
			return donViHanhChinhPersistence.findByCapDonViHanhChinhId(capId, daXoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil} to access the don vi hanh chinh local service.
	 */
}