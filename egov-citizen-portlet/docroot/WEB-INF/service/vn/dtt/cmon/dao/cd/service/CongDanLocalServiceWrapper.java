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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CongDanLocalService}.
 * </p>
 *
 * @author    LIEMNN
 * @see       CongDanLocalService
 * @generated
 */
public class CongDanLocalServiceWrapper implements CongDanLocalService,
	ServiceWrapper<CongDanLocalService> {
	public CongDanLocalServiceWrapper(CongDanLocalService congDanLocalService) {
		_congDanLocalService = congDanLocalService;
	}

	/**
	* Adds the cong dan to the database. Also notifies the appropriate model listeners.
	*
	* @param congDan the cong dan
	* @return the cong dan that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.cd.model.CongDan addCongDan(
		vn.dtt.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congDanLocalService.addCongDan(congDan);
	}

	/**
	* Creates a new cong dan with the primary key. Does not add the cong dan to the database.
	*
	* @param id the primary key for the new cong dan
	* @return the new cong dan
	*/
	public vn.dtt.cmon.dao.cd.model.CongDan createCongDan(long id) {
		return _congDanLocalService.createCongDan(id);
	}

	/**
	* Deletes the cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cong dan
	* @throws PortalException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCongDan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_congDanLocalService.deleteCongDan(id);
	}

	/**
	* Deletes the cong dan from the database. Also notifies the appropriate model listeners.
	*
	* @param congDan the cong dan
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCongDan(vn.dtt.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		_congDanLocalService.deleteCongDan(congDan);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congDanLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _congDanLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congDanLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congDanLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.dtt.cmon.dao.cd.model.CongDan fetchCongDan(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congDanLocalService.fetchCongDan(id);
	}

	/**
	* Returns the cong dan with the primary key.
	*
	* @param id the primary key of the cong dan
	* @return the cong dan
	* @throws PortalException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.cd.model.CongDan getCongDan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _congDanLocalService.getCongDan(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _congDanLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<vn.dtt.cmon.dao.cd.model.CongDan> getCongDans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congDanLocalService.getCongDans(start, end);
	}

	/**
	* Returns the number of cong dans.
	*
	* @return the number of cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int getCongDansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congDanLocalService.getCongDansCount();
	}

	/**
	* Updates the cong dan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congDan the cong dan
	* @return the cong dan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.cd.model.CongDan updateCongDan(
		vn.dtt.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congDanLocalService.updateCongDan(congDan);
	}

	/**
	* Updates the cong dan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param congDan the cong dan
	* @param merge whether to merge the cong dan with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cong dan that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.cd.model.CongDan updateCongDan(
		vn.dtt.cmon.dao.cd.model.CongDan congDan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _congDanLocalService.updateCongDan(congDan, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _congDanLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_congDanLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is function find CongDan by cmnd
	*
	* @author Hung.hoang
	* @date 11/09/2013
	* @param soCmnd
	* @return null if not found
	*/
	public java.util.List<vn.dtt.cmon.dao.cd.model.CongDan> findByCMND(
		java.lang.String soCmnd) {
		return _congDanLocalService.findByCMND(soCmnd);
	}

	/**
	* This is function find CongDan by email
	*
	* @author Hung.hoang
	* @date 11/09/2013
	* @param email
	* @return null if not found
	*/
	public java.util.List<vn.dtt.cmon.dao.cd.model.CongDan> findByEmail(
		java.lang.String email) {
		return _congDanLocalService.findByEmail(email);
	}

	/**
	* This is function find CongDan by ma
	*
	* @author Hung.hoang
	* @date 11/09/2013
	* @param ma of citizen
	* @return null if not found
	*/
	public vn.dtt.cmon.dao.cd.model.CongDan findByMa(java.lang.String ma) {
		return _congDanLocalService.findByMa(ma);
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
	public vn.dtt.cmon.dao.cd.model.CongDan findByNgaySinhAndSoCMND(
		java.util.Date ngaySinh, java.lang.String soCmnd) {
		return _congDanLocalService.findByNgaySinhAndSoCMND(ngaySinh, soCmnd);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CongDanLocalService getWrappedCongDanLocalService() {
		return _congDanLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCongDanLocalService(
		CongDanLocalService congDanLocalService) {
		_congDanLocalService = congDanLocalService;
	}

	public CongDanLocalService getWrappedService() {
		return _congDanLocalService;
	}

	public void setWrappedService(CongDanLocalService congDanLocalService) {
		_congDanLocalService = congDanLocalService;
	}

	private CongDanLocalService _congDanLocalService;
}