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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import vn.dtt.cmon.dao.cd.model.YeuCauDangKyCongDan;
import vn.dtt.cmon.dao.cd.service.YeuCauDangKyCongDanLocalServiceUtil;
import vn.dtt.cmon.utils.UserLiferayUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/** 
 * CitizenUserBs class
 * 
 * This class is used to create an user in liferay portal
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CitizenUserBs {
	
	/** User full name */
	private String fullName = StringPool.BLANK;
	
	/** User birth date */
	private Date birthDate = null;
	
	/** Email */
	private String email = StringPool.BLANK;
	
	/** Avatar */
	private byte[] avatar = new byte[0]; 
	

	
	/** 
	 * This is function create account in lifeay and assign citizen group
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 
	 * @param password
	 * @param themeDisplay
	 * @throws IOException
	 * @throws SystemException
	 * @throws PortalException
	 */
	public long createCitizenInLiferay(String password, ThemeDisplay themeDisplay, YeuCauDangKyCongDan yeuCau) throws IOException, SystemException, PortalException{
		 
		long companyId = themeDisplay.getCompanyId();
		
		// Check if user exists		
		User existUser = null;
		try {
			existUser = UserLocalServiceUtil.getUserByEmailAddress(companyId, this.email);
		} catch (Exception e) {
			// This is the problem of fucking version of LF, when an user doest not exist, it will throw
			// exception instead of return null
		}		
		
		
		// Update the existing user incase user found
		String organizationCitizenName = UserLiferayUtil.getOrganizationNameOfCitizen();
		
		if ( existUser != null ) {
			UserLocalServiceUtil.updatePassword(existUser.getUserId(), password, password, true);
			// Update portrait
			if (this.avatar.length > 0) {
				UserLocalServiceUtil.updatePortrait(existUser.getUserId(), this.avatar);
			}
			 organizationCitizenName = UserLiferayUtil.getOrganizationNameOfCitizen();
			// Update organization
			Organization organization = UserLiferayUtil.getOrganization(companyId,organizationCitizenName);
			long[] orgIds= {organization.getOrganizationId()};
			UserLocalServiceUtil.updateOrganizations(existUser.getUserId(), orgIds, new ServiceContext());	
			return existUser.getUserId();
		}
		
		// Create new user here
		long creatorUserId = 0;
		boolean autoPassword = false;
		// Lower case the password
		password = password.toLowerCase();
		String password1 = password;
		String password2 = password;
		
		//boolean autoScreenName = true;
		boolean autoScreenName = false;
		
		long userId = CounterLocalServiceUtil.increment(User.class.getName());
		String screenName = "cd"+userId;
		System.out.println("\n==== screenName" + screenName);
		
		String emailAddress = this.email;
		long facebookId = 0;
		String openId = StringPool.BLANK;
		Locale locale = LocaleUtil.getDefault();
		String firstName = this.fullName;
		String middleName = yeuCau.getTenDem();
		String lastName = yeuCau.getTenCongDan();
		
		int prefixId = 0;
		int suffixId = 0;
		boolean male = true; // Default is male
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.birthDate);
		int birthdayMonth = cal.get(Calendar.MONTH);
		int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
		int birthdayYear = cal.get(Calendar.YEAR);
		
		String jobTitle = StringPool.BLANK;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = false;
		ServiceContext serviceContext = new ServiceContext();
		
		// fix loi : LDAP: error code 65 - object class 'inetOrgPerson' requires attribute 'sn'...
		if (Validator.isNull(middleName)) {
			middleName = screenName;
		}
		User user = UserLocalServiceUtil.addUser(
			creatorUserId, companyId, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);

		UserLocalServiceUtil.updateLastLogin( user.getUserId(), user.getLoginIP());

		UserLocalServiceUtil.updatePasswordReset(user.getUserId(), true);

		UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), true);
		
		// Update portrait
		if (this.avatar.length > 0) {			
			UserLocalServiceUtil.updatePortrait(user.getUserId(), this.avatar);
		}		
		System.out.println("\n==== orgName:" + organizationCitizenName);
		// Add user to organization
		Organization organization = OrganizationLocalServiceUtil.getOrganization(companyId, organizationCitizenName);
		
		long[] userIds = {user.getUserId()};
				
		UserLocalServiceUtil.addOrganizationUsers(organization.getOrganizationId(), userIds);
		
		return user.getUserId();
	}
	
	
	
	/**
	 * This is function  search Yeucaudang ky by keyword "email, name, cmnd"
	 * 
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @param reqStatus
	 * @return
	 * @throws Exception
	 */
	
	public static List<YeuCauDangKyCongDan> searchUserRequest(String keyWord, int reqStatus) throws Exception {
		
		//String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		//int reqStatus = ParamUtil.getInteger(actionRequest, "reqStatus");

		System.out.println("\n===keyWord:" + keyWord + ":reqStatus:" + reqStatus);
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(YeuCauDangKyCongDan.class);
		
		Criterion criteriaCmnd = RestrictionsFactoryUtil.ilike("SoCmnd", "%" + keyWord + "%");
		Criterion criteriaEmail = RestrictionsFactoryUtil.ilike("Email", "%" + keyWord + "%");
		Criterion criteriaTenCongDan = RestrictionsFactoryUtil.ilike("HoVaTen", "%" + keyWord + "%");
		Criterion criteriaMaCongDan = RestrictionsFactoryUtil.ilike("MaCongDan", "%" + keyWord + "%");
		
		Criterion criteria1 = RestrictionsFactoryUtil.or(criteriaCmnd, criteriaEmail);
		Criterion criteria4 = RestrictionsFactoryUtil.or(criteria1, criteriaTenCongDan);
		Criterion criteria5 = RestrictionsFactoryUtil.or(criteria4, criteriaMaCongDan);
		
		query = query.add(criteria5);
		if (reqStatus > -1 ) {
			query = query.add(PropertyFactoryUtil.forName("TrangThaiYeuCau").eq(reqStatus));
		}
		query = query.add(PropertyFactoryUtil.forName("Xoa").eq(0));
		
		List<YeuCauDangKyCongDan> results = null;
		try {
			results = YeuCauDangKyCongDanLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the avatar
	 */
	public byte[] getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	
}
