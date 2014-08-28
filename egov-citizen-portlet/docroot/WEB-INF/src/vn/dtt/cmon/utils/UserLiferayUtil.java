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

package vn.dtt.cmon.utils;

import java.util.List;

import vn.dtt.cmon.dao.cd.model.DoiTuongSuDung;
import vn.dtt.cmon.dao.cd.service.DoiTuongSuDungLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

/** 
 * User UserLiferayUtil class
 * 
 * This class utils adapter with user in liferay
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  24-April-2013  Liem.Nham    Create new
 */

public class UserLiferayUtil {
	private static Log _log = LogFactoryUtil.getLog(UserLiferayUtil.class);
	
	/** 
	 * This is function get Organization of liferay by name
	 * @param companyId
	 * @param name of organization 
	
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Liem.Nham    Create new
	 *  @return Organization if exist, return null if not found
	 */

	public static Organization getOrganization(long companyId,String name){
		if(name == null || name.trim().length()==0)return null;
		List<Organization> oList = null;
		try {
			oList = OrganizationLocalServiceUtil.getOrganizations(0, 90000);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
		
		}
		if(oList != null && oList.size()>0){
			for (Organization organization : oList) {
				_log.info("\n.==:"+organization.getName());
				if(organization.getName().toLowerCase().equals(name.toLowerCase())){
					return organization;
				}
			}
		}else{
			_log.info("not found by name:"+name);
			return null;
			
		}
		return null;
		
	}
	
	
	/** 
	 * This is function return organization for citizen 
	
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  24-April-2013  Liem.Nham    Create new
	 *  @return Name of orgcitizen
	 * @throws SystemException 
	 */
	public static  String getOrganizationNameOfCitizen() throws SystemException {
		
		DoiTuongSuDung doiTuong =null;
		try {
			doiTuong = DoiTuongSuDungLocalServiceUtil
					.findByMa(Constaints.ORGANIZATION_CITIZEN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(doiTuong == null){
			doiTuong = DoiTuongSuDungLocalServiceUtil.fetchDoiTuongSuDung(1L);
		}
		
		// Get ten doi tuong as organization name
		return doiTuong.getTen();
	}

}
