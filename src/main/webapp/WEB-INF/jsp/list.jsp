<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.bigbox {
	width:810px;
}

.bigbox table tr td {
	border: 1px solid black;
}

.bigbox a {
	text-decoration: none;
}

.pageing{
	float:right;
}
</style>
</head>
<body>
	<div class="bigbox">
		<form action="list">
			<h3>标准信息列表</h3>
			<input type="text" name="title" value="${title}">
			<button>提交检索</button>
			<button><a href="addsys">新增检索</a></button>
		</form>
		<form action="delete">
			<button>删除标准</button>
			<br/>

			<table>
				<tr>
					<td>选中</td>
					<td>标准号</td>
					<td>中文名称</td>
					<td>版本</td>
					<td>发布日期</td>
					<td>实施日期</td>
					<td>操作</td>
				</tr>
				<c:forEach var="s" items="${stabdard}">
					<tr>
						<td><input type="checkbox" name="vehicle" value="${s.id}" /></td>
						<td>${s.std_num}</td>
						<td>${s.zhname}</td>
						<td>${s.version}</td>
						<td>${s.getRelease_dates()}</td>
						<td>${s.getImpl_dates()}</td>
						<td><a>下载</a><a href="addsys?id=${s.id}">&nbsp;修改</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<div class="pageing">
			<c:if test="${numb>1&&pageNumb>1}">
				<button>
					<a href="list?pageNumb=1&title=${title}">首页</a>
				</button>
			</c:if>
			<c:if test="${numb>1&&pageNumb>1}">
				<button>
					<a href="list?pageNumb=${pageNumb-1}&title=${title}">上一页</a>
				</button>
			</c:if>
			<c:if test="${numb>1&&pageNumb<numb}">
				<button>
					<a href="list?pageNumb=${pageNumb+1}&title=${title}">下一页</a>
				</button>
			</c:if>

			<c:if test="${numb>1&&pageNumb<numb}">
				<button>
					<a href="list?pageNumb=${numb}&title=${title}">末页</a>
				</button>
			</c:if>
			<label>共&nbsp;${numb}&nbsp;页，当前为&nbsp;${pageNumb}&nbsp;页</label> <label>${erry}</label>
		</div>
	</div>
</body>
</html>