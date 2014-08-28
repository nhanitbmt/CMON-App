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
 * This class is a wrapper for {@link DanTocLocalService}.
 * </p>
 *
 * @author    LIEMNN
 * @see       DanTocLocalService
 * @generated
 */
public class DanTocLocalServiceWrapper implements DanTocLocalService,
	ServiceWrapper<DanTocLocalService> {
	public DanTocLocalServiceWrapper(DanTocLocalService danTocLocalService) {
		_danTocLocalService = danTocLocalService;
	}

	/**
	* Adds the dan toc to the database. Also notifies the appropriate model listeners.
	*
	* @param danToc the dan toc
	* @return the dan toc that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.cd.model.DanToc addDanToc(
		vn.dtt.cmon.dao.cd.model.DanToc danToc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danTocLocalService.addDanToc(danToc);
	}

	/**
	* Creates a new dan toc with the primary key. Does not add the dan toc to the database.
	*
	* @param id the primary key for the new dan toc
	* @return the new dan toc
	*/
	public vn.dtt.cmon.dao.cd.model.DanToc createDanToc(long id) {
		return _danTocLocalService.createDanToc(id);
	}

	/**
	* Deletes the dan toc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dan toc
	* @throws PortalException if a dan toc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDanToc(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_danTocLocalService.deleteDanToc(id);
	}

	/**
	* Deletes the dan toc from the database. Also notifies the appropriate model listeners.
	*
	* @param danToc the dan toc
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDanToc(vn.dtt.cmon.dao.cd.model.DanToc danToc)
		throws com.liferay.portal.kernel.exception.SystemException {
		_danTocLocalService.deleteDanToc(danToc);
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
		return _danTocLocalService.dynamicQuery(dynamicQuery);
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
		return _danTocLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _danTocLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _danTocLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.dtt.cmon.dao.cd.model.DanToc fetchDanToc(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danTocLocalService.fetchDanToc(id);
	}

	/**
	* Returns the dan toc with the primary key.
	*
	* @param id the primary key of the dan toc
	* @return the dan toc
	* @throws PortalException if a dan toc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.cd.model.DanToc getDanToc(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danTocLocalService.getDanToc(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _danTocLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dan tocs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of dan tocs
	* @param end the upper bound of the range of dan tocs (not inclusive)
	* @return the range of dan tocs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.dtt.cmon.dao.cd.model.DanToc> getDanTocs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danTocLocalService.getDanTocs(start, end);
	}

	/**
	* Returns the number of dan tocs.
	*
	* @return the number of dan tocs
	* @throws SystemException if a system exception occurred
	*/
	public int getDanTocsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danTocLocalService.getDanTocsCount();
	}

	/**
	* Updates the dan toc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danToc the dan toc
	* @return the dan toc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.cd.model.DanToc updateDanToc(
		vn.dtt.cmon.dao.cd.model.DanToc danToc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danTocLocalService.updateDanToc(danToc);
	}

	/**
	* Updates the dan toc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param danToc the dan toc
	* @param merge whether to merge the dan toc with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the dan toc that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.dtt.cmon.dao.cd.model.DanToc updateDanToc(
		vn.dtt.cmon.dao.cd.model.DanToc danToc, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _danTocLocalService.updateDanToc(danToc, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _danTocLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_danTocLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is function get all DanToc of Vietnam is actived
	*
	* @author Hung.hoang
	* @date 18/09/2013     *
	* @return null if not found
	*/
	public java.util.List<vn.dtt.cmon.dao.cd.model.DanToc> findAll() {
		return _danTocLocalService.findAll();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DanTocLocalService getWrappedDanTocLocalService() {
		return _danTocLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDanTocLocalService(
		DanTocLocalService danTocLocalService) {
		_danTocLocalService = danTocLocalService;
	}

	public DanTocLocalService getWrappedService() {
		return _danTocLocalService;
	}

	public void setWrappedService(DanTocLocalService danTocLocalService) {
		_danTocLocalService = danTocLocalService;
	}

	private DanTocLocalService _danTocLocalService;
}