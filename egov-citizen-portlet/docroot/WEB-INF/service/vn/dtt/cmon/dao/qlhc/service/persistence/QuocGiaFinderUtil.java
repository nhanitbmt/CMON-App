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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author LIEMNN
 */
public class QuocGiaFinderUtil {
	public static java.util.List<vn.dtt.cmon.dao.qlhc.model.QuocGia> findAll() {
		return getFinder().findAll();
	}

	public static QuocGiaFinder getFinder() {
		if (_finder == null) {
			_finder = (QuocGiaFinder)PortletBeanLocatorUtil.locate(vn.dtt.cmon.dao.qlhc.service.ClpSerializer.getServletContextName(),
					QuocGiaFinder.class.getName());

			ReferenceRegistry.registerReference(QuocGiaFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(QuocGiaFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(QuocGiaFinderUtil.class, "_finder");
	}

	private static QuocGiaFinder _finder;
}