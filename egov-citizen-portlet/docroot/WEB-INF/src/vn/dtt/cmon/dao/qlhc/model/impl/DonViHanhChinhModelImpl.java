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

package vn.dtt.cmon.dao.qlhc.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh;
import vn.dtt.cmon.dao.qlhc.model.DonViHanhChinhModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;

/**
 * The base model implementation for the DonViHanhChinh service. Represents a row in the &quot;CMON_DONVIHANHCHINH&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.dtt.cmon.dao.qlhc.model.DonViHanhChinhModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DonViHanhChinhImpl}.
 * </p>
 *
 * @author LIEMNN
 * @see DonViHanhChinhImpl
 * @see vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh
 * @see vn.dtt.cmon.dao.qlhc.model.DonViHanhChinhModel
 * @generated
 */
public class DonViHanhChinhModelImpl extends BaseModelImpl<DonViHanhChinh>
	implements DonViHanhChinhModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a don vi hanh chinh model instance should use the {@link vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh} interface instead.
	 */
	public static final String TABLE_NAME = "CMON_DONVIHANHCHINH";
	public static final Object[][] TABLE_COLUMNS = {
			{ "ID", Types.BIGINT },
			{ "MA", Types.VARCHAR },
			{ "TEN", Types.VARCHAR },
			{ "NGAYTAO", Types.TIMESTAMP },
			{ "PHIENBAN", Types.BIGINT },
			{ "DAXOA", Types.INTEGER },
			{ "NGAYSUA", Types.TIMESTAMP },
			{ "CAPDONVIHANHCHINHID", Types.BIGINT },
			{ "CHAID", Types.BIGINT },
			{ "NGUOITAO", Types.VARCHAR },
			{ "QUOCGIAID", Types.BIGINT },
			{ "NGUOISUA", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table CMON_DONVIHANHCHINH (ID LONG not null primary key,MA VARCHAR(75) null,TEN VARCHAR(75) null,NGAYTAO DATE null,PHIENBAN LONG,DAXOA INTEGER,NGAYSUA DATE null,CAPDONVIHANHCHINHID LONG,CHAID LONG null,NGUOITAO VARCHAR(75) null,QUOCGIAID LONG,NGUOISUA VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table CMON_DONVIHANHCHINH";
	public static final String ORDER_BY_JPQL = " ORDER BY donViHanhChinh.id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CMON_DONVIHANHCHINH.ID ASC";
	public static final String DATA_SOURCE = "egovDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh"),
			true);
	public static long CAPDONVIHANHCHINHID_COLUMN_BITMASK = 1L;
	public static long CHAID_COLUMN_BITMASK = 2L;
	public static long DAXOA_COLUMN_BITMASK = 4L;
	public static long MA_COLUMN_BITMASK = 8L;
	public static long QUOCGIAID_COLUMN_BITMASK = 16L;
	public static long TEN_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh"));

	public DonViHanhChinhModelImpl() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return DonViHanhChinh.class;
	}

	public String getModelClassName() {
		return DonViHanhChinh.class.getName();
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_columnBitmask = -1L;

		_id = id;
	}

	public String getMa() {
		if (_ma == null) {
			return StringPool.BLANK;
		}
		else {
			return _ma;
		}
	}

	public void setMa(String ma) {
		_columnBitmask |= MA_COLUMN_BITMASK;

		if (_originalMa == null) {
			_originalMa = _ma;
		}

		_ma = ma;
	}

	public String getOriginalMa() {
		return GetterUtil.getString(_originalMa);
	}

	public String getTen() {
		if (_ten == null) {
			return StringPool.BLANK;
		}
		else {
			return _ten;
		}
	}

	public void setTen(String ten) {
		_columnBitmask |= TEN_COLUMN_BITMASK;

		if (_originalTen == null) {
			_originalTen = _ten;
		}

		_ten = ten;
	}

	public String getOriginalTen() {
		return GetterUtil.getString(_originalTen);
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public long getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(long phienBan) {
		_phienBan = phienBan;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_columnBitmask |= DAXOA_COLUMN_BITMASK;

		if (!_setOriginalDaXoa) {
			_setOriginalDaXoa = true;

			_originalDaXoa = _daXoa;
		}

		_daXoa = daXoa;
	}

	public int getOriginalDaXoa() {
		return _originalDaXoa;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public long getCapDonViHanhChinhId() {
		return _capDonViHanhChinhId;
	}

	public void setCapDonViHanhChinhId(long capDonViHanhChinhId) {
		_columnBitmask |= CAPDONVIHANHCHINHID_COLUMN_BITMASK;

		if (!_setOriginalCapDonViHanhChinhId) {
			_setOriginalCapDonViHanhChinhId = true;

			_originalCapDonViHanhChinhId = _capDonViHanhChinhId;
		}

		_capDonViHanhChinhId = capDonViHanhChinhId;
	}

	public long getOriginalCapDonViHanhChinhId() {
		return _originalCapDonViHanhChinhId;
	}

	public Long getChaId() {
		return _chaId;
	}

	public void setChaId(Long chaId) {
		_columnBitmask |= CHAID_COLUMN_BITMASK;

		if (!_setOriginalChaId) {
			_setOriginalChaId = true;

			_originalChaId = _chaId;
		}

		_chaId = chaId;
	}

	public Long getOriginalChaId() {
		return _originalChaId;
	}

	public String getNguoiTao() {
		if (_nguoiTao == null) {
			return StringPool.BLANK;
		}
		else {
			return _nguoiTao;
		}
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public long getQuocGiaId() {
		return _quocGiaId;
	}

	public void setQuocGiaId(long quocGiaId) {
		_columnBitmask |= QUOCGIAID_COLUMN_BITMASK;

		if (!_setOriginalQuocGiaId) {
			_setOriginalQuocGiaId = true;

			_originalQuocGiaId = _quocGiaId;
		}

		_quocGiaId = quocGiaId;
	}

	public long getOriginalQuocGiaId() {
		return _originalQuocGiaId;
	}

	public String getNguoiSua() {
		if (_nguoiSua == null) {
			return StringPool.BLANK;
		}
		else {
			return _nguoiSua;
		}
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public DonViHanhChinh toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (DonViHanhChinh)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					DonViHanhChinh.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		DonViHanhChinhImpl donViHanhChinhImpl = new DonViHanhChinhImpl();

		donViHanhChinhImpl.setId(getId());
		donViHanhChinhImpl.setMa(getMa());
		donViHanhChinhImpl.setTen(getTen());
		donViHanhChinhImpl.setNgayTao(getNgayTao());
		donViHanhChinhImpl.setPhienBan(getPhienBan());
		donViHanhChinhImpl.setDaXoa(getDaXoa());
		donViHanhChinhImpl.setNgaySua(getNgaySua());
		donViHanhChinhImpl.setCapDonViHanhChinhId(getCapDonViHanhChinhId());
		donViHanhChinhImpl.setChaId(getChaId());
		donViHanhChinhImpl.setNguoiTao(getNguoiTao());
		donViHanhChinhImpl.setQuocGiaId(getQuocGiaId());
		donViHanhChinhImpl.setNguoiSua(getNguoiSua());

		donViHanhChinhImpl.resetOriginalValues();

		return donViHanhChinhImpl;
	}

	public int compareTo(DonViHanhChinh donViHanhChinh) {
		int value = 0;

		if (getId() < donViHanhChinh.getId()) {
			value = -1;
		}
		else if (getId() > donViHanhChinh.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		DonViHanhChinh donViHanhChinh = null;

		try {
			donViHanhChinh = (DonViHanhChinh)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = donViHanhChinh.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		DonViHanhChinhModelImpl donViHanhChinhModelImpl = this;

		donViHanhChinhModelImpl._originalMa = donViHanhChinhModelImpl._ma;

		donViHanhChinhModelImpl._originalTen = donViHanhChinhModelImpl._ten;

		donViHanhChinhModelImpl._originalDaXoa = donViHanhChinhModelImpl._daXoa;

		donViHanhChinhModelImpl._setOriginalDaXoa = false;

		donViHanhChinhModelImpl._originalCapDonViHanhChinhId = donViHanhChinhModelImpl._capDonViHanhChinhId;

		donViHanhChinhModelImpl._setOriginalCapDonViHanhChinhId = false;

		donViHanhChinhModelImpl._originalChaId = donViHanhChinhModelImpl._chaId;

		donViHanhChinhModelImpl._setOriginalChaId = false;

		donViHanhChinhModelImpl._originalQuocGiaId = donViHanhChinhModelImpl._quocGiaId;

		donViHanhChinhModelImpl._setOriginalQuocGiaId = false;

		donViHanhChinhModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DonViHanhChinh> toCacheModel() {
		DonViHanhChinhCacheModel donViHanhChinhCacheModel = new DonViHanhChinhCacheModel();

		donViHanhChinhCacheModel.id = getId();

		donViHanhChinhCacheModel.ma = getMa();

		String ma = donViHanhChinhCacheModel.ma;

		if ((ma != null) && (ma.length() == 0)) {
			donViHanhChinhCacheModel.ma = null;
		}

		donViHanhChinhCacheModel.ten = getTen();

		String ten = donViHanhChinhCacheModel.ten;

		if ((ten != null) && (ten.length() == 0)) {
			donViHanhChinhCacheModel.ten = null;
		}

		Date ngayTao = getNgayTao();

		if (ngayTao != null) {
			donViHanhChinhCacheModel.ngayTao = ngayTao.getTime();
		}
		else {
			donViHanhChinhCacheModel.ngayTao = Long.MIN_VALUE;
		}

		donViHanhChinhCacheModel.phienBan = getPhienBan();

		donViHanhChinhCacheModel.daXoa = getDaXoa();

		Date ngaySua = getNgaySua();

		if (ngaySua != null) {
			donViHanhChinhCacheModel.ngaySua = ngaySua.getTime();
		}
		else {
			donViHanhChinhCacheModel.ngaySua = Long.MIN_VALUE;
		}

		donViHanhChinhCacheModel.capDonViHanhChinhId = getCapDonViHanhChinhId();

		donViHanhChinhCacheModel.chaId = getChaId();

		donViHanhChinhCacheModel.nguoiTao = getNguoiTao();

		String nguoiTao = donViHanhChinhCacheModel.nguoiTao;

		if ((nguoiTao != null) && (nguoiTao.length() == 0)) {
			donViHanhChinhCacheModel.nguoiTao = null;
		}

		donViHanhChinhCacheModel.quocGiaId = getQuocGiaId();

		donViHanhChinhCacheModel.nguoiSua = getNguoiSua();

		String nguoiSua = donViHanhChinhCacheModel.nguoiSua;

		if ((nguoiSua != null) && (nguoiSua.length() == 0)) {
			donViHanhChinhCacheModel.nguoiSua = null;
		}

		return donViHanhChinhCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", ma=");
		sb.append(getMa());
		sb.append(", ten=");
		sb.append(getTen());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", phienBan=");
		sb.append(getPhienBan());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", capDonViHanhChinhId=");
		sb.append(getCapDonViHanhChinhId());
		sb.append(", chaId=");
		sb.append(getChaId());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", quocGiaId=");
		sb.append(getQuocGiaId());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ma</column-name><column-value><![CDATA[");
		sb.append(getMa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ten</column-name><column-value><![CDATA[");
		sb.append(getTen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phienBan</column-name><column-value><![CDATA[");
		sb.append(getPhienBan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capDonViHanhChinhId</column-name><column-value><![CDATA[");
		sb.append(getCapDonViHanhChinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chaId</column-name><column-value><![CDATA[");
		sb.append(getChaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quocGiaId</column-name><column-value><![CDATA[");
		sb.append(getQuocGiaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DonViHanhChinh.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			DonViHanhChinh.class
		};
	private long _id;
	private String _ma;
	private String _originalMa;
	private String _ten;
	private String _originalTen;
	private Date _ngayTao;
	private long _phienBan;
	private int _daXoa;
	private int _originalDaXoa;
	private boolean _setOriginalDaXoa;
	private Date _ngaySua;
	private long _capDonViHanhChinhId;
	private long _originalCapDonViHanhChinhId;
	private boolean _setOriginalCapDonViHanhChinhId;
	private Long _chaId;
	private Long _originalChaId;
	private boolean _setOriginalChaId;
	private String _nguoiTao;
	private long _quocGiaId;
	private long _originalQuocGiaId;
	private boolean _setOriginalQuocGiaId;
	private String _nguoiSua;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private DonViHanhChinh _escapedModelProxy;
}