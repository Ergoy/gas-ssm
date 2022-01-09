<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html class="no-js">
<head>
<title>燃气公司物资管理系统 - ${requestScope.type eq '1' ? '库位管理' : '供应商' }</title>
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
					<strong class="am-text-primary am-text-lg">基本信息</strong> / <small>${requestScope.type eq '1' ? '库位管理' : '供应商' }</small>
				</div>
			</div>

			<form class="am-form" method="post" action="CustModify">
				<input type="hidden" name="act" value="${empty ct ? 'add' : 'mdy'}">
				<input type="hidden" name="c" value="${requestScope.ct.cid}">
				<input type="hidden" name="type" value="${requestScope.type}">
				<div class="am-tabs am-margin" data-am-tabs>
					<ul class="am-tabs-nav am-nav am-nav-tabs">
						<li class="am-active"><a href="#tab1">${empty ct ? '新增' : '修改' }${requestScope.type eq '1' ? '库位' : '供应商' }信息</a></li>
					</ul>
					<div class="am-tabs-bd">
						<div class="am-tab-panel am-fade am-in am-active" id="tab1">
						<div class="am-g am-margin-top-sm">
							<div class="am-u-sm-2 am-text-right">编号</div>
							<div class="am-u-sm-4 am-u-end">
								<input type="text" name="cid" class="am-input-sm" value="${requestScope.ct.cid }" >
							</div>
						</div>
						<div class="am-g am-margin-top-sm">
							<div class="am-u-sm-2 am-text-right">库位名称</div>
							<div class="am-u-sm-4 am-u-end">
								<input type="text" name="name" class="am-input-sm" value="${requestScope.ct.name }" >
							</div>
						</div>
						<div class="am-g am-margin-top-sm">
							<div class="am-u-sm-2 am-text-right">所属仓库</div>
							<div class="am-u-sm-4 am-u-end">
								<input type="text" name="linkman" class="am-input-sm" value="${requestScope.ct.linkman }">
							</div>
						</div>
						<div class="am-g am-margin-top-sm">
							<div class="am-u-sm-2 am-text-right">所属库</div>
							<div class="am-u-sm-4 am-u-end">
								<input type="text" name="addr" class="am-input-sm" value="${requestScope.ct.addr }">
							</div>
						</div>
						<div class="am-g am-margin-top-sm">
							<div class="am-u-sm-2 am-text-right">所属架</div>
							<div class="am-u-sm-4 am-u-end">
								<input type="text" name="tel" class="am-input-sm" value="${requestScope.ct.tel }">
							</div>
						</div>
						<div class="am-g am-margin-top-sm">
							<div class="am-u-sm-2 am-text-right">所属层</div>
							<div class="am-u-sm-4 am-u-end">
								<input type="text" name="email" class="am-input-sm" value="${requestScope.ct.email }">
							</div>
						</div>
						<div class="am-g am-margin-top-sm">
							<div class="am-u-sm-2 am-text-right">所属位</div>
							<div class="am-u-sm-4 am-u-end">
								<input type="text" name="remark" class="am-input-sm" value="${requestScope.ct.remark }">
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
