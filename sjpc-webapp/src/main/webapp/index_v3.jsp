<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>首页</title>

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

<!-- Morris -->
<link href="css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

<!-- Gritter -->
<link href="js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-3">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<span class="label label-success pull-right">总</span>
						<h5>微博总数</h5>
					</div>
					<div class="ibox-content">
						<h1 class="no-margins">${statusNum }</h1>
						<div class="stat-percent font-bold text-success">
							98% <i class="fa fa-level-up"></i>
						</div>
						<small>新增数据量</small>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<span class="label label-info pull-right">总</span>
						<h5>微博用户总数</h5>
					</div>
					<div class="ibox-content">
						<h1 class="no-margins">${userNum }</h1>
						<div class="stat-percent font-bold text-info">
							20% <i class="fa fa-level-up"></i>
						</div>
						<small>新增数据量</small>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<span class="label label-primary pull-right">今天</span>
						<h5>下载量</h5>
					</div>
					<div class="ibox-content">
						<h1 class="no-margins">0</h1>
						<div class="stat-percent font-bold text-navy">
							44% <i class="fa fa-level-up"></i>
						</div>
						<small>下载量</small>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<span class="label label-danger pull-right">总</span>
						<h5>活跃用户</h5>
					</div>
					<div class="ibox-content">
						<h1 class="no-margins">0</h1>
						<div class="stat-percent font-bold text-danger">
							38% <i class="fa fa-level-down"></i>
						</div>
						<small>12月</small>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-4">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>最新微博</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
						<div class="feed-activity-list">
							<c:forEach items="${newlyStatus}" var="ns">
								<div class="feed-element">
									<div>
										<small class="pull-right text-navy"></small> <strong><a
											href="profile.action?id=${ns.user.id}">${ns.user.screenName }</a>
										</strong>
										<div>${ns.text}</div>
										<small class="text-muted"><fmt:formatDate
												value="${ns.createdAt}" type="both" /></small>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>

			<div class="col-sm-8">

				<div class="row">
					<div class="col-sm-6">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>用户列表</h5>
								<div class="ibox-tools">
									<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
									</a> <a class="close-link"> <i class="fa fa-times"></i>
									</a>
								</div>
							</div>
							<div class="ibox-content">
								<table class="table table-hover no-margins">
									<thead>
										<tr>
											<th>用户</th>
											<th>互粉数</th>
											<th>查看</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${newlyUser}" var="user">
											<tr>
												<td><small>${user.name }</small></td>
												<td>${user.biFollowersCount }</td>
												<td class="text-navy"><i class="fa fa-search"></i><a
													href="profile.action?id=${user.id }">查看</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>数据增长折线图</h5>
								<div class="ibox-tools">
									<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
									</a> <a class="dropdown-toggle" data-toggle="dropdown"
										href="graph_flot.html#"> <i class="fa fa-wrench"></i>
									</a>
									<ul class="dropdown-menu dropdown-user">
										<li><a href="graph_flot.html#">选项1</a></li>
										<li><a href="graph_flot.html#">选项2</a></li>
									</ul>
									<a class="close-link"> <i class="fa fa-times"></i>
									</a>
								</div>
							</div>
							<div class="ibox-content">
								<div class="echarts" id="echarts-line-chart"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>中国地图</h5>
								<div class="ibox-tools">
									<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
									</a> <a class="dropdown-toggle" data-toggle="dropdown"
										href="graph_flot.html#"> <i class="fa fa-wrench"></i> .
									</a>
									<ul class="dropdown-menu dropdown-user">
										<li><a href="graph_flot.html#">选项1</a></li>
										<li><a href="graph_flot.html#">选项2</a></li>
									</ul>
									<a class="close-link"> <i class="fa fa-times"></i>
									</a>
								</div>
							</div>
							<div class="ibox-content">
								<div style="height: 600px" id="echarts-map-chart"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/content.min.js?v=1.0.0"></script>
	<script src="js/plugins/echarts/echarts-all.js"></script>
	<script type="text/javascript">
		var statusMapData = $
		{
			statusProvinceMap
		};
		var userMapData = $
		{
			userProvinceMap
		};
	</script>
	<script src="myjs/index.js"></script>
</body>

</html>
