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

package vn.dtt.cmon.dao.nsd.service.impl;

import java.util.List;

import vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import vn.dtt.cmon.dao.nsd.service.base.TaiKhoanNguoiDungLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the tai khoan nguoi dung local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see vn.dtt.cmon.dao.nsd.service.base.TaiKhoanNguoiDungLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil
 */
public class TaiKhoanNguoiDungLocalServiceImpl
	extends TaiKhoanNguoiDungLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil} to access the tai khoan nguoi dung local service.
	 */
	
	/**
	 * This is function  TaiKhoanNguoiDung by tenDangnhap 
	 * @author Liem.Nham
	 * @date 18/09/2013	 *
	 * @return null if not found
	 */
	public TaiKhoanNguoiDung findByTenDangNhap(String tenDangNhap) {
		try {
			return taiKhoanNguoiDungPersistence.findByTenDangNhap(tenDangNhap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return null;
		
	}
	
	/**
	 * This is function  TaiKhoanNguoiDung by email
	 * @author Liem.Nham
	 * @date 18/09/2013	 *
	 * @return null if not found
	 */
	public List<TaiKhoanNguoiDung> findByEmail(String email){
		try {
			return taiKhoanNguoiDungPersistence.findByEmail(email);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
	}
	
	
	public TaiKhoanNguoiDung fetchByLiferayUserId(long liferayUserId) {
		try{
			List<TaiKhoanNguoiDung> list = taiKhoanNguoiDungPersistence.findByTaiKhoanNguoiDung(liferayUserId, 0);
			if (list != null && list.size()>0) {
				return list.get(0);
			} else {
				return null;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	

}