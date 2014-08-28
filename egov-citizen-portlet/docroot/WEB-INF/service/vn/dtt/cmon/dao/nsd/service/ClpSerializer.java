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

package vn.dtt.cmon.dao.nsd.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import vn.dtt.cmon.dao.nsd.model.TaiKhoanNguoiDungClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"egov-citizen-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"egov-citizen-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "egov-citizen-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(TaiKhoanNguoiDungClp.class.getName())) {
			return translateInputTaiKhoanNguoiDung(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputTaiKhoanNguoiDung(BaseModel<?> oldModel) {
		TaiKhoanNguoiDungClp oldCplModel = (TaiKhoanNguoiDungClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.dtt.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTenDangNhap",
						new Class[] { String.class });

				String value1 = oldCplModel.getTenDangNhap();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setMatKhau",
						new Class[] { String.class });

				String value2 = oldCplModel.getMatKhau();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setTenNguoiDung",
						new Class[] { String.class });

				String value3 = oldCplModel.getTenNguoiDung();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCauHoiMatKhau",
						new Class[] { String.class });

				String value4 = oldCplModel.getCauHoiMatKhau();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCauTraLoiMatKhau",
						new Class[] { String.class });

				String value5 = oldCplModel.getCauTraLoiMatKhau();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setEmail",
						new Class[] { String.class });

				String value6 = oldCplModel.getEmail();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setNgayTao",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getNgayTao();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setDaXoa",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getDaXoa());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setNgaySua",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getNgaySua();

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setNguoiTao",
						new Class[] { String.class });

				String value10 = oldCplModel.getNguoiTao();

				method10.invoke(newModel, value10);

				Method method11 = newModelClass.getMethod("setNguoiSua",
						new Class[] { String.class });

				String value11 = oldCplModel.getNguoiSua();

				method11.invoke(newModel, value11);

				Method method12 = newModelClass.getMethod("setTrangThai",
						new Class[] { Integer.TYPE });

				Integer value12 = new Integer(oldCplModel.getTrangThai());

				method12.invoke(newModel, value12);

				Method method13 = newModelClass.getMethod("setLoaiDoiTuongId",
						new Class[] { Long.TYPE });

				Long value13 = new Long(oldCplModel.getLoaiDoiTuongId());

				method13.invoke(newModel, value13);

				Method method14 = newModelClass.getMethod("setTaiKhoanNguoiDungId",
						new Class[] { Long.TYPE });

				Long value14 = new Long(oldCplModel.getTaiKhoanNguoiDungId());

				method14.invoke(newModel, value14);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"vn.dtt.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl")) {
			return translateOutputTaiKhoanNguoiDung(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputTaiKhoanNguoiDung(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				TaiKhoanNguoiDungClp newModel = new TaiKhoanNguoiDungClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setId(value0);

				Method method1 = oldModelClass.getMethod("getTenDangNhap");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setTenDangNhap(value1);

				Method method2 = oldModelClass.getMethod("getMatKhau");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setMatKhau(value2);

				Method method3 = oldModelClass.getMethod("getTenNguoiDung");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setTenNguoiDung(value3);

				Method method4 = oldModelClass.getMethod("getCauHoiMatKhau");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setCauHoiMatKhau(value4);

				Method method5 = oldModelClass.getMethod("getCauTraLoiMatKhau");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setCauTraLoiMatKhau(value5);

				Method method6 = oldModelClass.getMethod("getEmail");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setEmail(value6);

				Method method7 = oldModelClass.getMethod("getNgayTao");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setNgayTao(value7);

				Method method8 = oldModelClass.getMethod("getDaXoa");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setDaXoa(value8);

				Method method9 = oldModelClass.getMethod("getNgaySua");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setNgaySua(value9);

				Method method10 = oldModelClass.getMethod("getNguoiTao");

				String value10 = (String)method10.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiTao(value10);

				Method method11 = oldModelClass.getMethod("getNguoiSua");

				String value11 = (String)method11.invoke(oldModel,
						(Object[])null);

				newModel.setNguoiSua(value11);

				Method method12 = oldModelClass.getMethod("getTrangThai");

				Integer value12 = (Integer)method12.invoke(oldModel,
						(Object[])null);

				newModel.setTrangThai(value12);

				Method method13 = oldModelClass.getMethod("getLoaiDoiTuongId");

				Long value13 = (Long)method13.invoke(oldModel, (Object[])null);

				newModel.setLoaiDoiTuongId(value13);

				Method method14 = oldModelClass.getMethod(
						"getTaiKhoanNguoiDungId");

				Long value14 = (Long)method14.invoke(oldModel, (Object[])null);

				newModel.setTaiKhoanNguoiDungId(value14);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}