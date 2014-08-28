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

import vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException;
import vn.dtt.cmon.dao.qlhc.model.CapDonViHanhChinh;
import vn.dtt.cmon.dao.qlhc.service.base.CapDonViHanhChinhLocalServiceBaseImpl;

/**
 * The implementation of the cap don vi hanh chinh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.qlhc.service.CapDonViHanhChinhLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see vn.dtt.cmon.dao.qlhc.service.base.CapDonViHanhChinhLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.qlhc.service.CapDonViHanhChinhLocalServiceUtil
 */
public class CapDonViHanhChinhLocalServiceImpl
	extends CapDonViHanhChinhLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.qlhc.service.CapDonViHanhChinhLocalServiceUtil} to access the cap don vi hanh chinh local service.
	 */
	public List<CapDonViHanhChinh> findAll() throws SystemException {
		return capDonViHanhChinhPersistence.findAll();
	}
	public CapDonViHanhChinh findByMaCapDonViHanhChinh(String ma) throws SystemException, NoSuchCapDonViHanhChinhException {
		return capDonViHanhChinhPersistence.findByMaDonViHanhChinh(ma);
	}
	
	public CapDonViHanhChinh findByTenCapDonViHanhChinh(String ten) throws SystemException, NoSuchCapDonViHanhChinhException {
		return capDonViHanhChinhPersistence.findByTenDonViHanhChinh(ten);
		
	}
	
	public List<CapDonViHanhChinh> findByDaXoa(int daXoa) throws SystemException {
		return capDonViHanhChinhPersistence.findByTrangThai(daXoa);
	}
	
	public List<CapDonViHanhChinh> findByCap(long cap) throws SystemException {
		return capDonViHanhChinhPersistence.findByCap(cap);
	}
}