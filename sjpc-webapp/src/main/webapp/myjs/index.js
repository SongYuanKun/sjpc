$(function() {
	var e = echarts.init(document.getElementById("echarts-line-chart")), a = {
		title : {
			text : ""
		},
		tooltip : {
			trigger : "axis"
		},
		legend : {
			data : [ "微博增长", "用户增长" ]
		},
		grid : {
			x : 40,
			x2 : 40,
			y2 : 24
		},
		calculable : !0,
		xAxis : [ {
			type : "category",
			boundaryGap : !1,
			data : [ "周一", "周二", "周三", "周四", "周五", "周六", "周日" ]
		} ],
		yAxis : [ {
			type : "value",
			axisLabel : {
				formatter : "{value}"
			}
		} ],
		series : [ {
			name : "微博增长",
			type : "line",
			data : [ 11, 11, 15, 6, 12, 13, 10 ],
			markPoint : {
				data : [ {
					type : "max",
					name : "最大值"
				}, {
					type : "min",
					name : "最小值"
				} ]
			},
			markLine : {
				data : [ {
					type : "average",
					name : "平均值"
				} ]
			}
		}, {
			name : "用户增长",
			type : "line",
			data : [ 1, -2, 2, 5, 3, 2, 0 ],
			markPoint : {
				data : [ {
					type : "max",
					name : "最大值"
				}, {
					type : "min",
					name : "最小值"
				} ]
			},
			markLine : {
				data : [ {
					type : "average",
					name : "平均值"
				} ]
			}
		} ]
	};
	e.setOption(a), $(window).resize(e.resize);
	mapinit(statusMapData, userMapData);
});

function map2array(MapData) {
	var oDataArray = new Array();
	for ( var key in MapData) {
		var o = new Object();
		o.name = key;
		o.value = MapData[key];
		oDataArray.push(o);
	}
	return oDataArray;
}

function mapinit(statusMapData, userMapData) {
	var s = echarts.init(document.getElementById("echarts-map-chart")), c = {
		title : {
			text : "用户与微博发布地区",
			subtext : "数据仅限本地数据",
			x : "center"
		},
		tooltip : {
			trigger : "item"
		},
		legend : {
			orient : "vertical",
			x : "left",
			data : [ "发布微博", "用户" ]
		},
		dataRange : {
			min : 0,
			max : 2500,
			x : "left",
			y : "bottom",
			text : [ "高", "低" ],
			calculable : !0
		},
		toolbox : {
			show : !0,
			orient : "vertical",
			x : "right",
			y : "center",
			feature : {
				mark : {
					show : !0
				},
				dataView : {
					show : !0,
					readOnly : !1
				},
				restore : {
					show : !0
				},
				saveAsImage : {
					show : !0
				}
			}
		},
		roamController : {
			show : !0,
			x : "right",
			mapTypeControl : {
				china : !0
			}
		},
		series : [ {
			name : "发布微博",
			type : "map",
			mapType : "china",
			roam : !1,
			itemStyle : {
				normal : {
					label : {
						show : !0
					}
				},
				emphasis : {
					label : {
						show : !0
					}
				}
			},
			data : map2array(statusMapData),
		}, {
			name : "用户",
			type : "map",
			mapType : "china",
			itemStyle : {
				normal : {
					label : {
						show : !0
					}
				},
				emphasis : {
					label : {
						show : !0
					}
				}
			},
			data : [ {
				name : "北京",
				value : Math.round(1e3 * Math.random())
			}, {
				name : "天津",
				value : Math.round(1e3 * Math.random())
			}, {
				name : "上海",
				value : Math.round(1e3 * Math.random())
			}, {
				name : "广东",
				value : Math.round(1e3 * Math.random())
			}, {
				name : "台湾",
				value : Math.round(1e3 * Math.random())
			}, {
				name : "香港",
				value : Math.round(1e3 * Math.random())
			}, {
				name : "澳门",
				value : Math.round(1e3 * Math.random())
			} ]
		} ]
	};
	s.setOption(c), $(window).resize(s.resize);

}
