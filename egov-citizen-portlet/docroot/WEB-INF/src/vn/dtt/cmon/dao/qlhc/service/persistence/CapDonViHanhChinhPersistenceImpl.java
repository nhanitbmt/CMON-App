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

package vn.dtt.cmon.dao.qlhc.service.persistence;

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

import vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException;
import vn.dtt.cmon.dao.qlhc.model.CapDonViHanhChinh;
import vn.dtt.cmon.dao.qlhc.model.impl.CapDonViHanhChinhImpl;
import vn.dtt.cmon.dao.qlhc.model.impl.CapDonViHanhChinhModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the cap don vi hanh chinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see CapDonViHanhChinhPersistence
 * @see CapDonViHanhChinhUtil
 * @generated
 */
public class CapDonViHanhChinhPersistenceImpl extends BasePersistenceImpl<CapDonViHanhChinh>
	implements CapDonViHanhChinhPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CapDonViHanhChinhUtil} to access the cap don vi hanh chinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CapDonViHanhChinhImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAP = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCap",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAP = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCap",
			new String[] { Long.class.getName() },
			CapDonViHanhChinhModelImpl.CAP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAP = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCap",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MA = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMa",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMa",
			new String[] { String.class.getName() },
			CapDonViHanhChinhModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MA = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMa",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTen",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTen",
			new String[] { String.class.getName() },
			CapDonViHanhChinhModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEN = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTen",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MADONVIHANHCHINH = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMaDonViHanhChinh", new String[] { String.class.getName() },
			CapDonViHanhChinhModelImpl.MA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MADONVIHANHCHINH = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMaDonViHanhChinh", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_TENDONVIHANHCHINH = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTenDonViHanhChinh",
			new String[] { String.class.getName() },
			CapDonViHanhChinhModelImpl.TEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TENDONVIHANHCHINH = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTenDonViHanhChinh", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTrangThai",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI =
		new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTrangThai",
			new String[] { Integer.class.getName() },
			CapDonViHanhChinhModelImpl.DAXOA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANGTHAI = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTrangThai",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the cap don vi hanh chinh in the entity cache if it is enabled.
	 *
	 * @param capDonViHanhChinh the cap don vi hanh chinh
	 */
	public void cacheResult(CapDonViHanhChinh capDonViHanhChinh) {
		EntityCacheUtil.putResult(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class, capDonViHanhChinh.getPrimaryKey(),
			capDonViHanhChinh);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MADONVIHANHCHINH,
			new Object[] { capDonViHanhChinh.getMa() }, capDonViHanhChinh);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDONVIHANHCHINH,
			new Object[] { capDonViHanhChinh.getTen() }, capDonViHanhChinh);

		capDonViHanhChinh.resetOriginalValues();
	}

	/**
	 * Caches the cap don vi hanh chinhs in the entity cache if it is enabled.
	 *
	 * @param capDonViHanhChinhs the cap don vi hanh chinhs
	 */
	public void cacheResult(List<CapDonViHanhChinh> capDonViHanhChinhs) {
		for (CapDonViHanhChinh capDonViHanhChinh : capDonViHanhChinhs) {
			if (EntityCacheUtil.getResult(
						CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
						CapDonViHanhChinhImpl.class,
						capDonViHanhChinh.getPrimaryKey()) == null) {
				cacheResult(capDonViHanhChinh);
			}
			else {
				capDonViHanhChinh.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cap don vi hanh chinhs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CapDonViHanhChinhImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CapDonViHanhChinhImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cap don vi hanh chinh.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CapDonViHanhChinh capDonViHanhChinh) {
		EntityCacheUtil.removeResult(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class, capDonViHanhChinh.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(capDonViHanhChinh);
	}

	@Override
	public void clearCache(List<CapDonViHanhChinh> capDonViHanhChinhs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CapDonViHanhChinh capDonViHanhChinh : capDonViHanhChinhs) {
			EntityCacheUtil.removeResult(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
				CapDonViHanhChinhImpl.class, capDonViHanhChinh.getPrimaryKey());

			clearUniqueFindersCache(capDonViHanhChinh);
		}
	}

	protected void clearUniqueFindersCache(CapDonViHanhChinh capDonViHanhChinh) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MADONVIHANHCHINH,
			new Object[] { capDonViHanhChinh.getMa() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TENDONVIHANHCHINH,
			new Object[] { capDonViHanhChinh.getTen() });
	}

	/**
	 * Creates a new cap don vi hanh chinh with the primary key. Does not add the cap don vi hanh chinh to the database.
	 *
	 * @param id the primary key for the new cap don vi hanh chinh
	 * @return the new cap don vi hanh chinh
	 */
	public CapDonViHanhChinh create(long id) {
		CapDonViHanhChinh capDonViHanhChinh = new CapDonViHanhChinhImpl();

		capDonViHanhChinh.setNew(true);
		capDonViHanhChinh.setPrimaryKey(id);

		return capDonViHanhChinh;
	}

	/**
	 * Removes the cap don vi hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cap don vi hanh chinh
	 * @return the cap don vi hanh chinh that was removed
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh remove(long id)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the cap don vi hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cap don vi hanh chinh
	 * @return the cap don vi hanh chinh that was removed
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapDonViHanhChinh remove(Serializable primaryKey)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CapDonViHanhChinh capDonViHanhChinh = (CapDonViHanhChinh)session.get(CapDonViHanhChinhImpl.class,
					primaryKey);

			if (capDonViHanhChinh == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCapDonViHanhChinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(capDonViHanhChinh);
		}
		catch (NoSuchCapDonViHanhChinhException nsee) {
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
	protected CapDonViHanhChinh removeImpl(CapDonViHanhChinh capDonViHanhChinh)
		throws SystemException {
		capDonViHanhChinh = toUnwrappedModel(capDonViHanhChinh);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, capDonViHanhChinh);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(capDonViHanhChinh);

		return capDonViHanhChinh;
	}

	@Override
	public CapDonViHanhChinh updateImpl(
		vn.dtt.cmon.dao.qlhc.model.CapDonViHanhChinh capDonViHanhChinh,
		boolean merge) throws SystemException {
		capDonViHanhChinh = toUnwrappedModel(capDonViHanhChinh);

		boolean isNew = capDonViHanhChinh.isNew();

		CapDonViHanhChinhModelImpl capDonViHanhChinhModelImpl = (CapDonViHanhChinhModelImpl)capDonViHanhChinh;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, capDonViHanhChinh, merge);

			capDonViHanhChinh.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CapDonViHanhChinhModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((capDonViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(capDonViHanhChinhModelImpl.getOriginalCap())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAP,
					args);

				args = new Object[] {
						Long.valueOf(capDonViHanhChinhModelImpl.getCap())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAP,
					args);
			}

			if ((capDonViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						capDonViHanhChinhModelImpl.getOriginalMa()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);

				args = new Object[] { capDonViHanhChinhModelImpl.getMa() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MA, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA,
					args);
			}

			if ((capDonViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						capDonViHanhChinhModelImpl.getOriginalTen()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);

				args = new Object[] { capDonViHanhChinhModelImpl.getTen() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN,
					args);
			}

			if ((capDonViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(capDonViHanhChinhModelImpl.getOriginalDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);

				args = new Object[] {
						Integer.valueOf(capDonViHanhChinhModelImpl.getDaXoa())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANGTHAI,
					args);
			}
		}

		EntityCacheUtil.putResult(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
			CapDonViHanhChinhImpl.class, capDonViHanhChinh.getPrimaryKey(),
			capDonViHanhChinh);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MADONVIHANHCHINH,
				new Object[] { capDonViHanhChinh.getMa() }, capDonViHanhChinh);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDONVIHANHCHINH,
				new Object[] { capDonViHanhChinh.getTen() }, capDonViHanhChinh);
		}
		else {
			if ((capDonViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MADONVIHANHCHINH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						capDonViHanhChinhModelImpl.getOriginalMa()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MADONVIHANHCHINH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MADONVIHANHCHINH,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MADONVIHANHCHINH,
					new Object[] { capDonViHanhChinh.getMa() },
					capDonViHanhChinh);
			}

			if ((capDonViHanhChinhModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TENDONVIHANHCHINH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						capDonViHanhChinhModelImpl.getOriginalTen()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TENDONVIHANHCHINH,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TENDONVIHANHCHINH,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDONVIHANHCHINH,
					new Object[] { capDonViHanhChinh.getTen() },
					capDonViHanhChinh);
			}
		}

		return capDonViHanhChinh;
	}

	protected CapDonViHanhChinh toUnwrappedModel(
		CapDonViHanhChinh capDonViHanhChinh) {
		if (capDonViHanhChinh instanceof CapDonViHanhChinhImpl) {
			return capDonViHanhChinh;
		}

		CapDonViHanhChinhImpl capDonViHanhChinhImpl = new CapDonViHanhChinhImpl();

		capDonViHanhChinhImpl.setNew(capDonViHanhChinh.isNew());
		capDonViHanhChinhImpl.setPrimaryKey(capDonViHanhChinh.getPrimaryKey());

		capDonViHanhChinhImpl.setId(capDonViHanhChinh.getId());
		capDonViHanhChinhImpl.setMa(capDonViHanhChinh.getMa());
		capDonViHanhChinhImpl.setTen(capDonViHanhChinh.getTen());
		capDonViHanhChinhImpl.setCap(capDonViHanhChinh.getCap());
		capDonViHanhChinhImpl.setPhienBan(capDonViHanhChinh.getPhienBan());
		capDonViHanhChinhImpl.setNgayTao(capDonViHanhChinh.getNgayTao());
		capDonViHanhChinhImpl.setNgaySua(capDonViHanhChinh.getNgaySua());
		capDonViHanhChinhImpl.setDaXoa(capDonViHanhChinh.getDaXoa());
		capDonViHanhChinhImpl.setNguoiTao(capDonViHanhChinh.getNguoiTao());
		capDonViHanhChinhImpl.setNguoiSua(capDonViHanhChinh.getNguoiSua());
		capDonViHanhChinhImpl.setMota(capDonViHanhChinh.getMota());

		return capDonViHanhChinhImpl;
	}

	/**
	 * Returns the cap don vi hanh chinh with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cap don vi hanh chinh
	 * @return the cap don vi hanh chinh
	 * @throws com.liferay.portal.NoSuchModelException if a cap don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapDonViHanhChinh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cap don vi hanh chinh with the primary key or throws a {@link vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException} if it could not be found.
	 *
	 * @param id the primary key of the cap don vi hanh chinh
	 * @return the cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh findByPrimaryKey(long id)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		CapDonViHanhChinh capDonViHanhChinh = fetchByPrimaryKey(id);

		if (capDonViHanhChinh == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchCapDonViHanhChinhException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return capDonViHanhChinh;
	}

	/**
	 * Returns the cap don vi hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cap don vi hanh chinh
	 * @return the cap don vi hanh chinh, or <code>null</code> if a cap don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapDonViHanhChinh fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cap don vi hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cap don vi hanh chinh
	 * @return the cap don vi hanh chinh, or <code>null</code> if a cap don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh fetchByPrimaryKey(long id)
		throws SystemException {
		CapDonViHanhChinh capDonViHanhChinh = (CapDonViHanhChinh)EntityCacheUtil.getResult(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
				CapDonViHanhChinhImpl.class, id);

		if (capDonViHanhChinh == _nullCapDonViHanhChinh) {
			return null;
		}

		if (capDonViHanhChinh == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				capDonViHanhChinh = (CapDonViHanhChinh)session.get(CapDonViHanhChinhImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (capDonViHanhChinh != null) {
					cacheResult(capDonViHanhChinh);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CapDonViHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
						CapDonViHanhChinhImpl.class, id, _nullCapDonViHanhChinh);
				}

				closeSession(session);
			}
		}

		return capDonViHanhChinh;
	}

	/**
	 * Returns all the cap don vi hanh chinhs where cap = &#63;.
	 *
	 * @param cap the cap
	 * @return the matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findByCap(long cap)
		throws SystemException {
		return findByCap(cap, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cap don vi hanh chinhs where cap = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cap the cap
	 * @param start the lower bound of the range of cap don vi hanh chinhs
	 * @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	 * @return the range of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findByCap(long cap, int start, int end)
		throws SystemException {
		return findByCap(cap, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cap don vi hanh chinhs where cap = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cap the cap
	 * @param start the lower bound of the range of cap don vi hanh chinhs
	 * @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findByCap(long cap, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAP;
			finderArgs = new Object[] { cap };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAP;
			finderArgs = new Object[] { cap, start, end, orderByComparator };
		}

		List<CapDonViHanhChinh> list = (List<CapDonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CAPDONVIHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_CAP_CAP_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CapDonViHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cap);

				list = (List<CapDonViHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cap don vi hanh chinh in the ordered set where cap = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cap the cap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh findByCap_First(long cap,
		OrderByComparator orderByComparator)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		List<CapDonViHanhChinh> list = findByCap(cap, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cap=");
			msg.append(cap);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cap don vi hanh chinh in the ordered set where cap = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cap the cap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh findByCap_Last(long cap,
		OrderByComparator orderByComparator)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		int count = countByCap(cap);

		List<CapDonViHanhChinh> list = findByCap(cap, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cap=");
			msg.append(cap);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cap don vi hanh chinhs before and after the current cap don vi hanh chinh in the ordered set where cap = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cap don vi hanh chinh
	 * @param cap the cap
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh[] findByCap_PrevAndNext(long id, long cap,
		OrderByComparator orderByComparator)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		CapDonViHanhChinh capDonViHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CapDonViHanhChinh[] array = new CapDonViHanhChinhImpl[3];

			array[0] = getByCap_PrevAndNext(session, capDonViHanhChinh, cap,
					orderByComparator, true);

			array[1] = capDonViHanhChinh;

			array[2] = getByCap_PrevAndNext(session, capDonViHanhChinh, cap,
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

	protected CapDonViHanhChinh getByCap_PrevAndNext(Session session,
		CapDonViHanhChinh capDonViHanhChinh, long cap,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAPDONVIHANHCHINH_WHERE);

		query.append(_FINDER_COLUMN_CAP_CAP_2);

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
			query.append(CapDonViHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cap);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(capDonViHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CapDonViHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cap don vi hanh chinhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findByMa(String ma)
		throws SystemException {
		return findByMa(ma, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cap don vi hanh chinhs where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of cap don vi hanh chinhs
	 * @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	 * @return the range of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findByMa(String ma, int start, int end)
		throws SystemException {
		return findByMa(ma, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cap don vi hanh chinhs where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param start the lower bound of the range of cap don vi hanh chinhs
	 * @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findByMa(String ma, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MA;
			finderArgs = new Object[] { ma };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MA;
			finderArgs = new Object[] { ma, start, end, orderByComparator };
		}

		List<CapDonViHanhChinh> list = (List<CapDonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CAPDONVIHANHCHINH_WHERE);

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

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CapDonViHanhChinhModelImpl.ORDER_BY_JPQL);
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

				list = (List<CapDonViHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cap don vi hanh chinh in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh findByMa_First(String ma,
		OrderByComparator orderByComparator)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		List<CapDonViHanhChinh> list = findByMa(ma, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cap don vi hanh chinh in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh findByMa_Last(String ma,
		OrderByComparator orderByComparator)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		int count = countByMa(ma);

		List<CapDonViHanhChinh> list = findByMa(ma, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cap don vi hanh chinhs before and after the current cap don vi hanh chinh in the ordered set where ma = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cap don vi hanh chinh
	 * @param ma the ma
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh[] findByMa_PrevAndNext(long id, String ma,
		OrderByComparator orderByComparator)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		CapDonViHanhChinh capDonViHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CapDonViHanhChinh[] array = new CapDonViHanhChinhImpl[3];

			array[0] = getByMa_PrevAndNext(session, capDonViHanhChinh, ma,
					orderByComparator, true);

			array[1] = capDonViHanhChinh;

			array[2] = getByMa_PrevAndNext(session, capDonViHanhChinh, ma,
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

	protected CapDonViHanhChinh getByMa_PrevAndNext(Session session,
		CapDonViHanhChinh capDonViHanhChinh, String ma,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAPDONVIHANHCHINH_WHERE);

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
			query.append(CapDonViHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (ma != null) {
			qPos.add(ma);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(capDonViHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CapDonViHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cap don vi hanh chinhs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findByTen(String ten)
		throws SystemException {
		return findByTen(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cap don vi hanh chinhs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of cap don vi hanh chinhs
	 * @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	 * @return the range of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findByTen(String ten, int start, int end)
		throws SystemException {
		return findByTen(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cap don vi hanh chinhs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of cap don vi hanh chinhs
	 * @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findByTen(String ten, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEN;
			finderArgs = new Object[] { ten };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEN;
			finderArgs = new Object[] { ten, start, end, orderByComparator };
		}

		List<CapDonViHanhChinh> list = (List<CapDonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CAPDONVIHANHCHINH_WHERE);

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

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CapDonViHanhChinhModelImpl.ORDER_BY_JPQL);
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

				list = (List<CapDonViHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cap don vi hanh chinh in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh findByTen_First(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		List<CapDonViHanhChinh> list = findByTen(ten, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cap don vi hanh chinh in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh findByTen_Last(String ten,
		OrderByComparator orderByComparator)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		int count = countByTen(ten);

		List<CapDonViHanhChinh> list = findByTen(ten, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cap don vi hanh chinhs before and after the current cap don vi hanh chinh in the ordered set where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cap don vi hanh chinh
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh[] findByTen_PrevAndNext(long id, String ten,
		OrderByComparator orderByComparator)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		CapDonViHanhChinh capDonViHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CapDonViHanhChinh[] array = new CapDonViHanhChinhImpl[3];

			array[0] = getByTen_PrevAndNext(session, capDonViHanhChinh, ten,
					orderByComparator, true);

			array[1] = capDonViHanhChinh;

			array[2] = getByTen_PrevAndNext(session, capDonViHanhChinh, ten,
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

	protected CapDonViHanhChinh getByTen_PrevAndNext(Session session,
		CapDonViHanhChinh capDonViHanhChinh, String ten,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAPDONVIHANHCHINH_WHERE);

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
			query.append(CapDonViHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (ten != null) {
			qPos.add(ten);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(capDonViHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CapDonViHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the cap don vi hanh chinh where ma = &#63; or throws a {@link vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException} if it could not be found.
	 *
	 * @param ma the ma
	 * @return the matching cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh findByMaDonViHanhChinh(String ma)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		CapDonViHanhChinh capDonViHanhChinh = fetchByMaDonViHanhChinh(ma);

		if (capDonViHanhChinh == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ma=");
			msg.append(ma);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCapDonViHanhChinhException(msg.toString());
		}

		return capDonViHanhChinh;
	}

	/**
	 * Returns the cap don vi hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ma the ma
	 * @return the matching cap don vi hanh chinh, or <code>null</code> if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh fetchByMaDonViHanhChinh(String ma)
		throws SystemException {
		return fetchByMaDonViHanhChinh(ma, true);
	}

	/**
	 * Returns the cap don vi hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ma the ma
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cap don vi hanh chinh, or <code>null</code> if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh fetchByMaDonViHanhChinh(String ma,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MADONVIHANHCHINH,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CAPDONVIHANHCHINH_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MADONVIHANHCHINH_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MADONVIHANHCHINH_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MADONVIHANHCHINH_MA_2);
				}
			}

			query.append(CapDonViHanhChinhModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ma != null) {
					qPos.add(ma);
				}

				List<CapDonViHanhChinh> list = q.list();

				result = list;

				CapDonViHanhChinh capDonViHanhChinh = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MADONVIHANHCHINH,
						finderArgs, list);
				}
				else {
					capDonViHanhChinh = list.get(0);

					cacheResult(capDonViHanhChinh);

					if ((capDonViHanhChinh.getMa() == null) ||
							!capDonViHanhChinh.getMa().equals(ma)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MADONVIHANHCHINH,
							finderArgs, capDonViHanhChinh);
					}
				}

				return capDonViHanhChinh;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MADONVIHANHCHINH,
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
				return (CapDonViHanhChinh)result;
			}
		}
	}

	/**
	 * Returns the cap don vi hanh chinh where ten = &#63; or throws a {@link vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException} if it could not be found.
	 *
	 * @param ten the ten
	 * @return the matching cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh findByTenDonViHanhChinh(String ten)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		CapDonViHanhChinh capDonViHanhChinh = fetchByTenDonViHanhChinh(ten);

		if (capDonViHanhChinh == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ten=");
			msg.append(ten);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCapDonViHanhChinhException(msg.toString());
		}

		return capDonViHanhChinh;
	}

	/**
	 * Returns the cap don vi hanh chinh where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ten the ten
	 * @return the matching cap don vi hanh chinh, or <code>null</code> if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh fetchByTenDonViHanhChinh(String ten)
		throws SystemException {
		return fetchByTenDonViHanhChinh(ten, true);
	}

	/**
	 * Returns the cap don vi hanh chinh where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ten the ten
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching cap don vi hanh chinh, or <code>null</code> if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh fetchByTenDonViHanhChinh(String ten,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TENDONVIHANHCHINH,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CAPDONVIHANHCHINH_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_TENDONVIHANHCHINH_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENDONVIHANHCHINH_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENDONVIHANHCHINH_TEN_2);
				}
			}

			query.append(CapDonViHanhChinhModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (ten != null) {
					qPos.add(ten);
				}

				List<CapDonViHanhChinh> list = q.list();

				result = list;

				CapDonViHanhChinh capDonViHanhChinh = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDONVIHANHCHINH,
						finderArgs, list);
				}
				else {
					capDonViHanhChinh = list.get(0);

					cacheResult(capDonViHanhChinh);

					if ((capDonViHanhChinh.getTen() == null) ||
							!capDonViHanhChinh.getTen().equals(ten)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TENDONVIHANHCHINH,
							finderArgs, capDonViHanhChinh);
					}
				}

				return capDonViHanhChinh;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TENDONVIHANHCHINH,
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
				return (CapDonViHanhChinh)result;
			}
		}
	}

	/**
	 * Returns all the cap don vi hanh chinhs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findByTrangThai(int daXoa)
		throws SystemException {
		return findByTrangThai(daXoa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cap don vi hanh chinhs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of cap don vi hanh chinhs
	 * @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	 * @return the range of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findByTrangThai(int daXoa, int start, int end)
		throws SystemException {
		return findByTrangThai(daXoa, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cap don vi hanh chinhs where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param start the lower bound of the range of cap don vi hanh chinhs
	 * @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findByTrangThai(int daXoa, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<CapDonViHanhChinh> list = (List<CapDonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CAPDONVIHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_TRANGTHAI_DAXOA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CapDonViHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(daXoa);

				list = (List<CapDonViHanhChinh>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first cap don vi hanh chinh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh findByTrangThai_First(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		List<CapDonViHanhChinh> list = findByTrangThai(daXoa, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last cap don vi hanh chinh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh findByTrangThai_Last(int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		int count = countByTrangThai(daXoa);

		List<CapDonViHanhChinh> list = findByTrangThai(daXoa, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("daXoa=");
			msg.append(daXoa);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCapDonViHanhChinhException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the cap don vi hanh chinhs before and after the current cap don vi hanh chinh in the ordered set where daXoa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current cap don vi hanh chinh
	 * @param daXoa the da xoa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cap don vi hanh chinh
	 * @throws vn.dtt.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapDonViHanhChinh[] findByTrangThai_PrevAndNext(long id, int daXoa,
		OrderByComparator orderByComparator)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		CapDonViHanhChinh capDonViHanhChinh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CapDonViHanhChinh[] array = new CapDonViHanhChinhImpl[3];

			array[0] = getByTrangThai_PrevAndNext(session, capDonViHanhChinh,
					daXoa, orderByComparator, true);

			array[1] = capDonViHanhChinh;

			array[2] = getByTrangThai_PrevAndNext(session, capDonViHanhChinh,
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

	protected CapDonViHanhChinh getByTrangThai_PrevAndNext(Session session,
		CapDonViHanhChinh capDonViHanhChinh, int daXoa,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAPDONVIHANHCHINH_WHERE);

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
			query.append(CapDonViHanhChinhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(daXoa);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(capDonViHanhChinh);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CapDonViHanhChinh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the cap don vi hanh chinhs.
	 *
	 * @return the cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cap don vi hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cap don vi hanh chinhs
	 * @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	 * @return the range of cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cap don vi hanh chinhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cap don vi hanh chinhs
	 * @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapDonViHanhChinh> findAll(int start, int end,
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

		List<CapDonViHanhChinh> list = (List<CapDonViHanhChinh>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAPDONVIHANHCHINH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAPDONVIHANHCHINH.concat(CapDonViHanhChinhModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CapDonViHanhChinh>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CapDonViHanhChinh>)QueryUtil.list(q,
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
	 * Removes all the cap don vi hanh chinhs where cap = &#63; from the database.
	 *
	 * @param cap the cap
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCap(long cap) throws SystemException {
		for (CapDonViHanhChinh capDonViHanhChinh : findByCap(cap)) {
			remove(capDonViHanhChinh);
		}
	}

	/**
	 * Removes all the cap don vi hanh chinhs where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMa(String ma) throws SystemException {
		for (CapDonViHanhChinh capDonViHanhChinh : findByMa(ma)) {
			remove(capDonViHanhChinh);
		}
	}

	/**
	 * Removes all the cap don vi hanh chinhs where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTen(String ten) throws SystemException {
		for (CapDonViHanhChinh capDonViHanhChinh : findByTen(ten)) {
			remove(capDonViHanhChinh);
		}
	}

	/**
	 * Removes the cap don vi hanh chinh where ma = &#63; from the database.
	 *
	 * @param ma the ma
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMaDonViHanhChinh(String ma)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		CapDonViHanhChinh capDonViHanhChinh = findByMaDonViHanhChinh(ma);

		remove(capDonViHanhChinh);
	}

	/**
	 * Removes the cap don vi hanh chinh where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTenDonViHanhChinh(String ten)
		throws NoSuchCapDonViHanhChinhException, SystemException {
		CapDonViHanhChinh capDonViHanhChinh = findByTenDonViHanhChinh(ten);

		remove(capDonViHanhChinh);
	}

	/**
	 * Removes all the cap don vi hanh chinhs where daXoa = &#63; from the database.
	 *
	 * @param daXoa the da xoa
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTrangThai(int daXoa) throws SystemException {
		for (CapDonViHanhChinh capDonViHanhChinh : findByTrangThai(daXoa)) {
			remove(capDonViHanhChinh);
		}
	}

	/**
	 * Removes all the cap don vi hanh chinhs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CapDonViHanhChinh capDonViHanhChinh : findAll()) {
			remove(capDonViHanhChinh);
		}
	}

	/**
	 * Returns the number of cap don vi hanh chinhs where cap = &#63;.
	 *
	 * @param cap the cap
	 * @return the number of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCap(long cap) throws SystemException {
		Object[] finderArgs = new Object[] { cap };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAPDONVIHANHCHINH_WHERE);

			query.append(_FINDER_COLUMN_CAP_CAP_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cap);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAP, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cap don vi hanh chinhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMa(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MA,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAPDONVIHANHCHINH_WHERE);

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
	 * Returns the number of cap don vi hanh chinhs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTen(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TEN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAPDONVIHANHCHINH_WHERE);

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
	 * Returns the number of cap don vi hanh chinhs where ma = &#63;.
	 *
	 * @param ma the ma
	 * @return the number of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMaDonViHanhChinh(String ma) throws SystemException {
		Object[] finderArgs = new Object[] { ma };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MADONVIHANHCHINH,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAPDONVIHANHCHINH_WHERE);

			if (ma == null) {
				query.append(_FINDER_COLUMN_MADONVIHANHCHINH_MA_1);
			}
			else {
				if (ma.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MADONVIHANHCHINH_MA_3);
				}
				else {
					query.append(_FINDER_COLUMN_MADONVIHANHCHINH_MA_2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MADONVIHANHCHINH,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cap don vi hanh chinhs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTenDonViHanhChinh(String ten) throws SystemException {
		Object[] finderArgs = new Object[] { ten };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TENDONVIHANHCHINH,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAPDONVIHANHCHINH_WHERE);

			if (ten == null) {
				query.append(_FINDER_COLUMN_TENDONVIHANHCHINH_TEN_1);
			}
			else {
				if (ten.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TENDONVIHANHCHINH_TEN_3);
				}
				else {
					query.append(_FINDER_COLUMN_TENDONVIHANHCHINH_TEN_2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TENDONVIHANHCHINH,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of cap don vi hanh chinhs where daXoa = &#63;.
	 *
	 * @param daXoa the da xoa
	 * @return the number of matching cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTrangThai(int daXoa) throws SystemException {
		Object[] finderArgs = new Object[] { daXoa };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANGTHAI,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAPDONVIHANHCHINH_WHERE);

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
	 * Returns the number of cap don vi hanh chinhs.
	 *
	 * @return the number of cap don vi hanh chinhs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAPDONVIHANHCHINH);

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
	 * Initializes the cap don vi hanh chinh persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.dtt.cmon.dao.qlhc.model.CapDonViHanhChinh")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CapDonViHanhChinh>> listenersList = new ArrayList<ModelListener<CapDonViHanhChinh>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CapDonViHanhChinh>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CapDonViHanhChinhImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CapCoQuanQuanLyPersistence.class)
	protected CapCoQuanQuanLyPersistence capCoQuanQuanLyPersistence;
	@BeanReference(type = CapDonViHanhChinhPersistence.class)
	protected CapDonViHanhChinhPersistence capDonViHanhChinhPersistence;
	@BeanReference(type = ChucVu2VaiTroPersistence.class)
	protected ChucVu2VaiTroPersistence chucVu2VaiTroPersistence;
	@BeanReference(type = CoQuanHanhChinhSuNghiepPersistence.class)
	protected CoQuanHanhChinhSuNghiepPersistence coQuanHanhChinhSuNghiepPersistence;
	@BeanReference(type = CoQuanQuanLyPersistence.class)
	protected CoQuanQuanLyPersistence coQuanQuanLyPersistence;
	@BeanReference(type = DonViHanhChinhPersistence.class)
	protected DonViHanhChinhPersistence donViHanhChinhPersistence;
	@BeanReference(type = QuocGiaPersistence.class)
	protected QuocGiaPersistence quocGiaPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CAPDONVIHANHCHINH = "SELECT capDonViHanhChinh FROM CapDonViHanhChinh capDonViHanhChinh";
	private static final String _SQL_SELECT_CAPDONVIHANHCHINH_WHERE = "SELECT capDonViHanhChinh FROM CapDonViHanhChinh capDonViHanhChinh WHERE ";
	private static final String _SQL_COUNT_CAPDONVIHANHCHINH = "SELECT COUNT(capDonViHanhChinh) FROM CapDonViHanhChinh capDonViHanhChinh";
	private static final String _SQL_COUNT_CAPDONVIHANHCHINH_WHERE = "SELECT COUNT(capDonViHanhChinh) FROM CapDonViHanhChinh capDonViHanhChinh WHERE ";
	private static final String _FINDER_COLUMN_CAP_CAP_2 = "capDonViHanhChinh.cap = ?";
	private static final String _FINDER_COLUMN_MA_MA_1 = "capDonViHanhChinh.ma IS NULL";
	private static final String _FINDER_COLUMN_MA_MA_2 = "capDonViHanhChinh.ma = ?";
	private static final String _FINDER_COLUMN_MA_MA_3 = "(capDonViHanhChinh.ma IS NULL OR capDonViHanhChinh.ma = ?)";
	private static final String _FINDER_COLUMN_TEN_TEN_1 = "capDonViHanhChinh.ten IS NULL";
	private static final String _FINDER_COLUMN_TEN_TEN_2 = "capDonViHanhChinh.ten = ?";
	private static final String _FINDER_COLUMN_TEN_TEN_3 = "(capDonViHanhChinh.ten IS NULL OR capDonViHanhChinh.ten = ?)";
	private static final String _FINDER_COLUMN_MADONVIHANHCHINH_MA_1 = "capDonViHanhChinh.ma IS NULL";
	private static final String _FINDER_COLUMN_MADONVIHANHCHINH_MA_2 = "capDonViHanhChinh.ma = ?";
	private static final String _FINDER_COLUMN_MADONVIHANHCHINH_MA_3 = "(capDonViHanhChinh.ma IS NULL OR capDonViHanhChinh.ma = ?)";
	private static final String _FINDER_COLUMN_TENDONVIHANHCHINH_TEN_1 = "capDonViHanhChinh.ten IS NULL";
	private static final String _FINDER_COLUMN_TENDONVIHANHCHINH_TEN_2 = "capDonViHanhChinh.ten = ?";
	private static final String _FINDER_COLUMN_TENDONVIHANHCHINH_TEN_3 = "(capDonViHanhChinh.ten IS NULL OR capDonViHanhChinh.ten = ?)";
	private static final String _FINDER_COLUMN_TRANGTHAI_DAXOA_2 = "capDonViHanhChinh.daXoa = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "capDonViHanhChinh.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CapDonViHanhChinh exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CapDonViHanhChinh exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CapDonViHanhChinhPersistenceImpl.class);
	private static CapDonViHanhChinh _nullCapDonViHanhChinh = new CapDonViHanhChinhImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CapDonViHanhChinh> toCacheModel() {
				return _nullCapDonViHanhChinhCacheModel;
			}
		};

	private static CacheModel<CapDonViHanhChinh> _nullCapDonViHanhChinhCacheModel =
		new CacheModel<CapDonViHanhChinh>() {
			public CapDonViHanhChinh toEntityModel() {
				return _nullCapDonViHanhChinh;
			}
		};
}