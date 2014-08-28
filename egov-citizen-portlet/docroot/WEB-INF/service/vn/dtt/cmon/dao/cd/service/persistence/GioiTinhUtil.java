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

package vn.dtt.cmon.dao.cd.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.dtt.cmon.dao.cd.model.GioiTinh;

import java.util.List;

/**
 * The persistence utility for the gioi tinh service. This utility wraps {@link GioiTinhPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see GioiTinhPersistence
 * @see GioiTinhPersistenceImpl
 * @generated
 */
public class GioiTinhUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(GioiTinh gioiTinh) {
		getPersistence().clearCache(gioiTinh);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GioiTinh> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GioiTinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GioiTinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static GioiTinh update(GioiTinh gioiTinh, boolean merge)
		throws SystemException {
		return getPersistence().update(gioiTinh, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static GioiTinh update(GioiTinh gioiTinh, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(gioiTinh, merge, serviceContext);
	}

	/**
	* Caches the gioi tinh in the entity cache if it is enabled.
	*
	* @param gioiTinh the gioi tinh
	*/
	public static void cacheResult(vn.dtt.cmon.dao.cd.model.GioiTinh gioiTinh) {
		getPersistence().cacheResult(gioiTinh);
	}

	/**
	* Caches the gioi tinhs in the entity cache if it is enabled.
	*
	* @param gioiTinhs the gioi tinhs
	*/
	public static void cacheResult(
		java.util.List<vn.dtt.cmon.dao.cd.model.GioiTinh> gioiTinhs) {
		getPersistence().cacheResult(gioiTinhs);
	}

	/**
	* Creates a new gioi tinh with the primary key. Does not add the gioi tinh to the database.
	*
	* @param id the primary key for the new gioi tinh
	* @return the new gioi tinh
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the gioi tinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the gioi tinh
	* @return the gioi tinh that was removed
	* @throws vn.dtt.cmon.dao.cd.NoSuchGioiTinhException if a gioi tinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dao.cd.NoSuchGioiTinhException {
		return getPersistence().remove(id);
	}

	public static vn.dtt.cmon.dao.cd.model.GioiTinh updateImpl(
		vn.dtt.cmon.dao.cd.model.GioiTinh gioiTinh, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gioiTinh, merge);
	}

	/**
	* Returns the gioi tinh with the primary key or throws a {@link vn.dtt.cmon.dao.cd.NoSuchGioiTinhException} if it could not be found.
	*
	* @param id the primary key of the gioi tinh
	* @return the gioi tinh
	* @throws vn.dtt.cmon.dao.cd.NoSuchGioiTinhException if a gioi tinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dao.cd.NoSuchGioiTinhException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the gioi tinh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the gioi tinh
	* @return the gioi tinh, or <code>null</code> if a gioi tinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the gioi tinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.cmon.dao.cd.model.GioiTinh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the gioi tinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of gioi tinhs
	* @param end the upper bound of the range of gioi tinhs (not inclusive)
	* @return the range of matching gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.cmon.dao.cd.model.GioiTinh> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the gioi tinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of gioi tinhs
	* @param end the upper bound of the range of gioi tinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.cmon.dao.cd.model.GioiTinh> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first gioi tinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching gioi tinh
	* @throws vn.dtt.cmon.dao.cd.NoSuchGioiTinhException if a matching gioi tinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dao.cd.NoSuchGioiTinhException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last gioi tinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching gioi tinh
	* @throws vn.dtt.cmon.dao.cd.NoSuchGioiTinhException if a matching gioi tinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dao.cd.NoSuchGioiTinhException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the gioi tinhs before and after the current gioi tinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current gioi tinh
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next gioi tinh
	* @throws vn.dtt.cmon.dao.cd.NoSuchGioiTinhException if a gioi tinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dao.cd.NoSuchGioiTinhException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns the gioi tinh where ten = &#63; or throws a {@link vn.dtt.cmon.dao.cd.NoSuchGioiTinhException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching gioi tinh
	* @throws vn.dtt.cmon.dao.cd.NoSuchGioiTinhException if a matching gioi tinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dao.cd.NoSuchGioiTinhException {
		return getPersistence().findByTen(ten);
	}

	/**
	* Returns the gioi tinh where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching gioi tinh, or <code>null</code> if a matching gioi tinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh fetchByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTen(ten);
	}

	/**
	* Returns the gioi tinh where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching gioi tinh, or <code>null</code> if a matching gioi tinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh fetchByTen(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTen(ten, retrieveFromCache);
	}

	/**
	* Returns the gioi tinh where ma = &#63; or throws a {@link vn.dtt.cmon.dao.cd.NoSuchGioiTinhException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching gioi tinh
	* @throws vn.dtt.cmon.dao.cd.NoSuchGioiTinhException if a matching gioi tinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dao.cd.NoSuchGioiTinhException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns the gioi tinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching gioi tinh, or <code>null</code> if a matching gioi tinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh fetchByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMa(ma);
	}

	/**
	* Returns the gioi tinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching gioi tinh, or <code>null</code> if a matching gioi tinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.dtt.cmon.dao.cd.model.GioiTinh fetchByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	* Returns all the gioi tinhs.
	*
	* @return the gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.cmon.dao.cd.model.GioiTinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the gioi tinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of gioi tinhs
	* @param end the upper bound of the range of gioi tinhs (not inclusive)
	* @return the range of gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.cmon.dao.cd.model.GioiTinh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the gioi tinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of gioi tinhs
	* @param end the upper bound of the range of gioi tinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.dtt.cmon.dao.cd.model.GioiTinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the gioi tinhs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes the gioi tinh where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dao.cd.NoSuchGioiTinhException {
		getPersistence().removeByTen(ten);
	}

	/**
	* Removes the gioi tinh where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.dtt.cmon.dao.cd.NoSuchGioiTinhException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes all the gioi tinhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of gioi tinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of gioi tinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTen(ten);
	}

	/**
	* Returns the number of gioi tinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of gioi tinhs.
	*
	* @return the number of gioi tinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GioiTinhPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GioiTinhPersistence)PortletBeanLocatorUtil.locate(vn.dtt.cmon.dao.cd.service.ClpSerializer.getServletContextName(),
					GioiTinhPersistence.class.getName());

			ReferenceRegistry.registerReference(GioiTinhUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(GioiTinhPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(GioiTinhUtil.class, "_persistence");
	}

	private static GioiTinhPersistence _persistence;
}