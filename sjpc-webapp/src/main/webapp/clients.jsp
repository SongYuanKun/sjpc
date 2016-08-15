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


<title>H+ 后台主题UI框架 - 客户管理</title>

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content">
						<span class="text-muted small pull-right">最后更新：<i
							class="fa fa-clock-o"></i> 2015-09-01 12:00
						</span>
						<h2>客户管理</h2>
						<p>所有客户必须通过邮件验证</p>
						<div class="input-group">
							<input type="text" placeholder="查找客户" class="input form-control">
							<span class="input-group-btn">
								<button type="button" class="btn btn btn-primary">
									<i class="fa fa-search"></i> 搜索
								</button>
							</span>
						</div>
						<div class="input-daterange input-group" id="datepicker">
							<input type="text" class="input-sm form-control" name="start"
								value="2014-11-11" /> <span class="input-group-addon">到</span>
							<input type="text" class="input-sm form-control" name="end"
								value="2014-11-17" />
						</div>
						<div class="clients-list">
							<ul class="nav nav-tabs">
								<span class="pull-right small text-muted">1406 个客户</span>
								<li class="active"><a data-toggle="tab" href="#tab-1"><i
										class="fa fa-user"></i> 联系人</a></li>
								<li class=""><a data-toggle="tab" href="#tab-2"><i
										class="fa fa-briefcase"></i> 公司</a></li>
							</ul>
							<div class="tab-content">
								<div id="tab-1" class="tab-pane active">
									<div class="full-height-scroll">
										<div class="jqGrid_wrapper">
											<table id="table_list_1"></table>
											<div id="pager_list_1"></div>
										</div>
									</div>
								</div>
								<div id="tab-2" class="tab-pane">
									<div class="full-height-scroll">
										<div class="jqGrid_wrapper">
											<table id="table_list_2"></table>
											<div id="pager_list_2"></div>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="js/plugins/jqgrid/i18n/grid.locale-cnffe4.js"></script>
	<script src="js/plugins/jqgrid/jquery.jqGrid.minffe4.js"></script>
	<script src="js/content.min.js?v=1.0.0"></script>
	<script>
		$(function() {
			$(".full-height-scroll").slimScroll({
				height : "100%"
			})
		});
	</script>
	<script>
		$(document).ready(function() {
			$.jgrid.defaults.styleUI = "Bootstrap";

			var mydata = [ {
				id : "1",
				invdate : "2010-05-24",
				name : "test",
				note : "note",
				tax : "10.00",
				total : "2111.00"
			}, {
				id : "2",
				invdate : "2010-05-25",
				name : "test2",
				note : "note2",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "3",
				invdate : "2007-09-01",
				name : "test3",
				note : "note3",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "4",
				invdate : "2007-10-04",
				name : "test",
				note : "note",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "5",
				invdate : "2007-10-05",
				name : "test2",
				note : "note2",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "6",
				invdate : "2007-09-06",
				name : "test3",
				note : "note3",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "7",
				invdate : "2007-10-04",
				name : "test",
				note : "note",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "8",
				invdate : "2007-10-03",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "21.00",
				total : "320.00"
			}, {
				id : "9",
				invdate : "2007-09-01",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "11",
				invdate : "2007-10-01",
				name : "test",
				note : "note",
				amount : "200.00",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "12",
				invdate : "2007-10-02",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "13",
				invdate : "2007-09-01",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "14",
				invdate : "2007-10-04",
				name : "test",
				note : "note",
				amount : "200.00",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "15",
				invdate : "2007-10-05",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "16",
				invdate : "2007-09-06",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "17",
				invdate : "2007-10-04",
				name : "test",
				note : "note",
				amount : "200.00",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "18",
				invdate : "2007-10-03",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "19",
				invdate : "2007-09-01",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "21",
				invdate : "2007-10-01",
				name : "test",
				note : "note",
				amount : "200.00",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "22",
				invdate : "2007-10-02",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "23",
				invdate : "2007-09-01",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "24",
				invdate : "2007-10-04",
				name : "test",
				note : "note",
				amount : "200.00",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "25",
				invdate : "2007-10-05",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "26",
				invdate : "2007-09-06",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "27",
				invdate : "2007-10-04",
				name : "test",
				note : "note",
				amount : "200.00",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "28",
				invdate : "2007-10-03",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "29",
				invdate : "2007-09-01",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			} ];
			$("#table_list_1").jqGrid({
				data : mydata,
				datatype : "local",
				height : 250,
				autowidth : true,
				shrinkToFit : true,
				rowNum : 14,
				rowList : [ 10, 20, 30 ],
				colNames : [ "序号", "日期", "客户", "金额", "运费", "总额", "备注" ],
				colModel : [ {
					name : "id",
					index : "id",
					width : 60,
					sorttype : "int"
				}, {
					name : "invdate",
					index : "invdate",
					width : 90,
					sorttype : "date",
					formatter : "date"
				}, {
					name : "name",
					index : "name",
					width : 100
				}, {
					name : "amount",
					index : "amount",
					width : 80,
					align : "right",
					sorttype : "float",
					formatter : "number"
				}, {
					name : "tax",
					index : "tax",
					width : 80,
					align : "right",
					sorttype : "float"
				}, {
					name : "total",
					index : "total",
					width : 80,
					align : "right",
					sorttype : "float"
				}, {
					name : "note",
					index : "note",
					width : 150,
					sortable : false
				} ],
				pager : "#pager_list_1",
				viewrecords : true,
				caption : "jqGrid 示例1",
				hidegrid : false
			});
			$("#table_list_2").jqGrid({
				data : mydata,
				datatype : "local",
				height : 450,
				autowidth : true,
				shrinkToFit : true,
				rowNum : 20,
				rowList : [ 10, 20, 30 ],
				colNames : [ "序号", "日期", "客户", "金额", "运费", "总额", "备注" ],
				colModel : [ {
					name : "id",
					index : "id",
					editable : true,
					width : 60,
					sorttype : "int",
					search : true
				}, {
					name : "invdate",
					index : "invdate",
					editable : true,
					width : 90,
					sorttype : "date",
					formatter : "date"
				}, {
					name : "name",
					index : "name",
					editable : true,
					width : 100
				}, {
					name : "amount",
					index : "amount",
					editable : true,
					width : 80,
					align : "right",
					sorttype : "float",
					formatter : "number"
				}, {
					name : "tax",
					index : "tax",
					editable : true,
					width : 80,
					align : "right",
					sorttype : "float"
				}, {
					name : "total",
					index : "total",
					editable : true,
					width : 80,
					align : "right",
					sorttype : "float"
				}, {
					name : "note",
					index : "note",
					editable : true,
					width : 100,
					sortable : false
				} ],
				pager : "#pager_list_2",
				viewrecords : true,
				caption : "jqGrid 示例2",
				add : true,
				edit : true,
				addtext : "Add",
				edittext : "Edit",
				hidegrid : false
			});
			$("#table_list_2").setSelection(4, true);
			$("#table_list_2").jqGrid("navGrid", "#pager_list_2", {
				edit : true,
				add : true,
				del : true,
				search : true
			}, {
				height : 200,
				reloadAfterSubmit : true
			});
			$(window).bind("resize", function() {
				var width = $(".jqGrid_wrapper").width();
				$("#table_list_1").setGridWidth(width);
				$("#table_list_2").setGridWidth(width)
			})
		});
	</script>



	<!-- Mirrored from www.zi-han.net/theme/hplus/clients.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->
</html>
