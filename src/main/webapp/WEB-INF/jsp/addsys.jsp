<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="save" enctype="multipart/form-data" method="post">
	<table>
		<tr>
			<td colspan="2">${title}</td>
		</tr>
		<tr>
			<td>* 标准号</td>
			<td><input type="text" value="${stan.std_num}" name="std_num"></td>
		</tr>
		<tr>
			<td>* 中文名称</td>
			<td><input type="text" value="${stan.zhname}" name="zhname"></td>
		</tr>
		<tr>
			<td>* 版本</td>
			<td><input type="text" value="${stan.version}" name="version"></td>
		</tr>
		<tr>
			<td>* 关键字、词</td>
			<td><input type="text" value="${stan.keys}" name="keys"></td>
		</tr>
		<tr>
			<td>* 发布日期yyyy-MM-dd</td>
			<td><input type="text" value="${stan.release_date}" name="release_date"></td>
		</tr>
		<tr>
			<td>* 施行日期</td>
			<td><input type="text" value="${stan.impl_date}" name="impl_date"></td>
		</tr>
		<tr>
			<td>附件</td>
			<td><input type="file" name="files">未选择文件</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="hidden" name="id" value="${stan.id}">
				<button>保存</button>
				<a href="list">取消</a>
			</td>
		</tr>
	</table>
	</form>	
</body>
</html>