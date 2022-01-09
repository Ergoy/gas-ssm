<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js">
<head>
<title>燃气公司物资管理系统 - 入库管理</title>
<%@include file="common/head.jsp"%>
</head>
<body>
	<%@include file="common/top.jsp"%>
	<div class="am-cf admin-main">
		<%@include file="common/sidebar.jsp"%>

		<!-- content start -->
		<div class="admin-content">
			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">入库管理</strong> / <small>入库管理</small>
				</div>
			</div>

			<form class="am-form" method="post" action="ProviderModify">
				<input type="hidden" name="act" value="${empty requestScope.provider ? 'add' : 'mdy'}">
				<input type="hidden" name="s" value="${requestScope.stock.sid}">
				<div class="am-tabs am-margin" data-am-tabs>
					<ul class="am-tabs-nav am-nav am-nav-tabs">
						<li class="am-active"><a href="#tab1">${empty requestScope.provider ? '新增' : '修改' }入库信息</a></li>
					</ul>
					<div class="am-tabs-bd">
						<div class="am-tab-panel am-fade am-in am-active" id="tab1">
						<div class="am-g am-margin-top-sm">
							<div class="am-u-sm-2 am-text-right">供应商名称</div>
							<div class="am-u-sm-4 am-u-end">
								<select name="cid">
									<c:forEach items="${requestScope.providers}" var="p">
									<option ${provider.custom.cid==p.cid ? ' selected="selected"' : ''} value="${p.cid}">${p.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="am-g am-margin-top-sm">
							<div class="am-u-sm-2 am-text-right">采购单号</div>
							<div class="am-u-sm-4 am-u-end">
								<select name="sid">
									<c:forEach items="${requestScope.providerss}" var="s">
									<option ${provider.stock.sid==s.sid ? ' selected="selected"' : ''} value="${s.sid}">${s.sid}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="am-g am-margin-top-sm">
							<div class="am-u-sm-2 am-text-right">订单编号</div>
							<div class="am-u-sm-4 am-u-end">
								<input type="text" name="pbid" class="am-input-sm" value="${provider.pbid }">
							</div>
						</div>
						<div class="am-g am-margin-top-sm">
							<div class="am-u-sm-2 am-text-right">入库时间</div>
							<div class="am-u-sm-4 am-u-end">
								<input type="date"  name="date" class="am-input-sm" value="${provider.date }">
							</div>
						</div>
						<div class="am-g am-margin-top-sm">
							<div class="am-u-sm-2 am-text-right">商品总数量</div>
							<div class="am-u-sm-4 am-u-end">
								<input type="number" name="totalprice" class="am-input-sm" value="${provider.totalprice }">
							</div>
						</div>
						
						</div>
					</div>
				</div>

				<div class="am-margin">
					<input type="submit" class="am-btn am-btn-primary am-btn-xs" value="保存" /> <input type="reset" class="am-btn am-btn-primary am-btn-xs" value="重置">
				</div>
			</form>

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
</body>
</html>
