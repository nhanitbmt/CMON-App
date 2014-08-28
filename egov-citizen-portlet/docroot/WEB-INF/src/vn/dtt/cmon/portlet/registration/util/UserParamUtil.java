/*
 * Copyright (c) 2014 by DTT Technology Joint Stock Company (http://dtt.vn/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package vn.dtt.cmon.portlet.registration.util;

import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;

public class UserParamUtil {
	public static void setParams(ActionRequest resourceRequest) {
		Enumeration<String> listName = resourceRequest.getParameterNames();
		String values = "";
		while (listName.hasMoreElements()) {
			values = listName.nextElement();
			resourceRequest.setAttribute(values,
					ParamUtil.getString(resourceRequest, values));
		}
	}
	
	

	public static String getValueString(
			HttpServletRequest resHttpServletRequest, String key) {
		try {
			if (resHttpServletRequest.getAttribute(key) != null) {
				return resHttpServletRequest.getAttribute(key).toString()
						.trim();
			}
		} catch (Exception es) {
		}

		return "";
	}
	
	
}
