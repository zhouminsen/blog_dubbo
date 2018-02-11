<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle }-Powered by java1234</title>

<link rel="stylesheet" href="${cxt}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${cxt}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${cxt}/static/css/blog.css">
<link href="http://blog.java1234.com/favicon.ico" rel="SHORTCUT ICON">
<script src="${cxt}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${cxt}/static/bootstrap3/js/bootstrap.min.js"></script>

<script>
	var _hmt = _hmt || [];
	(function() {
	  var hm = document.createElement("script");
	  hm.src = "//hm.baidu.com/hm.js?aa5c701f4f646931bf78b6f40b234ef5";
	  var s = document.getElementsByTagName("script")[0]; 
	  s.parentNode.insertBefore(hm, s);
	})();
</script>

<style type="text/css">
	  body {
        padding-top: 10px;
        padding-bottom: 40px;
      }
</style>
</head>
<body>
<div class="container">
	<jsp:include page="/foreground/common/head.jsp"/>
	
	<jsp:include page="/foreground/common/menu.jsp"/>
	
	<div class="row">
		<div class="col-md-9">
		<jsp:include page="${displayPage}"></jsp:include>
		</div>
		
		<div class="col-md-3">
			<div class="data_list">
				<div class="data_list_title">
					<img src="${cxt}/static/images/user_icon.png"/>
					博主信息
				</div>
				<div class="user_image">
					<img src="${blogger.allUrl}"/>
				</div>
				<div class="nickName">${blogger.nickName }</div>
				<div class="userSign">(${blogger.sign })</div>
				<a href="${cxt}/admin/login.jsp" target="_blank">进入后台</a>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${cxt}/static/images/byType_icon.png"/>
					按日志类别
				</div>
				<div class="datas">
					<ul>
						<c:forEach items="${typeList}" var="type">
						<li><span>
							<a href="${cxt}/index.shtml?typeId=${type.id }">${type.typeName }(${type.blogCount})</a>
						</span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${cxt}/static/images/byDate_icon.png"/>
					按日志日期
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="blogCount" items="${blogCountList }">
							<li><span><a href="${cxt}/index.shtml?releaseDate=${blogCount.releaseDate }">${blogCount.releaseDate }(${blogCount.blogCount })</a></span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="data_list">
				<div class="data_list_title">
					<img src="${cxt}/static/images/link_icon.png"/>
					友情链接
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="link" items="${linkList }">
							<li><span><a href="${link.linkUrl }" target="_blank">${link.linkName }</a></span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
		</div>
		
		
	</div>
	
	<jsp:include page="/foreground/common/foot.jsp"/>
</div>
</body>
</html>