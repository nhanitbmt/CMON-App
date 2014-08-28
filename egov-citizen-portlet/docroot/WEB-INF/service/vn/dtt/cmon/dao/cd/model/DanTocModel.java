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

package vn.dtt.cmon.dao.cd.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the DanToc service. Represents a row in the &quot;CMON_DANTOC&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.dtt.cmon.dao.cd.model.impl.DanTocModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.dtt.cmon.dao.cd.model.impl.DanTocImpl}.
 * </p>
 *
 * @author LIEMNN
 * @see DanToc
 * @see vn.dtt.cmon.dao.cd.model.impl.DanTocImpl
 * @see vn.dtt.cmon.dao.cd.model.impl.DanTocModelImpl
 * @generated
 */
public interface DanTocModel extends BaseModel<DanToc> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dan toc model instance should use the {@link DanToc} interface instead.
	 */

	/**
	 * Returns the primary key of this dan toc.
	 *
	 * @return the primary key of this dan toc
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dan toc.
	 *
	 * @param primaryKey the primary key of this dan toc
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this dan toc.
	 *
	 * @return the ID of this dan toc
	 */
	public long getId();

	/**
	 * Sets the ID of this dan toc.
	 *
	 * @param id the ID of this dan toc
	 */
	public void setId(long id);

	/**
	 * Returns the ma of this dan toc.
	 *
	 * @return the ma of this dan toc
	 */
	@AutoEscape
	public String getMa();

	/**
	 * Sets the ma of this dan toc.
	 *
	 * @param ma the ma of this dan toc
	 */
	public void setMa(String ma);

	/**
	 * Returns the ten of this dan toc.
	 *
	 * @return the ten of this dan toc
	 */
	@AutoEscape
	public String getTen();

	/**
	 * Sets the ten of this dan toc.
	 *
	 * @param ten the ten of this dan toc
	 */
	public void setTen(String ten);

	/**
	 * Returns the phien ban of this dan toc.
	 *
	 * @return the phien ban of this dan toc
	 */
	public long getPhienBan();

	/**
	 * Sets the phien ban of this dan toc.
	 *
	 * @param phienBan the phien ban of this dan toc
	 */
	public void setPhienBan(long phienBan);

	/**
	 * Returns the la thieu so of this dan toc.
	 *
	 * @return the la thieu so of this dan toc
	 */
	public long getLaThieuSo();

	/**
	 * Sets the la thieu so of this dan toc.
	 *
	 * @param laThieuSo the la thieu so of this dan toc
	 */
	public void setLaThieuSo(long laThieuSo);

	/**
	 * Returns the ngay tao of this dan toc.
	 *
	 * @return the ngay tao of this dan toc
	 */
	public Date getNgayTao();

	/**
	 * Sets the ngay tao of this dan toc.
	 *
	 * @param ngayTao the ngay tao of this dan toc
	 */
	public void setNgayTao(Date ngayTao);

	/**
	 * Returns the da xoa of this dan toc.
	 *
	 * @return the da xoa of this dan toc
	 */
	public int getDaXoa();

	/**
	 * Sets the da xoa of this dan toc.
	 *
	 * @param daXoa the da xoa of this dan toc
	 */
	public void setDaXoa(int daXoa);

	/**
	 * Returns the nguoi tao of this dan toc.
	 *
	 * @return the nguoi tao of this dan toc
	 */
	@AutoEscape
	public String getNguoiTao();

	/**
	 * Sets the nguoi tao of this dan toc.
	 *
	 * @param nguoiTao the nguoi tao of this dan toc
	 */
	public void setNguoiTao(String nguoiTao);

	/**
	 * Returns the nguoi sua of this dan toc.
	 *
	 * @return the nguoi sua of this dan toc
	 */
	@AutoEscape
	public String getNguoiSua();

	/**
	 * Sets the nguoi sua of this dan toc.
	 *
	 * @param nguoiSua the nguoi sua of this dan toc
	 */
	public void setNguoiSua(String nguoiSua);

	/**
	 * Returns the ten khac of this dan toc.
	 *
	 * @return the ten khac of this dan toc
	 */
	@AutoEscape
	public String getTenKhac();

	/**
	 * Sets the ten khac of this dan toc.
	 *
	 * @param tenKhac the ten khac of this dan toc
	 */
	public void setTenKhac(String tenKhac);

	/**
	 * Returns the ngay sua of this dan toc.
	 *
	 * @return the ngay sua of this dan toc
	 */
	public Date getNgaySua();

	/**
	 * Sets the ngay sua of this dan toc.
	 *
	 * @param ngaySua the ngay sua of this dan toc
	 */
	public void setNgaySua(Date ngaySua);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(DanToc danToc);

	public int hashCode();

	public CacheModel<DanToc> toCacheModel();

	public DanToc toEscapedModel();

	public String toString();

	public String toXmlString();
}