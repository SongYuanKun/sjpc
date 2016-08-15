<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - 个人资料</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="row animated fadeInRight">
			<div class="col-sm-4">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>个人资料</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div>
						<div class="ibox-content no-padding border-left-right">
							<img alt="image" class="img-responsive"
								src="${user.avatarLarge }">
						</div>
						<div class="ibox-content profile-content">
							<h4>
								<strong>${user.screenName }</strong><input type="hidden"
									id="userid" value="${user.id }" />
							</h4>
							<p>
								<i class="fa fa-map-marker"></i> ${user.location }
							</p>
							<h5>个人描述</h5>
							<p>${user.description }</p>
							<div class="row m-t-lg">
								<div class="col-sm-4">
									<h5>
										<strong>${user.statusesCount }</strong>微博
									</h5>
								</div>
								<div class="col-sm-4">
									<h5>
										<strong>${user.friendsCount }</strong> 关注
									</h5>
								</div>
								<div class="col-sm-4">
									<h5>
										<strong>${user.followersCount }</strong> 关注者
									</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>最新动态</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="graph_flot.html#"> <i class="fa fa-wrench"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="graph_flot.html#">下载该用户所有微博SQL</a></li>
								<li><a href="graph_flot.html#">下载该用户所有微博Excel</a></li>
							</ul>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">

						<div>
							<div class="feed-element hide">
								<div class="media-body ">
									<small class="pull-right day"></small> <strong>${user.screenName }</strong>
									<br> <small class="text-muted time"></small>
									<div class="well text"></div>
								</div>
								<div class="photos">
									<a target="_blank"
										href="">
										<img alt="image" class="feed-photo" src="">
									</a>
								</div>
							</div>
						</div>
					</div>

					<button class="btn btn-primary btn-block m">
						<i class="fa fa-arrow-down"></i> 显示更多
					</button>

				</div>

			</div>
		</div>

	</div>
	</div>
	</div>
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/content.min.js?v=1.0.0"></script>
	<script src="myjs/profile.js"></script>
</body>
</html>
