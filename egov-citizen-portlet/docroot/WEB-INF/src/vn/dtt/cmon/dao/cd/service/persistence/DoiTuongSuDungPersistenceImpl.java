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

import vn.dtt.cmon.dao.cd.NoSuchDoiTuongSuDungException;
import vn.dtt.cmon.dao.cd.model.DoiTuongSuDung;
import vn.dtt.cmon.dao.cd.model.impl.DoiTuongSuDungImpl;
import vn.dtt.cmon.dao.cd.model.impl.DoiTuongSuDungModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the doi tuong su dung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see DoiTuongSuDungPersistence
 * @see DoiTuongSuDungUtil
 * @generated
 */
public class DoiTuongSuDungPersistenceImpl extends BasePersistenceImpl<DoiTuongSuDung>
	implements DoiTuongSuDungPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DoiTuongSuDungUtil} to access the doi tuong su dung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DoiTuongSuDungImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			DoiTuongSuDungModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_TEN = new FinderPath(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByTen",
			new String[] { String.class.getName() },
			DoiTuongSuDungModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MA = new FinderPath(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByMa",
			new String[] { String.class.getName() },
			DoiTuongSuDungModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DoiTuongSuDungImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the doi tuong su dung in the entity cache if it is enabled.
	 *
	 * @param doiTuongSuDung the doi tuong su dung
	 */
	public void cacheResult(DoiTuongSuDung doiTuongSuDung) {
		EntityCacheUtil.putResult(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, doiTuongSuDung.getPrimaryKey(),
			doiTuongSuDung);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] { doiTuongSuDung.getTen() }, doiTuongSuDung);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { doiTuongSuDung.getMa() }, doiTuongSuDung);

		doiTuongSuDung.resetOriginalValues();
	}

	/**
	 * Caches the doi tuong su dungs in the entity cache if it is enabled.
	 *
	 * @param doiTuongSuDungs the doi tuong su dungs
	 */
	public void cacheResult(List<DoiTuongSuDung> doiTuongSuDungs) {
		for (DoiTuongSuDung doiTuongSuDung : doiTuongSuDungs) {
			if (EntityCacheUtil.getResult(
						DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
						DoiTuongSuDungImpl.class, doiTuongSuDung.getPrimaryKey()) == null) {
				cacheResult(doiTuongSuDung);
			}
			else {
				doiTuongSuDung.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all doi tuong su dungs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DoiTuongSuDungImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DoiTuongSuDungImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the doi tuong su dung.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DoiTuongSuDung doiTuongSuDung) {
		EntityCacheUtil.removeResult(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, doiTuongSuDung.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(doiTuongSuDung);
	}

	@Override
	public void clearCache(List<DoiTuongSuDung> doiTuongSuDungs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DoiTuongSuDung doiTuongSuDung : doiTuongSuDungs) {
			EntityCacheUtil.removeResult(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
				DoiTuongSuDungImpl.class, doiTuongSuDung.getPrimaryKey());

			clearUniqueFindersCache(doiTuongSuDung);
		}
	}

	protected void clearUniqueFindersCache(DoiTuongSuDung doiTuongSuDung) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN,
			new Object[] { doiTuongSuDung.getTen() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA,
			new Object[] { doiTuongSuDung.getMa() });
	}

	/**
	 * Creates a new doi tuong su dung with the primary key. Does not add the doi tuong su dung to the database.
	 *
	 * @param id the primary key for the new doi tuong su dung
	 * @return the new doi tuong su dung
	 */
	public DoiTuongSuDung create(long id) {
		DoiTuongSuDung doiTuongSuDung = new DoiTuongSuDungImpl();

		doiTuongSuDung.setNew(true);
		doiTuongSuDung.setPrimaryKey(id);

		return doiTuongSuDung;
	}

	/**
	 * Removes the doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung that was removed
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoiTuongSuDung remove(long id)
		throws NoSuchDoiTuongSuDungException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the doi tuong su dung
	 * @return the doi tuong su dung that was removed
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DoiTuongSuDung remove(Serializable primaryKey)
		throws NoSuchDoiTuongSuDungException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DoiTuongSuDung doiTuongSuDung = (DoiTuongSuDung)session.get(DoiTuongSuDungImpl.class,
					primaryKey);

			if (doiTuongSuDung == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDoiTuongSuDungException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(doiTuongSuDung);
		}
		catch (NoSuchDoiTuongSuDungException nsee) {
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
	protected DoiTuongSuDung removeImpl(DoiTuongSuDung doiTuongSuDung)
		throws SystemException {
		doiTuongSuDung = toUnwrappedModel(doiTuongSuDung);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, doiTuongSuDung);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(doiTuongSuDung);

		return doiTuongSuDung;
	}

	@Override
	public DoiTuongSuDung updateImpl(
		vn.dtt.cmon.dao.cd.model.DoiTuongSuDung doiTuongSuDung, boolean merge)
		throws SystemException {
		doiTuongSuDung = toUnwrappedModel(doiTuongSuDung);

		boolean isNew = doiTuongSuDung.isNew();

		DoiTuongSuDungModelImpl doiTuongSuDungModelImpl = (DoiTuongSuDungModelImpl)doiTuongSuDung;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, doiTuongSuDung, merge);

			doiTuongSuDung.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DoiTuongSuDungModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((doiTuongSuDungModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(doiTuongSuDungModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(doiTuongSuDungModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
			DoiTuongSuDungImpl.class, doiTuongSuDung.getPrimaryKey(),
			doiTuongSuDung);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
				new Object[] { doiTuongSuDung.getTen() }, doiTuongSuDung);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
				new Object[] { doiTuongSuDung.getMa() }, doiTuongSuDung);
		}
		else {
			if ((doiTuongSuDungModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						doiTuongSuDungModelImpl.getOriginalTen()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
					new Object[] { doiTuongSuDung.getTen() }, doiTuongSuDung);
			}

			if ((doiTuongSuDungModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						doiTuongSuDungModelImpl.getOriginalMa()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
					new Object[] { doiTuongSuDung.getMa() }, doiTuongSuDung);
			}
		}

		return doiTuongSuDung;
	}

	protected DoiTuongSuDung toUnwrappedModel(DoiTuongSuDung doiTuongSuDung) {
		if (doiTuongSuDung instanceof DoiTuongSuDungImpl) {
			return doiTuongSuDung;
		}

		DoiTuongSuDungImpl doiTuongSuDungImpl = new DoiTuongSuDungImpl();

		doiTuongSuDungImpl.setNew(doiTuongSuDung.isNew());
		doiTuongSuDungImpl.setPrimaryKey(doiTuongSuDung.getPrimaryKey());

		doiTuongSuDungImpl.setId(doiTuongSuDung.getId());
		doiTuongSuDungImpl.setTen(doiTuongSuDung.getTen());
		doiTuongSuDungImpl.setMa(doiTuongSuDung.getMa());
		doiTuongSuDungImpl.setMota(doiTuongSuDung.getMota());
		doiTuongSuDungImpl.setNguoiTao(doiTuongSuDung.getNguoiTao());
		doiTuongSuDungImpl.setNgayTao(doiTuongSuDung.getNgayTao());
		doiTuongSuDungImpl.setNguoiSua(doiTuongSuDung.getNguoiSua());
		doiTuongSuDungImpl.setNgaySua(doiTuongSuDung.getNgaySua());
		doiTuongSuDungImpl.setTrangThai(doiTuongSuDung.getTrangThai());
		doiTuongSuDungImpl.setDaXoa(doiTuongSuDung.getDaXoa());

		return doiTuongSuDungImpl;
	}

	/**
	 * Returns the doi tuong su dung with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the doi tuong su dung
	 * @return the doi tuong su dung
	 * @throws com.liferay.portal.NoSuchModelException if a doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DoiTuongSuDung findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the doi tuong su dung with the primary key or throws a {@link vn.dtt.cmon.dao.cd.NoSuchDoiTuongSuDungException} if it could not be found.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoiTuongSuDung findByPrimaryKey(long id)
		throws NoSuchDoiTuongSuDungException, SystemException {
		DoiTuongSuDung doiTuongSuDung = fetchByPrimaryKey(id);

		if (doiTuongSuDung == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchDoiTuongSuDungException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return doiTuongSuDung;
	}

	/**
	 * Returns the doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the doi tuong su dung
	 * @return the doi tuong su dung, or <code>null</code> if a doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DoiTuongSuDung fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the doi tuong su dung
	 * @return the doi tuong su dung, or <code>null</code> if a doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoiTuongSuDung fetchByPrimaryKey(long id) throws SystemException {
		DoiTuongSuDung doiTuongSuDung = (DoiTuongSuDung)EntityCacheUtil.getResult(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
				DoiTuongSuDungImpl.class, id);

		if (doiTuongSuDung == _nullDoiTuongSuDung) {
			return null;
		}

		if (doiTuongSuDung == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				doiTuongSuDung = (DoiTuongSuDung)session.get(DoiTuongSuDungImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (doiTuongSuDung != null) {
					cacheResult(doiTuongSuDung);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DoiTuongSuDungModelImpl.ENTITY_CACHE_ENABLED,
						DoiTuongSuDungImpl.class, id, _nullDoiTuongSuDung);
				}

				closeSession(session);
			}
		}

		return doiTuongSuDung;
	}

	/**
	 * Returns all the doi tuong su dungs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoiTuongSuDung> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doi tuong su dungs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of doi tuong su dungs
	 * @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	 * @return the range of matching doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoiTuongSuDung> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the doi tuong su dungs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of doi tuong su dungs
	 * @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoiTuongSuDung> findByTrangThai(int daXoa, int start, int end,
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

		List<DoiTuongSuDung> list = (List<DoiTuongSuDung>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_DOITUONGSUDUNG_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<DoiTuongSuDung>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first doi tuong su dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching doi tuong su dung
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoiTuongSuDung findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDoiTuongSuDungException, SystemException {
		List<DoiTuongSuDung> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last doi tuong su dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching doi tuong su dung
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoiTuongSuDung findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDoiTuongSuDungException, SystemException {
		int count = countByTrangThai(daXoa);

		List<DoiTuongSuDung> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchDoiTuongSuDungException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the doi tuong su dungs before and after the current doi tuong su dung in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current doi tuong su dung
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next doi tuong su dung
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoiTuongSuDung[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchDoiTuongSuDungException, SystemException {
		DoiTuongSuDung doiTuongSuDung = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			DoiTuongSuDung[] array = new DoiTuongSuDungImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, doiTuongSuDung,
					daXoa, orderByComparator, true);

			array[1] = doiTuongSuDung;

			array[2] = getByTrangThai_PrevAndNext(session, doiTuongSuDung,
					daXoa, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DoiTuongSuDung getByTrangThai_PrevAndNext(Session session,
		DoiTuongSuDung doiTuongSuDung, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOITUONGSUDUNG_WHERE);

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
			query.append(DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(doiTuongSuDung);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DoiTuongSuDung> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the doi tuong su dung where ten = &#63; or throws a {@link vn.dtt.cmon.dao.cd.NoSuchDoiTuongSuDungException} if it could not be found.
	 *
	 * @param ten the ten
	 * @return the matching doi tuong su dung
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoiTuongSuDung findByTen(String ten)
		throws NoSuchDoiTuongSuDungException, SystemException {
		DoiTuongSuDung doiTuongSuDung = fetchByTen(ten);

		if (doiTuongSuDung == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDoiTuongSuDungException(msg.toString());
		}

		return doiTuongSuDung;
	}

	/**
	 * Returns the doi tuong su dung where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ten the ten
	 * @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoiTuongSuDung fetchByTen(String ten) throws SystemException {
		return fetchByTen(ten, true);
	}

	/**
	 * Returns the doi tuong su dung where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ten the ten
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoiTuongSuDung fetchByTen(String ten, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TEN,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOITUONGSUDUNG_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_TEN_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_TEN_2);
				}
			}

			query.append(DoiTuongSuDungModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				List<DoiTuongSuDung> list = q.list();

				result = list;

				DoiTuongSuDung doiTuongSuDung = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
						finderArgs, list);
				}
				else {
					doiTuongSuDung = list.get(0);

					cacheResult(doiTuongSuDung);

					if ((doiTuongSuDung.getTen() == null) ||
							!doiTuongSuDung.getTen().equals(ten)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TEN,
							finderArgs, doiTuongSuDung);
					}
				}

				return doiTuongSuDung;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TEN,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (DoiTuongSuDung)result;
			}
		}
	}

	/**
	 * Returns the doi tuong su dung where ma = &#63; or throws a {@link vn.dtt.cmon.dao.cd.NoSuchDoiTuongSuDungException} if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching doi tuong su dung
	 * @throws vn.dtt.cmon.dao.cd.NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoiTuongSuDung findByMa(String ma)
		throws NoSuchDoiTuongSuDungException, SystemException {
		DoiTuongSuDung doiTuongSuDung = fetchByMa(ma);

		if (doiTuongSuDung == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDoiTuongSuDungException(msg.toString());
		}

		return doiTuongSuDung;
	}

	/**
	 * Returns the doi tuong su dung where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoiTuongSuDung fetchByMa(String ma) throws SystemException {
		return fetchByMa(ma, true);
	}

	/**
	 * Returns the doi tuong su dung where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DoiTuongSuDung fetchByMa(String ma, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MA,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOITUONGSUDUNG_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MA_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MA_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MA_MA_2);
				}
			}

			query.append(DoiTuongSuDungModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				List<DoiTuongSuDung> list = q.list();

				result = list;

				DoiTuongSuDung doiTuongSuDung = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
						finderArgs, list);
				}
				else {
					doiTuongSuDung = list.get(0);

					cacheResult(doiTuongSuDung);

					if ((doiTuongSuDung.getMa() == null) ||
							!doiTuongSuDung.getMa().equals(ma)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MA,
							finderArgs, doiTuongSuDung);
					}
				}

				return doiTuongSuDung;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MA,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (DoiTuongSuDung)result;
			}
		}
	}

	/**
	 * Returns all the doi tuong su dungs.
	 *
	 * @return the doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoiTuongSuDung> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of doi tuong su dungs
	 * @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	 * @return the range of doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoiTuongSuDung> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the doi tuong su dungs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of doi tuong su dungs
	 * @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DoiTuongSuDung> findAll(int start, int end,
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

		List<DoiTuongSuDung> list = (List<DoiTuongSuDung>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOITUONGSUDUNG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOITUONGSUDUNG.concat(DoiTuongSuDungModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<DoiTuongSuDung>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<DoiTuongSuDung>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the doi tuong su dungs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (DoiTuongSuDung doiTuongSuDung : findByTrangThai(daXoa)) {
			remove(doiTuongSuDung);
		}
	}

	/**
	 * Removes the doi tuong su dung where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten)
		throws NoSuchDoiTuongSuDungException, SystemException {
		DoiTuongSuDung doiTuongSuDung = findByTen(ten);

		remove(doiTuongSuDung);
	}

	/**
	 * Removes the doi tuong su dung where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma)
		throws NoSuchDoiTuongSuDungException, SystemException {
		DoiTuongSuDung doiTuongSuDung = findByMa(ma);

		remove(doiTuongSuDung);
	}

	/**
	 * Removes all the doi tuong su dungs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (DoiTuongSuDung doiTuongSuDung : findAll()) {
			remove(doiTuongSuDung);
		}
	}

	/**
	 * Returns the number of doi tuong su dungs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOITUONGSUDUNG_WHERE);

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
	 * Returns the number of doi tuong su dungs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOITUONGSUDUNG_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_TEN_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TEN_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TEN_TEN_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TEN, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of doi tuong su dungs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOITUONGSUDUNG_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MA_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MA_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MA_MA_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MA, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of doi tuong su dungs.
	 *
	 * @return the number of doi tuong su dungs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOITUONGSUDUNG);

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
	 * Initializes the doi tuong su dung persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.cmon.dao.cd.model.DoiTuongSuDung")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DoiTuongSuDung>> listenersList = new ArrayList<ModelListener<DoiTuongSuDung>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DoiTuongSuDung>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DoiTuongSuDungImpl.class.getName());
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
	private static final String _SQL_SELECT_DOITUONGSUDUNG = "SELECT doiTuongSuDung FROM DoiTuongSuDung doiTuongSuDung";
	private static final String _SQL_SELECT_DOITUONGSUDUNG_WHERE = "SELECT doiTuongSuDung FROM DoiTuongSuDung doiTuongSuDung WHERE ";
	private static final String _SQL_COUNT_DOITUONGSUDUNG = "SELECT COUNT(doiTuongSuDung) FROM DoiTuongSuDung doiTuongSuDung";
	private static final String _SQL_COUNT_DOITUONGSUDUNG_WHERE = "SELECT COUNT(doiTuongSuDung) FROM DoiTuongSuDung doiTuongSuDung WHERE ";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "doiTuongSuDung.daXoa = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "doiTuongSuDung.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "doiTuongSuDung.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(doiTuongSuDung.ten IS NULL OR doiTuongSuDung.ten = ?)";
	private static final String _FINDER_COLUMN_MA_MA_1 = "doiTuongSuDung.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "doiTuongSuDung.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(doiTuongSuDung.ma IS NULL OR doiTuongSuDung.ma = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "doiTuongSuDung.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DoiTuongSuDung exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DoiTuongSuDung exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DoiTuongSuDungPersistenceImpl.class);
	private static DoiTuongSuDung _nullDoiTuongSuDung = new DoiTuongSuDungImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DoiTuongSuDung> toCacheModel() {
				return _nullDoiTuongSuDungCacheModel;
			}
		};

	private static CacheModel<DoiTuongSuDung> _nullDoiTuongSuDungCacheModel = new CacheModel<DoiTuongSuDung>() {
			public DoiTuongSuDung toEntityModel() {
				return _nullDoiTuongSuDung;
			}
		};
}