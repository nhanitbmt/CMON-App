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

package vn.dtt.cmon.dao.cd.service.impl;

import java.util.List;

import vn.dtt.cmon.dao.cd.model.CongDan;
import vn.dtt.cmon.dao.cd.service.base.CongDanLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the cong dan local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.cd.service.CongDanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see vn.dtt.cmon.dao.cd.service.base.CongDanLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.cd.service.CongDanLocalServiceUtil
 */
public class CongDanLocalServiceImpl extends CongDanLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.cd.service.CongDanLocalServiceUtil} to access the cong dan local service.
	 */
	
	/**
	 * This is function find CongDan by cmnd
	 * @author Hung.hoang
	 * @date 11/09/2013
	 * @param soCmnd 
	 * @return null if not found
	 */
	public List<CongDan> findByCMND(String soCmnd){
		try {
			return congDanPersistence.findBySoCmnd(soCmnd);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			//not found return null;
			return null;
		}		
	}
	
	/**
	 * This is function find CongDan by email
	 * @author Hung.hoang
	 * @date 11/09/2013
	 * @param email 
	 * @return null if not found
	 */
	public List<CongDan> findByEmail(String email){
		try {
			return congDanPersistence.findByEmail(email);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			//not found return null
			return null;
		}
		
	}
	/**
	 * This is function find CongDan by ma
	 * @author Hung.hoang
	 * @date 11/09/2013
	 * @param ma of citizen 
	 * @return null if not found
	 */
	public CongDan findByMa(String ma){
		try {
			return congDanPersistence.fetchByMa(ma);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
	
	/**
	 * This is function find CongDan by Ngay sinh And soCMND
	 * @author Hung.hoang
	 * @date 11/09/2013
	 * @param: ngaySinh
	 * @param: soCmnd 
	 * @return null if not found
	 */
	
	public CongDan findByNgaySinhAndSoCMND(java.util.Date ngaySinh, String soCmnd){
		
		try {
			return congDanPersistence.findByNgaySinh(ngaySinh, soCmnd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//return if not found
			return null;
		}
	}
}