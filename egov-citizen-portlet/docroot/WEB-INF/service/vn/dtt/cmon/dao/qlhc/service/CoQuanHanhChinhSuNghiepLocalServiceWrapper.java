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

package vn.dtt.cmon.dao.qlhc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CoQuanHanhChinhSuNghiepLocalService}.
 * </p>
 *
 * @author    LIEMNN
 * @see       CoQuanHanhChinhSuNghiepLocalService
 * @generated
 */
public class CoQuanHanhChinhSuNghiepLocalServiceWrapper
	implements CoQuanHanhChinhSuNghiepLocalService,
		ServiceWrapper<CoQuanHanhChinhSuNghiepLocalService> {
	public CoQuanHanhChinhSuNghiepLocalServiceWrapper(
		CoQuanHanhChinhSuNghiepLocalService coQuanHanhChinhSuNghiepLocalService) {
		_coQuanHanhChinhSuNghiepLocalService = coQuanHanhChinhSuNghiepLocalService;
	}

	/**
	* Adds the co quan hanh chinh su nghiep to the database. Also notifies the appropriate model listeners.
	*
	* @param coQuanHanhChinhSuNghiep the co quan hanh chinh su nghiep
	* @return the co quan hanh chinh su nghiep that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep addCoQuanHanhChinhSuNghiep(
		vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanHanhChinhSuNghiepLocalService.addCoQuanHanhChinhSuNghiep(coQuanHanhChinhSuNghiep);
	}

	/**
	* Creates a new co quan hanh chinh su nghiep with the primary key. Does not add the co quan hanh chinh su nghiep to the database.
	*
	* @param id the primary key for the new co quan hanh chinh su nghiep
	* @return the new co quan hanh chinh su nghiep
	*/
	public vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep createCoQuanHanhChinhSuNghiep(
		long id) {
		return _coQuanHanhChinhSuNghiepLocalService.createCoQuanHanhChinhSuNghiep(id);
	}

	/**
	* Deletes the co quan hanh chinh su nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the co quan hanh chinh su nghiep
	* @throws PortalException if a co quan hanh chinh su nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCoQuanHanhChinhSuNghiep(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_coQuanHanhChinhSuNghiepLocalService.deleteCoQuanHanhChinhSuNghiep(id);
	}

	/**
	* Deletes the co quan hanh chinh su nghiep from the database. Also notifies the appropriate model listeners.
	*
	* @param coQuanHanhChinhSuNghiep the co quan hanh chinh su nghiep
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCoQuanHanhChinhSuNghiep(
		vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		_coQuanHanhChinhSuNghiepLocalService.deleteCoQuanHanhChinhSuNghiep(coQuanHanhChinhSuNghiep);
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
		return _coQuanHanhChinhSuNghiepLocalService.dynamicQuery(dynamicQuery);
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
		return _coQuanHanhChinhSuNghiepLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _coQuanHanhChinhSuNghiepLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _coQuanHanhChinhSuNghiepLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep fetchCoQuanHanhChinhSuNghiep(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanHanhChinhSuNghiepLocalService.fetchCoQuanHanhChinhSuNghiep(id);
	}

	/**
	* Returns the co quan hanh chinh su nghiep with the primary key.
	*
	* @param id the primary key of the co quan hanh chinh su nghiep
	* @return the co quan hanh chinh su nghiep
	* @throws PortalException if a co quan hanh chinh su nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep getCoQuanHanhChinhSuNghiep(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanHanhChinhSuNghiepLocalService.getCoQuanHanhChinhSuNghiep(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coQuanHanhChinhSuNghiepLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the co quan hanh chinh su nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of co quan hanh chinh su nghieps
	* @param end the upper bound of the range of co quan hanh chinh su nghieps (not inclusive)
	* @return the range of co quan hanh chinh su nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep> getCoQuanHanhChinhSuNghieps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanHanhChinhSuNghiepLocalService.getCoQuanHanhChinhSuNghieps(start,
			end);
	}

	/**
	* Returns the number of co quan hanh chinh su nghieps.
	*
	* @return the number of co quan hanh chinh su nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int getCoQuanHanhChinhSuNghiepsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanHanhChinhSuNghiepLocalService.getCoQuanHanhChinhSuNghiepsCount();
	}

	/**
	* Updates the co quan hanh chinh su nghiep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coQuanHanhChinhSuNghiep the co quan hanh chinh su nghiep
	* @return the co quan hanh chinh su nghiep that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep updateCoQuanHanhChinhSuNghiep(
		vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanHanhChinhSuNghiepLocalService.updateCoQuanHanhChinhSuNghiep(coQuanHanhChinhSuNghiep);
	}

	/**
	* Updates the co quan hanh chinh su nghiep in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coQuanHanhChinhSuNghiep the co quan hanh chinh su nghiep
	* @param merge whether to merge the co quan hanh chinh su nghiep with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the co quan hanh chinh su nghiep that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep updateCoQuanHanhChinhSuNghiep(
		vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coQuanHanhChinhSuNghiepLocalService.updateCoQuanHanhChinhSuNghiep(coQuanHanhChinhSuNghiep,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _coQuanHanhChinhSuNghiepLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_coQuanHanhChinhSuNghiepLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<vn.dtt.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep> getDonViHanhChinhCha() {
		return _coQuanHanhChinhSuNghiepLocalService.getDonViHanhChinhCha();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CoQuanHanhChinhSuNghiepLocalService getWrappedCoQuanHanhChinhSuNghiepLocalService() {
		return _coQuanHanhChinhSuNghiepLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCoQuanHanhChinhSuNghiepLocalService(
		CoQuanHanhChinhSuNghiepLocalService coQuanHanhChinhSuNghiepLocalService) {
		_coQuanHanhChinhSuNghiepLocalService = coQuanHanhChinhSuNghiepLocalService;
	}

	public CoQuanHanhChinhSuNghiepLocalService getWrappedService() {
		return _coQuanHanhChinhSuNghiepLocalService;
	}

	public void setWrappedService(
		CoQuanHanhChinhSuNghiepLocalService coQuanHanhChinhSuNghiepLocalService) {
		_coQuanHanhChinhSuNghiepLocalService = coQuanHanhChinhSuNghiepLocalService;
	}

	private CoQuanHanhChinhSuNghiepLocalService _coQuanHanhChinhSuNghiepLocalService;
}