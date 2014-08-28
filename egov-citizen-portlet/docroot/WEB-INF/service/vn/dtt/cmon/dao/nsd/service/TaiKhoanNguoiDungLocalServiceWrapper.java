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

package vn.dtt.cmon.dao.nsd.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TaiKhoanNguoiDungLocalService}.
 * </p>
 *
 * @author    Liemnn
 * @see       TaiKhoanNguoiDungLocalService
 * @generated
 */
public class TaiKhoanNguoiDungLocalServiceWrapper
	implements TaiKhoanNguoiDungLocalService,
		ServiceWrapper<TaiKhoanNguoiDungLocalService> {
	public TaiKhoanNguoiDungLocalServiceWrapper(
		TaiKhoanNguoiDungLocalService taiKhoanNguoiDungLocalService) {
		_taiKhoanNguoiDungLocalService = taiKhoanNguoiDungLocalService;
	}

	/**
	* Adds the tai khoan nguoi dung to the database. Also notifies the appropriate model listeners.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	* @return the tai khoan nguoi dung that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung addTaiKhoanNguoiDung(
		vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taiKhoanNguoiDungLocalService.addTaiKhoanNguoiDung(taiKhoanNguoiDung);
	}

	/**
	* Creates a new tai khoan nguoi dung with the primary key. Does not add the tai khoan nguoi dung to the database.
	*
	* @param id the primary key for the new tai khoan nguoi dung
	* @return the new tai khoan nguoi dung
	*/
	public vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung createTaiKhoanNguoiDung(
		long id) {
		return _taiKhoanNguoiDungLocalService.createTaiKhoanNguoiDung(id);
	}

	/**
	* Deletes the tai khoan nguoi dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tai khoan nguoi dung
	* @throws PortalException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTaiKhoanNguoiDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_taiKhoanNguoiDungLocalService.deleteTaiKhoanNguoiDung(id);
	}

	/**
	* Deletes the tai khoan nguoi dung from the database. Also notifies the appropriate model listeners.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTaiKhoanNguoiDung(
		vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		_taiKhoanNguoiDungLocalService.deleteTaiKhoanNguoiDung(taiKhoanNguoiDung);
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
		return _taiKhoanNguoiDungLocalService.dynamicQuery(dynamicQuery);
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
		return _taiKhoanNguoiDungLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _taiKhoanNguoiDungLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _taiKhoanNguoiDungLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchTaiKhoanNguoiDung(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return _taiKhoanNguoiDungLocalService.fetchTaiKhoanNguoiDung(id);
	}

	/**
	* Returns the tai khoan nguoi dung with the primary key.
	*
	* @param id the primary key of the tai khoan nguoi dung
	* @return the tai khoan nguoi dung
	* @throws PortalException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung getTaiKhoanNguoiDung(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taiKhoanNguoiDungLocalService.getTaiKhoanNguoiDung(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taiKhoanNguoiDungLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tai khoan nguoi dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung> getTaiKhoanNguoiDungs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taiKhoanNguoiDungLocalService.getTaiKhoanNguoiDungs(start, end);
	}

	/**
	* Returns the number of tai khoan nguoi dungs.
	*
	* @return the number of tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public int getTaiKhoanNguoiDungsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taiKhoanNguoiDungLocalService.getTaiKhoanNguoiDungsCount();
	}

	/**
	* Updates the tai khoan nguoi dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	* @return the tai khoan nguoi dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung updateTaiKhoanNguoiDung(
		vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taiKhoanNguoiDungLocalService.updateTaiKhoanNguoiDung(taiKhoanNguoiDung);
	}

	/**
	* Updates the tai khoan nguoi dung in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	* @param merge whether to merge the tai khoan nguoi dung with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tai khoan nguoi dung that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung updateTaiKhoanNguoiDung(
		vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taiKhoanNguoiDungLocalService.updateTaiKhoanNguoiDung(taiKhoanNguoiDung,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _taiKhoanNguoiDungLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_taiKhoanNguoiDungLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is function  TaiKhoanNguoiDung by tenDangnhap
	*
	* @author Liem.Nham
	* @date 18/09/2013     *
	* @return null if not found
	*/
	public vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTenDangNhap(
		java.lang.String tenDangNhap) {
		return _taiKhoanNguoiDungLocalService.findByTenDangNhap(tenDangNhap);
	}

	/**
	* This is function  TaiKhoanNguoiDung by email
	*
	* @author Liem.Nham
	* @date 18/09/2013     *
	* @return null if not found
	*/
	public java.util.List<vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByEmail(
		java.lang.String email) {
		return _taiKhoanNguoiDungLocalService.findByEmail(email);
	}

	public vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchByLiferayUserId(
		long liferayUserId) {
		return _taiKhoanNguoiDungLocalService.fetchByLiferayUserId(liferayUserId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TaiKhoanNguoiDungLocalService getWrappedTaiKhoanNguoiDungLocalService() {
		return _taiKhoanNguoiDungLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTaiKhoanNguoiDungLocalService(
		TaiKhoanNguoiDungLocalService taiKhoanNguoiDungLocalService) {
		_taiKhoanNguoiDungLocalService = taiKhoanNguoiDungLocalService;
	}

	public TaiKhoanNguoiDungLocalService getWrappedService() {
		return _taiKhoanNguoiDungLocalService;
	}

	public void setWrappedService(
		TaiKhoanNguoiDungLocalService taiKhoanNguoiDungLocalService) {
		_taiKhoanNguoiDungLocalService = taiKhoanNguoiDungLocalService;
	}

	private TaiKhoanNguoiDungLocalService _taiKhoanNguoiDungLocalService;
}