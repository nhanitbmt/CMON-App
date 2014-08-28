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

package vn.dtt.cmon.dao.cd.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import vn.dtt.cmon.dao.cd.model.TonGiao;
import vn.dtt.cmon.dao.cd.service.CongDanLocalService;
import vn.dtt.cmon.dao.cd.service.DanTocLocalService;
import vn.dtt.cmon.dao.cd.service.DoiTuongSuDungLocalService;
import vn.dtt.cmon.dao.cd.service.GioiTinhLocalService;
import vn.dtt.cmon.dao.cd.service.TonGiaoLocalService;
import vn.dtt.cmon.dao.cd.service.YeuCauDangKyCongDanLocalService;
import vn.dtt.cmon.dao.cd.service.persistence.CongDanPersistence;
import vn.dtt.cmon.dao.cd.service.persistence.DanTocPersistence;
import vn.dtt.cmon.dao.cd.service.persistence.DoiTuongSuDungPersistence;
import vn.dtt.cmon.dao.cd.service.persistence.GioiTinhPersistence;
import vn.dtt.cmon.dao.cd.service.persistence.TonGiaoPersistence;
import vn.dtt.cmon.dao.cd.service.persistence.YeuCauDangKyCongDanPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the ton giao local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.dtt.cmon.dao.cd.service.impl.TonGiaoLocalServiceImpl}.
 * </p>
 *
 * @author LIEMNN
 * @see vn.dtt.cmon.dao.cd.service.impl.TonGiaoLocalServiceImpl
 * @see vn.dtt.cmon.dao.cd.service.TonGiaoLocalServiceUtil
 * @generated
 */
