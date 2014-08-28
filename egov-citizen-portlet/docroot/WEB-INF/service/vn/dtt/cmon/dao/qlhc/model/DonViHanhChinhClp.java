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

package vn.dtt.cmon.dao.qlhc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.dtt.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNN
 */
public class DonViHanhChinhClp extends BaseModelImpl<DonViHanhChinh>
	implements DonViHanhChinh {
	public DonViHanhChinhClp() {
	}

	public Class<?> getModelClass() {
		return DonViHanhChinh.class;
	}

	public String getModelClassName() {
		return DonViHanhChinh.class.getName();
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

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
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
		_daXoa = daXoa;
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
		_capDonViHanhChinhId = capDonViHanhChinhId;
	}

	public Long getChaId() {
		return _chaId;
	}

	public void setChaId(Long chaId) {
		_chaId = chaId;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public long getQuocGiaId() {
		return _quocGiaId;
	}

	public void setQuocGiaId(long quocGiaId) {
		_quocGiaId = quocGiaId;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DonViHanhChinhLocalServiceUtil.addDonViHanhChinh(this);
		}
		else {
			DonViHanhChinhLocalServiceUtil.updateDonViHanhChinh(this);
		}
	}

	@Override
	public DonViHanhChinh toEscapedModel() {
		return (DonViHanhChinh)Proxy.newProxyInstance(DonViHanhChinh.class.getClassLoader(),
			new Class[] { DonViHanhChinh.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DonViHanhChinhClp clone = new DonViHanhChinhClp();

		clone.setId(getId());
		clone.setMa(getMa());
		clone.setTen(getTen());
		clone.setNgayTao(getNgayTao());
		clone.setPhienBan(getPhienBan());
		clone.setDaXoa(getDaXoa());
		clone.setNgaySua(getNgaySua());
		clone.setCapDonViHanhChinhId(getCapDonViHanhChinhId());
		clone.setChaId(getChaId());
		clone.setNguoiTao(getNguoiTao());
		clone.setQuocGiaId(getQuocGiaId());
		clone.setNguoiSua(getNguoiSua());

		return clone;
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

		DonViHanhChinhClp donViHanhChinh = null;

		try {
			donViHanhChinh = (DonViHanhChinhClp)obj;
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

	private long _id;
	private String _ma;
	private String _ten;
	private Date _ngayTao;
	private long _phienBan;
	private int _daXoa;
	private Date _ngaySua;
	private long _capDonViHanhChinhId;
	private Long _chaId;
	private String _nguoiTao;
	private long _quocGiaId;
	private String _nguoiSua;
}