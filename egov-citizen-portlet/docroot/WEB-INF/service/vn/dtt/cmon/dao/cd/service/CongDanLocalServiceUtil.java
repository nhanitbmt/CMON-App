/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.dtt.cmon.dao.cd.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the cong dan local service. This utility wraps {@link vn.dtt.cmon.dao.cd.service.impl.CongDanLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNN
 * @see CongDanLocalService
 * @see vn.dtt.cmon.dao.cd.service.base.CongDanLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.cd.service.impl.CongDanLocalServiceImpl
 * @generated
 */
public class CongDanLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.dtt.cmon.dao.cd.service.impl.CongDanLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the cong dan to the database. Also notifies the appropriate model listeners.
	*
	* @param congDan the cong dan
	* @return the cong dan that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.CongDan addCongDan(
		vn.dtt.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCongDan(congDan);
	}

	/**
	* Creates a new cong dan with the primary key. Does not add the cong dan to the database.
	*
	* @param id the primary key for the new cong dan
	* @return the new cong dan
	*/
	public static vn.dtt.cmon.dao.cd.model.CongDan createCongDan(long id) {
		return getService().createCongDan(id);
	}

	/**
	* Deletes the cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cong dan
	* @throws PortalException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCongDan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCongDan(id);
	}

	/**
	* Deletes the cong dan from the database. Also notifies the appropriate model listeners.
	*
	* @param congDan the cong dan
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCongDan(vn.dtt.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCongDan(congDan);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static vn.dtt.cmon.dao.cd.model.CongDan fetchCongDan(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCongDan(id);
	}

	/**
	* Returns the cong dan with the primary key.
	*
	* @param id the primary key of the cong dan
	* @return the cong dan
	* @throws PortalException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.CongDan getCongDan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCongDan(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.cmon.dao.cd.model.CongDan> getCongDans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCongDans(start, end);
	}

	/**
	* Returns the number of cong dans.
	*
	* @return the number of cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int getCongDansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCongDansCount();
	}

	/**
	* Updates the cong dan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congDan the cong dan
	* @return the cong dan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.CongDan updateCongDan(
		vn.dtt.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCongDan(congDan);
	}

	/**
	* Updates the cong dan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congDan the cong dan
	* @param merge whether to merge the cong dan with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cong dan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.CongDan updateCongDan(
		vn.dtt.cmon.dao.cd.model.CongDan congDan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCongDan(congDan, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is function find CongDan by cmnd
	*
	* @author Hung.hoang
	* @date 11/09/2013
	* @param soCmnd
	* @return null if not found
	*/
	public static java.util.List<vn.dtt.cmon.dao.cd.model.CongDan> findByCMND(
		java.lang.String soCmnd) {
		return getService().findByCMND(soCmnd);
	}

	/**
	* This is function find CongDan by email
	*
	* @author Hung.hoang
	* @date 11/09/2013
	* @param email
	* @return null if not found
	*/
	public static java.util.List<vn.dtt.cmon.dao.cd.model.CongDan> findByEmail(
		java.lang.String email) {
		return getService().findByEmail(email);
	}

	/**
	* This is function find CongDan by ma
	*
	* @author Hung.hoang
	* @date 11/09/2013
	* @param ma of citizen
	* @return null if not found
	*/
	public static vn.dtt.cmon.dao.cd.model.CongDan findByMa(java.lang.String ma) {
		return getService().findByMa(ma);
	}

	/**
	* This is function find CongDan by Ngay sinh And soCMND
	*
	* @author Hung.hoang
	* @date 11/09/2013
	* @param: ngaySinh
	* @param: soCmnd
	* @return null if not found
	*/
	public static vn.dtt.cmon.dao.cd.model.CongDan findByNgaySinhAndSoCMND(
		java.util.Date ngaySinh, java.lang.String soCmnd) {
		return getService().findByNgaySinhAndSoCMND(ngaySinh, soCmnd);
	}

	public static void clearService() {
		_service = null;
	}

	public static CongDanLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CongDanLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CongDanLocalService.class.getName(), portletClassLoader);

			_service = new CongDanLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CongDanLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CongDanLocalService.class);
		}

		return _service;
	}

	public void setService(CongDanLocalService service) {
		MethodCache.remove(CongDanLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CongDanLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CongDanLocalService.class);
	}

	private static CongDanLocalService _service;
}