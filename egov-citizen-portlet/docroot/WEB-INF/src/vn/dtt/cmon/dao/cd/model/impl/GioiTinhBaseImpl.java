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

package vn.dtt.cmon.dao.cd.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import vn.dtt.cmon.dao.cd.model.GioiTinh;
import vn.dtt.cmon.dao.cd.service.GioiTinhLocalServiceUtil;

/**
 * The extended model base implementation for the GioiTinh service. Represents a row in the &quot;CMON_GIOITINH&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GioiTinhImpl}.
 * </p>
 *
 * @author LIEMNN
 * @see GioiTinhImpl
 * @see vn.dtt.cmon.dao.cd.model.GioiTinh
 * @generated
 */
public abstract class GioiTinhBaseImpl extends GioiTinhModelImpl
	implements GioiTinh {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a gioi tinh model instance should use the {@link GioiTinh} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			GioiTinhLocalServiceUtil.addGioiTinh(this);
		}
		else {
			GioiTinhLocalServiceUtil.updateGioiTinh(this);
		}
	}
}