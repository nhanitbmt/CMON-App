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
 * This class is a wrapper for {@link QuocGiaLocalService}.
 * </p>
 *
 * @author    LIEMNN
 * @see       QuocGiaLocalService
 * @generated
 */
public class QuocGiaLocalServiceWrapper implements QuocGiaLocalService,
	ServiceWrapper<QuocGiaLocalService> {
	public QuocGiaLocalServiceWrapper(QuocGiaLocalService quocGiaLocalService) {
		_quocGiaLocalService = quocGiaLocalService;
	}

	/**
	* Adds the quoc gia to the database. Also notifies the appropriate model listeners.
	*
	* @param quocGia the quoc gia
	* @return the quoc gia that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.qlhc.model.QuocGia addQuocGia(
		vn.dtt.cmon.dao.qlhc.model.QuocGia quocGia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quocGiaLocalService.addQuocGia(quocGia);
	}

	/**
	* Creates a new quoc gia with the primary key. Does not add the quoc gia to the database.
	*
	* @param id the primary key for the new quoc gia
	* @return the new quoc gia
	*/
	public vn.dtt.cmon.dao.qlhc.model.QuocGia createQuocGia(long id) {
		return _quocGiaLocalService.createQuocGia(id);
	}

	/**
	* Deletes the quoc gia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the quoc gia
	* @throws PortalException if a quoc gia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteQuocGia(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_quocGiaLocalService.deleteQuocGia(id);
	}

	/**
	* Deletes the quoc gia from the database. Also notifies the appropriate model listeners.
	*
	* @param quocGia the quoc gia
	* @throws SystemException if a system exception occurred
	*/
	public void deleteQuocGia(vn.dtt.cmon.dao.qlhc.model.QuocGia quocGia)
		throws com.liferay.portal.kernel.exception.SystemException {
		_quocGiaLocalService.deleteQuocGia(quocGia);
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
		return _quocGiaLocalService.dynamicQuery(dynamicQuery);
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
		return _quocGiaLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _quocGiaLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _quocGiaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.dtt.cmon.dao.qlhc.model.QuocGia fetchQuocGia(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quocGiaLocalService.fetchQuocGia(id);
	}

	/**
	* Returns the quoc gia with the primary key.
	*
	* @param id the primary key of the quoc gia
	* @return the quoc gia
	* @throws PortalException if a quoc gia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.qlhc.model.QuocGia getQuocGia(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _quocGiaLocalService.getQuocGia(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _quocGiaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the quoc gias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of quoc gias
	* @param end the upper bound of the range of quoc gias (not inclusive)
	* @return the range of quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dao.qlhc.model.QuocGia> getQuocGias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quocGiaLocalService.getQuocGias(start, end);
	}

	/**
	* Returns the number of quoc gias.
	*
	* @return the number of quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public int getQuocGiasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quocGiaLocalService.getQuocGiasCount();
	}

	/**
	* Updates the quoc gia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param quocGia the quoc gia
	* @return the quoc gia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.qlhc.model.QuocGia updateQuocGia(
		vn.dtt.cmon.dao.qlhc.model.QuocGia quocGia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quocGiaLocalService.updateQuocGia(quocGia);
	}

	/**
	* Updates the quoc gia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param quocGia the quoc gia
	* @param merge whether to merge the quoc gia with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the quoc gia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.qlhc.model.QuocGia updateQuocGia(
		vn.dtt.cmon.dao.qlhc.model.QuocGia quocGia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quocGiaLocalService.updateQuocGia(quocGia, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _quocGiaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_quocGiaLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<vn.dtt.cmon.dao.qlhc.model.QuocGia> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _quocGiaLocalService.findAll();
	}

	public vn.dtt.cmon.dao.qlhc.model.QuocGia findByMaQuocGia(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dao.qlhc.NoSuchQuocGiaException {
		return _quocGiaLocalService.findByMaQuocGia(ma);
	}

	public vn.dtt.cmon.dao.qlhc.model.QuocGia findByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dao.qlhc.NoSuchQuocGiaException {
		return _quocGiaLocalService.findByTen(ten);
	}

	public java.util.List<vn.dtt.cmon.dao.qlhc.model.QuocGia> findByDaXoa(
		int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dao.qlhc.NoSuchQuocGiaException {
		return _quocGiaLocalService.findByDaXoa(daXoa);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public QuocGiaLocalService getWrappedQuocGiaLocalService() {
		return _quocGiaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedQuocGiaLocalService(
		QuocGiaLocalService quocGiaLocalService) {
		_quocGiaLocalService = quocGiaLocalService;
	}

	public QuocGiaLocalService getWrappedService() {
		return _quocGiaLocalService;
	}

	public void setWrappedService(QuocGiaLocalService quocGiaLocalService) {
		_quocGiaLocalService = quocGiaLocalService;
	}

	private QuocGiaLocalService _quocGiaLocalService;
}