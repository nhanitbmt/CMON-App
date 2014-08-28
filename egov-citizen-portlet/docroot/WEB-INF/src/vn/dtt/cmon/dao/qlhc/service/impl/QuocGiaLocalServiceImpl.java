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

import vn.dtt.cmon.dao.qlhc.NoSuchQuocGiaException;
import vn.dtt.cmon.dao.qlhc.model.QuocGia;
import vn.dtt.cmon.dao.qlhc.service.base.QuocGiaLocalServiceBaseImpl;

/**
 * The implementation of the quoc gia local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.qlhc.service.QuocGiaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see vn.dtt.cmon.dao.qlhc.service.base.QuocGiaLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil
 */
public class QuocGiaLocalServiceImpl extends QuocGiaLocalServiceBaseImpl {

	@Override
	public List<QuocGia> findAll() throws SystemException {
		return quocGiaFinder.findAll();
	}
	
	public QuocGia findByMaQuocGia(String ma) throws SystemException, NoSuchQuocGiaException {
			return quocGiaPersistence.findByMaQuocGia(ma);
	}
	
	public QuocGia findByTen(String ten) throws SystemException, NoSuchQuocGiaException {
		return quocGiaPersistence.findByTen(ten);
		
	}
	
	public List<QuocGia> findByDaXoa(int daXoa) throws SystemException, NoSuchQuocGiaException {
		return quocGiaFinder.findAll();
		
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil} to access the quoc gia local service.
	 */
}