public abstract class TonGiaoLocalServiceBaseImpl implements TonGiaoLocalService,
	IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.dtt.cmon.dao.cd.service.TonGiaoLocalServiceUtil} to access the ton giao local service.
	 */

	/**
	 * Adds the ton giao to the database. Also notifies the appropriate model listeners.
	 *
	 * @param tonGiao the ton giao
	 * @return the ton giao that was added
	 * @throws SystemException if a system exception occurred
	 */
	public TonGiao addTonGiao(TonGiao tonGiao) throws SystemException {
		tonGiao.setNew(true);

		tonGiao = tonGiaoPersistence.update(tonGiao, false);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(tonGiao);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return tonGiao;
	}

	/**
	 * Creates a new ton giao with the primary key. Does not add the ton giao to the database.
	 *
	 * @param id the primary key for the new ton giao
	 * @return the new ton giao
	 */
	public TonGiao createTonGiao(long id) {
		return tonGiaoPersistence.create(id);
	}

	/**
	 * Deletes the ton giao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ton giao
	 * @throws PortalException if a ton giao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteTonGiao(long id) throws PortalException, SystemException {
		TonGiao tonGiao = tonGiaoPersistence.remove(id);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(tonGiao);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Deletes the ton giao from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tonGiao the ton giao
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteTonGiao(TonGiao tonGiao) throws SystemException {
		tonGiaoPersistence.remove(tonGiao);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(tonGiao);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return tonGiaoPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return tonGiaoPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return tonGiaoPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return tonGiaoPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public TonGiao fetchTonGiao(long id) throws SystemException {
		return tonGiaoPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the ton giao with the primary key.
	 *
	 * @param id the primary key of the ton giao
	 * @return the ton giao
	 * @throws PortalException if a ton giao with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TonGiao getTonGiao(long id) throws PortalException, SystemException {
		return tonGiaoPersistence.findByPrimaryKey(id);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return tonGiaoPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ton giaos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ton giaos
	 * @param end the upper bound of the range of ton giaos (not inclusive)
	 * @return the range of ton giaos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TonGiao> getTonGiaos(int start, int end)
		throws SystemException {
		return tonGiaoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ton giaos.
	 *
	 * @return the number of ton giaos
	 * @throws SystemException if a system exception occurred
	 */
	public int getTonGiaosCount() throws SystemException {
		return tonGiaoPersistence.countAll();
	}

	/**
	 * Updates the ton giao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tonGiao the ton giao
	 * @return the ton giao that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public TonGiao updateTonGiao(TonGiao tonGiao) throws SystemException {
		return updateTonGiao(tonGiao, true);
	}

	/**
	 * Updates the ton giao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tonGiao the ton giao
	 * @param merge whether to merge the ton giao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the ton giao that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public TonGiao updateTonGiao(TonGiao tonGiao, boolean merge)
		throws SystemException {
		tonGiao.setNew(false);

		tonGiao = tonGiaoPersistence.update(tonGiao, merge);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(tonGiao);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return tonGiao;
	}

	/**
	 * Returns the cong dan local service.
	 *
	 * @return the cong dan local service
	 */
	public CongDanLocalService getCongDanLocalService() {
		return congDanLocalService;
	}

	/**
	 * Sets the cong dan local service.
	 *
	 * @param congDanLocalService the cong dan local service
	 */
	public void setCongDanLocalService(CongDanLocalService congDanLocalService) {
		this.congDanLocalService = congDanLocalService;
	}

	/**
	 * Returns the cong dan persistence.
	 *
	 * @return the cong dan persistence
	 */
	public CongDanPersistence getCongDanPersistence() {
		return congDanPersistence;
	}

	/**
	 * Sets the cong dan persistence.
	 *
	 * @param congDanPersistence the cong dan persistence
	 */
	public void setCongDanPersistence(CongDanPersistence congDanPersistence) {
		this.congDanPersistence = congDanPersistence;
	}

	/**
	 * Returns the dan toc local service.
	 *
	 * @return the dan toc local service
	 */
	public DanTocLocalService getDanTocLocalService() {
		return danTocLocalService;
	}

	/**
	 * Sets the dan toc local service.
	 *
	 * @param danTocLocalService the dan toc local service
	 */
	public void setDanTocLocalService(DanTocLocalService danTocLocalService) {
		this.danTocLocalService = danTocLocalService;
	}

	/**
	 * Returns the dan toc persistence.
	 *
	 * @return the dan toc persistence
	 */
	public DanTocPersistence getDanTocPersistence() {
		return danTocPersistence;
	}

	/**
	 * Sets the dan toc persistence.
	 *
	 * @param danTocPersistence the dan toc persistence
	 */
	public void setDanTocPersistence(DanTocPersistence danTocPersistence) {
		this.danTocPersistence = danTocPersistence;
	}

	/**
	 * Returns the doi tuong su dung local service.
	 *
	 * @return the doi tuong su dung local service
	 */
	public DoiTuongSuDungLocalService getDoiTuongSuDungLocalService() {
		return doiTuongSuDungLocalService;
	}

	/**
	 * Sets the doi tuong su dung local service.
	 *
	 * @param doiTuongSuDungLocalService the doi tuong su dung local service
	 */
	public void setDoiTuongSuDungLocalService(
		DoiTuongSuDungLocalService doiTuongSuDungLocalService) {
		this.doiTuongSuDungLocalService = doiTuongSuDungLocalService;
	}

	/**
	 * Returns the doi tuong su dung persistence.
	 *
	 * @return the doi tuong su dung persistence
	 */
	public DoiTuongSuDungPersistence getDoiTuongSuDungPersistence() {
		return doiTuongSuDungPersistence;
	}

	/**
	 * Sets the doi tuong su dung persistence.
	 *
	 * @param doiTuongSuDungPersistence the doi tuong su dung persistence
	 */
	public void setDoiTuongSuDungPersistence(
		DoiTuongSuDungPersistence doiTuongSuDungPersistence) {
		this.doiTuongSuDungPersistence = doiTuongSuDungPersistence;
	}

	/**
	 * Returns the gioi tinh local service.
	 *
	 * @return the gioi tinh local service
	 */
	public GioiTinhLocalService getGioiTinhLocalService() {
		return gioiTinhLocalService;
	}

	/**
	 * Sets the gioi tinh local service.
	 *
	 * @param gioiTinhLocalService the gioi tinh local service
	 */
	public void setGioiTinhLocalService(
		GioiTinhLocalService gioiTinhLocalService) {
		this.gioiTinhLocalService = gioiTinhLocalService;
	}

	/**
	 * Returns the gioi tinh persistence.
	 *
	 * @return the gioi tinh persistence
	 */
	public GioiTinhPersistence getGioiTinhPersistence() {
		return gioiTinhPersistence;
	}

	/**
	 * Sets the gioi tinh persistence.
	 *
	 * @param gioiTinhPersistence the gioi tinh persistence
	 */
	public void setGioiTinhPersistence(GioiTinhPersistence gioiTinhPersistence) {
		this.gioiTinhPersistence = gioiTinhPersistence;
	}

	/**
	 * Returns the ton giao local service.
	 *
	 * @return the ton giao local service
	 */
	public TonGiaoLocalService getTonGiaoLocalService() {
		return tonGiaoLocalService;
	}

	/**
	 * Sets the ton giao local service.
	 *
	 * @param tonGiaoLocalService the ton giao local service
	 */
	public void setTonGiaoLocalService(TonGiaoLocalService tonGiaoLocalService) {
		this.tonGiaoLocalService = tonGiaoLocalService;
	}

	/**
	 * Returns the ton giao persistence.
	 *
	 * @return the ton giao persistence
	 */
	public TonGiaoPersistence getTonGiaoPersistence() {
		return tonGiaoPersistence;
	}

	/**
	 * Sets the ton giao persistence.
	 *
	 * @param tonGiaoPersistence the ton giao persistence
	 */
	public void setTonGiaoPersistence(TonGiaoPersistence tonGiaoPersistence) {
		this.tonGiaoPersistence = tonGiaoPersistence;
	}

	/**
	 * Returns the yeu cau dang ky cong dan local service.
	 *
	 * @return the yeu cau dang ky cong dan local service
	 */
	public YeuCauDangKyCongDanLocalService getYeuCauDangKyCongDanLocalService() {
		return yeuCauDangKyCongDanLocalService;
	}

	/**
	 * Sets the yeu cau dang ky cong dan local service.
	 *
	 * @param yeuCauDangKyCongDanLocalService the yeu cau dang ky cong dan local service
	 */
	public void setYeuCauDangKyCongDanLocalService(
		YeuCauDangKyCongDanLocalService yeuCauDangKyCongDanLocalService) {
		this.yeuCauDangKyCongDanLocalService = yeuCauDangKyCongDanLocalService;
	}

	/**
	 * Returns the yeu cau dang ky cong dan persistence.
	 *
	 * @return the yeu cau dang ky cong dan persistence
	 */
	public YeuCauDangKyCongDanPersistence getYeuCauDangKyCongDanPersistence() {
		return yeuCauDangKyCongDanPersistence;
	}

	/**
	 * Sets the yeu cau dang ky cong dan persistence.
	 *
	 * @param yeuCauDangKyCongDanPersistence the yeu cau dang ky cong dan persistence
	 */
	public void setYeuCauDangKyCongDanPersistence(
		YeuCauDangKyCongDanPersistence yeuCauDangKyCongDanPersistence) {
		this.yeuCauDangKyCongDanPersistence = yeuCauDangKyCongDanPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("vn.dtt.cmon.dao.cd.model.TonGiao",
			tonGiaoLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"vn.dtt.cmon.dao.cd.model.TonGiao");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return TonGiao.class;
	}

	protected String getModelClassName() {
		return TonGiao.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = tonGiaoPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CongDanLocalService.class)
	protected CongDanLocalService congDanLocalService;
	@BeanReference(type = CongDanPersistence.class)
	protected CongDanPersistence congDanPersistence;
	@BeanReference(type = DanTocLocalService.class)
	protected DanTocLocalService danTocLocalService;
	@BeanReference(type = DanTocPersistence.class)
	protected DanTocPersistence danTocPersistence;
	@BeanReference(type = DoiTuongSuDungLocalService.class)
	protected DoiTuongSuDungLocalService doiTuongSuDungLocalService;
	@BeanReference(type = DoiTuongSuDungPersistence.class)
	protected DoiTuongSuDungPersistence doiTuongSuDungPersistence;
	@BeanReference(type = GioiTinhLocalService.class)
	protected GioiTinhLocalService gioiTinhLocalService;
	@BeanReference(type = GioiTinhPersistence.class)
	protected GioiTinhPersistence gioiTinhPersistence;
	@BeanReference(type = TonGiaoLocalService.class)
	protected TonGiaoLocalService tonGiaoLocalService;
	@BeanReference(type = TonGiaoPersistence.class)
	protected TonGiaoPersistence tonGiaoPersistence;
	@BeanReference(type = YeuCauDangKyCongDanLocalService.class)
	protected YeuCauDangKyCongDanLocalService yeuCauDangKyCongDanLocalService;
	@BeanReference(type = YeuCauDangKyCongDanPersistence.class)
	protected YeuCauDangKyCongDanPersistence yeuCauDangKyCongDanPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static Log _log = LogFactoryUtil.getLog(TonGiaoLocalServiceBaseImpl.class);
	private String _beanIdentifier;
}