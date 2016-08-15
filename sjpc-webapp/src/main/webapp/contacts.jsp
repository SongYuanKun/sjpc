<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - 联系人</title>
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
	<div class="wrapper wrapper-content animated fadeInRight">
		<div id="row" class="row">
			<div class="col-sm-4 card hide animated pulse">
				<div class="contact-box">
					<a href="javascript:;">
						<div class="col-sm-4">
							<div class="text-center">
								<img alt="image" class="img-circle m-t-xs img-responsive" src="">
							</div>
						</div>
						<div class="col-sm-8">
							<h3>
								<strong></strong><input type="hidden" value="" />
							</h3>
							<p>
								<i class="fa fa-map-marker"></i>
								<tt name="location"></tt>
							</p>
							<address>
								<strong>创建时间：</strong><br>
								<tt name="createdAt"></tt>
								<br> <strong>粉丝数：</strong>
								<tt name="followersCount"></tt>
								<br>
								<strong>关注数：</strong>
								<tt name="friendsCount"></tt>
							</address>
						</div>
						<div class="clearfix"></div>
					</a>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/content.min.js?v=1.0.0"></script>
	<script type="text/javascript" src="myjs/contacts.js"></script>
</body>


</html>
