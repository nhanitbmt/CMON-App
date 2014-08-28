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

import com.liferay.portal.kernel.exception.SystemException;

import vn.dtt.cmon.dao.cd.model.DoiTuongSuDung;
import vn.dtt.cmon.dao.cd.service.base.DoiTuongSuDungLocalServiceBaseImpl;


/**
 * The implementation of the doi tuong su dung local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.cd.service.DoiTuongSuDungLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see vn.dtt.cmon.dao.cd.service.base.DoiTuongSuDungLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.cd.service.DoiTuongSuDungLocalServiceUtil
 */
public class DoiTuongSuDungLocalServiceImpl
	extends DoiTuongSuDungLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.cd.service.DoiTuongSuDungLocalServiceUtil} to access the doi tuong su dung local service.
	 */
	
	/**
	 * This is function find DoiTuongSuDung by Ma (Congdan,DoanhNgiep,HoCathe,HTX,Tochuc)
	 * @author Thanh.Do
	 * @date 11/11/2013
	 * @param: ngaySinh
	 * @param: soCmnd 
	 * @return null if not found
	 */
	public DoiTuongSuDung findByMa(String ma) throws SystemException {
		return doiTuongSuDungPersistence.fetchByMa(ma);
	}
}