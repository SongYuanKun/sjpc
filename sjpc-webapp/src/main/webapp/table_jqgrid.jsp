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


<title>数据爬虫搜索结果 - jqGird</title>

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

<!-- jqgrid-->
<link href="css/plugins/jqgrid/ui.jqgridffe4.css?0820" rel="stylesheet">

<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

<style>
/* Additional style to fix warning dialog position */
#alertmod_table_list_2 {
	top: 900px !important;
}
</style>

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox ">
					<div class="ibox-title">
						<h5>jQuery Grid Plugin – jqGrid</h5>
					</div>
					<div class="ibox-content">
						<p>
							<strong>jqGrid</strong> 是一个用来显示网格数据的jQuery插件，文档比较全面，附带中文版本。访问<a
								target="_blank" href="http://www.trirand.com/blog/"> 官网</a>
						</p>
						<p>jqGrid的主要特点为：</p>
						<ol>
							<li>可以下载所有查询出来的数据</li>
							<li>支持模糊搜索</li>
							<li>下载格式为Excel</li>
						</ol>
						<hr>
						<div class="input-group">
							<input type="text" id="text" placeholder="查找客户"
								class="input form-control"> <span
								class="input-group-btn">
								<button type="button" class="btn btn btn-primary">
									<i class="fa fa-search"></i> 搜索
								</button>
							</span>
						</div>
						<div class="input-daterange input-group" id="datepicker">
							<input type="text" class="input-sm form-control" id="name"
								name="start" value="2014-11-11" /> <span
								class="input-group-addon">到</span> <input type="text"
								class="input-sm form-control" id="end" name="end"
								value="2014-11-17" />
						</div>
						<hr>
						<p>&nbsp;</p>
						<h4 class="m-t">高级用法</h4>
						<div class="jqGrid_wrapper">
							<table id="table_list_2"></table>
							<div id="pager_list_2"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/peity/jquery.peity.min.js"></script>
	<script src="js/plugins/jqgrid/i18n/grid.locale-cnffe4.js"></script>
	<script src="js/plugins/jqgrid/jquery.jqGrid.minffe4.js"></script>
	<script src="js/content.min.js?v=1.0.0"></script>
	<script>
			$(document).ready(
				function() {
					$.jgrid.defaults.styleUI = "Bootstrap";
					var mydata = [];
					$("#table_list_2").jqGrid(
							{
								url : '${pageContext.request.contextPath}/aaa',
						        datatype : "json",
						        mtype : "post",
								height : 450,
								'postData':{'aa':$("[name='']").val()},
								autowidth : true,
								shrinkToFit : true,
								rowNum : 20,
								rowList : [ 10, 20, 30 ],
								colNames : [ "微博MID", "作者", "创建时间", "微博内容",
										"地理信息", "转发的博文", "来自" ],
								colModel : [ {
									name : "id",
									index : "id",
									width : 60
								}, {
									name : "invdate",
									index : "invdate",
									width : 90,
									formatter : "date"
								}, {
									name : "name",
									index : "name",
									width : 100
								}, {
									name : "amount",
									index : "amount",
									width : 80,
									formatter : "number"
								}, {
									name : "tax",
									index : "tax",
									width : 80,
								}, {
									name : "total",
									index : "total",
									width : 80,
								}, {
									name : "note",
									index : "note",
									width : 100,
								} ],
								pager : "#pager_list_2",
								viewrecords : true,
								caption : "jqGrid 示例2",
								hidegrid : false
							});
					$("#table_list_2").setSelection(4, true);
					$("#table_list_2").jqGrid("navGrid", "#pager_list_2", {
						del : false,
						search : false,
						add:false,
						edit:false,
						refresh:false
					}, {
						height : 200,
						reloadAfterSubmit : true
					});
					console.info(a[0])
					$(window).bind("resize", function() {
						var width = $(".jqGrid_wrapper").width();
						$("#table_list_2").setGridWidth(width)
					})
					jQuery("#table_list_2").setGridParam({'aa':'bb'}).trigger("reloadGrid"); 
				});
	</script>
</body>

</html>
