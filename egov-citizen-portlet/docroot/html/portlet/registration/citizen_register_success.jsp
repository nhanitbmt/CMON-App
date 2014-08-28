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

<%
	String email = ParamUtil.getString(request, "emailCongDan");
%>
					
	<div class="egov-info-success" style='width:700px;margin-top:0px;margin-left:0px'>

		<h1>Cảm ơn bạn đã đăng ký tài khoản trên hệ thống chạy thử.</h1>

			
		
		<label class ="egov-label-bold">
		Để có thể sử dụng tài khoạn bạn vừa đăng ký vui lòng chọn 1 tài khoản cán bộ để xác thực tài khoản của bạn.</label>
		<hr>
		Đăng nhập hệ thống để xác thực <a href="/c/portal/login" style='text-decoration: none;'>
			<input type="button" class="egov-button" value='Đăng nhập để xác thực'> 
		</a>
		

	</div>
	<br>
	<br>
		<h1 style="float:left;">Danh sách tài khoản  cung cấp xác thực</h1>
		<table cellpadding="0" cellspacing="0" width="90%" class="egov-table">
		<tr>
			<th>TT</th>
			<th>Tài khoản đăng nhập</th>
			<th>Mật khẩu </th>
		</tr>
		<tr>	
			<td><b>1</b></td>
			<td><a href="#">oep-01@openegovplatform.org</a></td>
			<td><b>oep-01</b></td>
		</tr>
		
		<tr>	
			<td><b>2</b></td>
			<td><a href="#">oep-02@openegovplatform.org</a></td>
			<td><b>oep-02</b></td>
		</tr>
		<tr>	
			<td><b>3</b></td>
			<td><a href="#">oep-03@openegovplatform.org</a></td>
			<td><b>oep-03</b></td>
		</tr>
		<tr>	
			<td><b>4</b></td>
			<td><a href="#">oep-04@openegovplatform.org</a></td>
			<td><b>oep-04</b></td>
		</tr>
		<tr>	
			<td><b>5</b></td>
			<td><a href="#">oep-05@openegovplatform.org</a></td>
			<td><b>oep-05</b></td>
		</tr>
		</table> 
					
					
	


