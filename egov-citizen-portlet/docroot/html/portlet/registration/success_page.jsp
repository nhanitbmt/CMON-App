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
<%@ include file="/html/portlet/registration/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:renderURL windowState="maximized" var="myURL">
    <portlet:param name="type" value="0" />
    <portlet:param name="jspPage" value="/html/portlet/registration/success_page.jsp" />
</portlet:renderURL>

<br/>
	<div class="egov-info-success" style='width:700px;margin-top:0px;margin-left:0px'>
	<%
	int type = ParamUtil.getInteger(request, "type");
	System.out.println("type in success page:"+type);
	String authCode = ParamUtil.getString(request, "authCode");
	System.out.println("authCode in success page:"+authCode);
	
	if (type == 0) { %>
	<label class="egov-label-bold">
		Cám ơn bạn đã xác nhận email của mình
	</label>
	<% 
		} else {
	%>
	<label class="egov-label-bold">
		Thông tin về tài khoản người dùng đã được gửi đến email của bạn, bạn hãy kiểm tra email để có được thông tin về tài khoản của mình
	</label>
	<% } %>
	
	</div>
