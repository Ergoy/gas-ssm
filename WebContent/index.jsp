<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <title>燃气公司物资管理系统 - 首页</title>
  <%@include file="common/head.jsp" %>
</head>
<body>
<%@include file="common/top.jsp" %>
<div class="am-cf admin-main">
  <%@include file="common/sidebar.jsp" %>
  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>每日KPI</small></div>
    </div>

    <ul class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list ">
      <li><a href="#" class="am-text-success"><span class="am-icon-btn am-icon-file-text"></span><br/>新增客户<br/>${newUser.cnt}</a></li>
      <li><a href="#" class="am-text-warning"><span class="am-icon-btn am-icon-briefcase"></span><br/>成交订单<br/>${sellOrder.cnt}</a></li>
      <li><a href="#" class="am-text-danger"><span class="am-icon-btn am-icon-recycle"></span><br/>销售退货<br/>${custBack.cnt}</a></li>
      <li><a href="#" class="am-text-secondary"><span class="am-icon-btn am-icon-user-md"></span><br/>采购退货<br/>${pvdBack.cnt}</a></li>
    </ul>

    <div class="am-g">
      <div class="am-u-md-6">
        <div class="am-panel am-panel-default">
          <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-1'}">燃气类别销量排行<span class="am-icon-chevron-down am-fr" ></span></div>
          <div class="am-panel-bd am-collapse am-in" id="collapse-panel-1">
          	<div id="main1" class="am-list" style="width: 500px;height:400px;"></div>
          </div>
        </div>
      </div>

      <div class="am-u-md-6">
        <div class="am-panel am-panel-default">
          <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-2'}">燃气库存量排行 <span class="am-icon-chevron-down am-fr" ></span></div>
          <div class="am-panel-bd am-collapse am-in" id="collapse-panel-2">
          	<div id="main2" class="am-list" style="width: 500px;height:400px;"></div>
          </div>
        </div>

      </div>
    </div>
  </div>
  <!-- content end -->

</div>

<footer>
  <hr>
  <p class="am-padding-left">© 2021 star, Inc.</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.js"></script>
<!--<![endif]-->
<script src="assets/js/app.js"></script>
<script type="text/javascript" src="js/echarts.js"></script>
<script type="text/javascript">
$(function(){
	//基于准备好的dom，初始化echarts实例1
	var myChart1 = echarts.init(document.getElementById('main1'));
	option1 = {
	    title: {
	        text: '燃气近一周销量变化',
	        subtext: '纯属虚构'
	    },
	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	    	x : 'center',
	        y : 'bottom',
	        data:['天然气','人工燃气','液化石油燃气','沼气','燃气设备']
	    },
	    toolbox: {
	        show: true,
	        feature: {
	            dataZoom: {
	                yAxisIndex: 'none'
	            },
	            dataView: {readOnly: false},
	            magicType: {type: ['line', 'bar']},
	            restore: {},
	            saveAsImage: {}
	        }
	    },
	    xAxis:  {
	        type: 'category',
	        boundaryGap: false,
	        data: ['周一','周二','周三','周四','周五','周六','周日']
	    },
	    yAxis: {
	        type: 'value',
	        axisLabel: {
	            formatter: '{value} 元'
	        }
	    },
	    series : [
              {
                  name:'天然气',
                  type:'line',
                  stack: '总量',
                  areaStyle: {normal: {}},
                  data:[120, 132, 101, 134, 90, 230, 210]
              },
              {
                  name:'人工燃气',
                  type:'line',
                  stack: '总量',
                  areaStyle: {normal: {}},
                  data:[220, 182, 191, 234, 290, 330, 310]
              },
              {
                  name:'液化石油燃气',
                  type:'line',
                  stack: '总量',
                  areaStyle: {normal: {}},
                  data:[150, 232, 201, 154, 190, 330, 410]
              },
              {
                  name:'沼气',
                  type:'line',
                  stack: '总量',
                  areaStyle: {normal: {}},
                  data:[320, 332, 301, 334, 390, 330, 320]
              },
              {
                  name:'燃气设备',
                  type:'line',
                  stack: '总量',
                  label: {
                      normal: {
                          show: true,
                          position: 'top'
                      }
                  },
                  areaStyle: {normal: {}},
                  data:[820, 932, 901, 934, 1290, 1330, 1320]
              }
          ]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart1.setOption(option1);
	

	//基于准备好的dom，初始化echarts实例1
	var myChart2 = echarts.init(document.getElementById('main2'));
	option2 = {
		    title: {
		        text: '燃气种类浏览量与库存对比',
		        subtext: '纯属虚构'
		    },
		    toolbox: {
		        show: true,
		        feature: {
		            dataZoom: {
		                yAxisIndex: 'none'
		            },
		            dataView: {readOnly: false},
		            magicType: {type: ['line', 'bar']},
		            restore: {},
		            saveAsImage: {}
		        }
		    },
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    legend: {
		    	x : 'center',
		        y : 'bottom',
		        data:['天然气','人工燃气','液化石油燃气','沼气','燃气设备']
		    },
		    series: [
		        {
		            name:'浏览量',
		            type:'pie',
		            selectedMode: 'single',
		            radius: ['10%', '30%'],

		            label: {
		                normal: {
		                    position: 'inner'
		                }
		            },
		            labelLine: {
		                normal: {
		                    show: false
		                }
		            },
		            data:[
		                {value:335, name:'天然气', selected:true},
		                {value:679, name:'人工燃气'},
		                {value:1548, name:'液化石油燃气'}
		            ]
		        },
		        {
		            name:'库存量',
		            type:'pie',
		            radius: ['40%', '55%'],

		            data:[
		                {value:335, name:'天然气'},
		                {value:310, name:'人工燃气'},
		                {value:234, name:'液化石油燃气'},
		                {value:135, name:'沼气'},
		                {value:1048, name:'燃气设备'}
		            ]
		        }
		    ]
		};
	// 使用刚指定的配置项和数据显示图表。
	myChart2.setOption(option2);
})
</script>
</body>
</html>
