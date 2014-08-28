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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.dtt.cmon.dao.cd.NoSuchDanTocException;
import vn.dtt.cmon.dao.cd.model.DanToc;
import vn.dtt.cmon.dao.cd.model.impl.DanTocImpl;
import vn.dtt.cmon.dao.cd.model.impl.DanTocModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the dan toc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see DanTocPersistence
 * @see DanTocUtil
 * @generated
 */
public class DanTocPersistenceImpl extends BasePersistenceImpl<DanToc>
	implements DanTocPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DanTocUtil} to access the dan toc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DanTocImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(DanTocModelImpl.ENTITY_CACHE_ENABLED,
			DanTocModelImpl.FINDER_CACHE_ENABLED, DanTocImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(DanTocModelImpl.ENTITY_CACHE_ENABLED,
			DanTocModelImpl.FINDER_CACHE_ENABLED, DanTocImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			DanTocModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(DanTocModelImpl.ENTITY_CACHE_ENABLED,
			DanTocModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DanTocModelImpl.ENTITY_CACHE_ENABLED,
			DanTocModelImpl.FINDER_CACHE_ENABLED, DanTocImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DanTocModelImpl.ENTITY_CACHE_ENABLED,
			DanTocModelImpl.FINDER_CACHE_ENABLED, DanTocImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DanTocModelImpl.ENTITY_CACHE_ENABLED,
			DanTocModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the dan toc in the entity cache if it is enabled.
	 *
	 * @param danToc the dan toc
	 */
	public void cacheResult(DanToc danToc) {
		EntityCacheUtil.putResult(DanTocModelImpl.ENTITY_CACHE_ENABLED,
			DanTocImpl.class, danToc.getPrimaryKey(), danToc);

		danToc.resetOriginalValues();
	}

	/**
	 * Caches the dan tocs in the entity cache if it is enabled.
	 *
	 * @param danTocs the dan tocs
	 */
	public void cacheResult(List<DanToc> danTocs) {
		for (DanToc danToc : danTocs) {
			if (EntityCacheUtil.getResult(
						DanTocModelImpl.ENTITY_CACHE_ENABLED, DanTocImpl.class,
						danToc.getPrimaryKey()) == null) {
				cacheResult(danToc);
			}
			else {
				danToc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dan tocs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DanTocImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DanTocImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dan toc.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DanToc danToc) {
		EntityCacheUtil.removeResult(DanTocModelImpl.ENTITY_CACHE_ENABLED,
			DanTocImpl.class, danToc.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DanToc> danTocs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DanToc danToc : danTocs) {
			EntityCacheUtil.removeResult(DanTocModelImpl.ENTITY_CACHE_ENABLED,
				DanTocImpl.class, danToc.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dan toc with the primary key. Does not add the dan toc to the database.
	 *
	 * @param id the primary key for the new dan toc
	 * @return the new dan toc
	 */
	public DanToc create(long id) {
		DanToc danToc = new DanTocImpl();

		danToc.setNew(true);
		danToc.setPrimaryKey(id);

		return danToc;
	}

	/**
	 * Removes the dan toc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dan toc
	 * @return the dan toc that was removed
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDanTocException if a dan toc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanToc remove(long id) throws NoSuchDanTocException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the dan toc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dan toc
	 * @return the dan toc that was removed
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDanTocException if a dan toc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanToc remove(Serializable primaryKey)
		throws NoSuchDanTocException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DanToc danToc = (DanToc)session.get(DanTocImpl.class, primaryKey);

			if (danToc == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDanTocException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(danToc);
		}
		catch (NoSuchDanTocException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DanToc removeImpl(DanToc danToc) throws SystemException {
		danToc = toUnwrappedModel(danToc);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, danToc);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(danToc);

		return danToc;
	}

	@Override
	public DanToc updateImpl(vn.dtt.cmon.dao.cd.model.DanToc danToc,
		boolean merge) throws SystemException {
		danToc = toUnwrappedModel(danToc);

		boolean isNew = danToc.isNew();

		DanTocModelImpl danTocModelImpl = (DanTocModelImpl)danToc;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, danToc, merge);

			danToc.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DanTocModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((danTocModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(danTocModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] { Integer.valueOf(danTocModelImpl.getDaXoa()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(DanTocModelImpl.ENTITY_CACHE_ENABLED,
			DanTocImpl.class, danToc.getPrimaryKey(), danToc);

		return danToc;
	}

	protected DanToc toUnwrappedModel(DanToc danToc) {
		if (danToc instanceof DanTocImpl) {
			return danToc;
		}

		DanTocImpl danTocImpl = new DanTocImpl();

		danTocImpl.setNew(danToc.isNew());
		danTocImpl.setPrimaryKey(danToc.getPrimaryKey());

		danTocImpl.setId(danToc.getId());
		danTocImpl.setMa(danToc.getMa());
		danTocImpl.setTen(danToc.getTen());
		danTocImpl.setPhienBan(danToc.getPhienBan());
		danTocImpl.setLaThieuSo(danToc.getLaThieuSo());
		danTocImpl.setNgayTao(danToc.getNgayTao());
		danTocImpl.setDaXoa(danToc.getDaXoa());
		danTocImpl.setNguoiTao(danToc.getNguoiTao());
		danTocImpl.setNguoiSua(danToc.getNguoiSua());
		danTocImpl.setTenKhac(danToc.getTenKhac());
		danTocImpl.setNgaySua(danToc.getNgaySua());

		return danTocImpl;
	}

	/**
	 * Returns the dan toc with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dan toc
	 * @return the dan toc
	 * @throws com.liferay.portal.NoSuchModelException if a dan toc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanToc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the dan toc with the primary key or throws a {@link vn.dtt.cmon.dao.cd.NoSuchDanTocException} if it could not be found.
	 *
	 * @param id the primary key of the dan toc
	 * @return the dan toc
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDanTocException if a dan toc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanToc findByPrimaryKey(long id)
		throws NoSuchDanTocException, SystemException {
		DanToc danToc = fetchByPrimaryKey(id);

		if (danToc == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchDanTocException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return danToc;
	}

	/**
	 * Returns the dan toc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dan toc
	 * @return the dan toc, or <code>null</code> if a dan toc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DanToc fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the dan toc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dan toc
	 * @return the dan toc, or <code>null</code> if a dan toc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanToc fetchByPrimaryKey(long id) throws SystemException {
		DanToc danToc = (DanToc)EntityCacheUtil.getResult(DanTocModelImpl.ENTITY_CACHE_ENABLED,
				DanTocImpl.class, id);

		if (danToc == _nullDanToc) {
			return null;
		}

		if (danToc == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				danToc = (DanToc)session.get(DanTocImpl.class, Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (danToc != null) {
					cacheResult(danToc);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DanTocModelImpl.ENTITY_CACHE_ENABLED,
						DanTocImpl.class, id, _nullDanToc);
				}

				closeSession(session);
			}
		}

		return danToc;
	}

	/**
	 * Returns all the dan tocs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching dan tocs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanToc> findByTrangThai(int daXoa) throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dan tocs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of dan tocs
	 * @param end the upper bound of the range of dan tocs (not inclusive)
	 * @return the range of matching dan tocs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanToc> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dan tocs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of dan tocs
	 * @param end the upper bound of the range of dan tocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dan tocs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanToc> findByTrangThai(int daXoa, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { daXoa };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI;
			finderArgs = new Object[] { daXoa, start, end, orderByComparator };
		}

		List<DanToc> list = (List<DanToc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DANTOC_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DanTocModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<DanToc>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dan toc in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dan toc
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDanTocException if a matching dan toc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanToc findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDanTocException, SystemException {
		List<DanToc> list = findByTrangThai(daXoa, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDanTocException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last dan toc in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dan toc
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDanTocException if a matching dan toc could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanToc findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDanTocException, SystemException {
		int count = countByTrangThai(daXoa);

		List<DanToc> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDanTocException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the dan tocs before and after the current dan toc in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current dan toc
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dan toc
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDanTocException if a dan toc with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DanToc[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDanTocException, SystemException {
		DanToc danToc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DanToc[] array = new DanTocImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, danToc, daXoa,
					orderByComparator, true);

			array[1] = danToc;

			array[2] = getByTrangThai_PrevAndNext(session, danToc, daXoa,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DanToc getByTrangThai_PrevAndNext(Session session, DanToc danToc,
		int daXoa, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DANTOC_WHERE);

		query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(DanTocModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(danToc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DanToc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the dan tocs.
	 *
	 * @return the dan tocs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanToc> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<DanToc> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dan tocs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of dan tocs
	 * @param end the upper bound of the range of dan tocs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dan tocs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DanToc> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<DanToc> list = (List<DanToc>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DANTOC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DANTOC.concat(DanTocModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DanToc>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DanToc>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the dan tocs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (DanToc danToc : findByTrangThai(daXoa)) {
			remove(danToc);
		}
	}

	/**
	 * Removes all the dan tocs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DanToc danToc : findAll()) {
			remove(danToc);
		}
	}

	/**
	 * Returns the number of dan tocs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching dan tocs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DANTOC_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of dan tocs.
	 *
	 * @return the number of dan tocs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DANTOC);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the dan toc persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.cmon.dao.cd.model.DanToc")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DanToc>> listenersList = new ArrayList<ModelListener<DanToc>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DanToc>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(DanTocImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CongDanPersistence.class)
	protected CongDanPersistence congDanPersistence;
	@BeanReference(type = DanTocPersistence.class)
	protected DanTocPersistence danTocPersistence;
	@BeanReference(type = DoiTuongSuDungPersistence.class)
	protected DoiTuongSuDungPersistence doiTuongSuDungPersistence;
	@BeanReference(type = GioiTinhPersistence.class)
	protected GioiTinhPersistence gioiTinhPersistence;
	@BeanReference(type = TonGiaoPersistence.class)
	protected TonGiaoPersistence tonGiaoPersistence;
	@BeanReference(type = YeuCauDangKyCongDanPersistence.class)
	protected YeuCauDangKyCongDanPersistence yeuCauDangKyCongDanPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_DANTOC = "SELECT danToc FROM DanToc danToc";
	private static final String _SQL_SELECT_DANTOC_WHERE = "SELECT danToc FROM DanToc danToc WHERE ";
	private static final String _SQL_COUNT_DANTOC = "SELECT COUNT(danToc) FROM DanToc danToc";
	private static final String _SQL_COUNT_DANTOC_WHERE = "SELECT COUNT(danToc) FROM DanToc danToc WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "danToc.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "danToc.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DanToc exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DanToc exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DanTocPersistenceImpl.class);
	private static DanToc _nullDanToc = new DanTocImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DanToc> toCacheModel() {
				return _nullDanTocCacheModel;
			}
		};

	private static CacheModel<DanToc> _nullDanTocCacheModel = new CacheModel<DanToc>() {
			public DanToc toEntityModel() {
				return _nullDanToc;
			}
		};
}