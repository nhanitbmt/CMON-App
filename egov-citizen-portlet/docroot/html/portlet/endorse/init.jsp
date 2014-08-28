<%--
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
--%>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="java.util.*"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="vn.dtt.cmon.utils.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="vn.dtt.cmon.dao.qlhc.model.QuocGia"%>
<%@page import="vn.dtt.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dao.cd.service.TonGiaoLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dao.cd.model.TonGiao"%>
<%@page import="vn.dtt.cmon.dao.cd.model.DanToc"%>
<%@page import="vn.dtt.cmon.dao.cd.service.DanTocLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dao.cd.model.GioiTinh"%>
<%@page import="vn.dtt.cmon.dao.cd.service.GioiTinhLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dao.qlhc.model.DonViHanhChinh"%>
<%@page import="vn.dtt.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil"%>
<%@page import="vn.dtt.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="vn.dtt.cmon.utils.StringUtil"%>
<%@page import="vn.dtt.cmon.dao.cd.model.YeuCauDangKyCongDan"%>
<%@page import="vn.dtt.cmon.portlet.endorse.action.UserEndorsePortlet"%>
<%@page import="com.liferay.counter.service.CounterLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>



<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />