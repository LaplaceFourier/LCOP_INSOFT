<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Cache-Control" content="No-Cache"/>
	<meta http-equiv="Pragma" content="No-Cache"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />

	<link rel="shortcut icon" type="image/x-icon" href="${rc.contextPath }/public/favicon.ico">
	<link rel="icon" type="image/x-icon" href="${rc.contextPath }/public/favicon.ico">

	<jsp:include page="/WEB-INF/views/include/ConstantsJS.jsp"/>

	<!-- jQuery -->
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/jquery-1.10.2.js"></script>

	<script type="text/javascript" src="${rc.contextPath }/js/jquery/jquery.string.format.js"></script>

	<!-- i18n -->
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/jquery.i18n.properties-1.0.9.js"></script>

	<!-- jQuery cookie -->
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/jquery.cookie.js"></script>

	<!-- jQuery UI -->
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/css/base/jquery-ui.css">
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/jquery-ui-1.10.3.custom.js"></script>
	<c:if test="${rc.locale.language ne 'en'}"><script type="text/javascript" src="${rc.contextPath }/js/jquery/datepicker/jquery.ui.datepicker-${rc.locale.language}.js"></script></c:if>

	<!-- jQuery comment -->
	<%-- <link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/jquery/comment/jquery.comment.css">
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/comment/jquery.comment.min.js"></script> --%>

	<!-- jqGrid -->
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/jqGrid/css/ui.jqgrid.css">
	<script type="text/javascript" src="${rc.contextPath }/js/jqGrid/js/jquery.jqGrid.src.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/jqGrid/js/i18n/grid.locale-${rc.locale.language}.js"></script>

	<!-- tinymce -->
	<script type="text/javascript" src="${rc.contextPath }/js/tinymce/tinymce.min.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/tinymce/jquery.tinymce.min.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/tinymce/langs/${rc.locale.language}.js"></script>

	<!-- time picker -->
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/jquery/timepicker/jquery-ui-timepicker-addon.css">
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/timepicker/jquery-ui-timepicker-addon.js"></script>
	<c:if test="${rc.locale.language ne 'en'}"><script type="text/javascript" src="${rc.contextPath }/js/jquery/timepicker/i18n/jquery-ui-timepicker-${rc.locale.language}.js"></script></c:if>

	<!-- slider -->
	<%-- <link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/jquery/slider/webdesign-podcast-slider.css" />
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/slider/webdesign-podcast-slider.js"></script> --%>

	<!-- dropdown -->
	<%-- <link rel="stylesheet" type="text/css" href="${rc.contextPath }/css/dropdown/css/dropdown/dropdown.vertical.rtl.css" media="screen">
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/css/dropdown/css/dropdown/themes/default/default.advanced.css" media="screen"> --%>

	<!-- sortable -->
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/css/sortable/style.css">

	<!-- dashboard menu -->
	<%-- <link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/jquery/dashboard-menu/style.css">
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/dashboard-menu/jquery.dashboard-menu.js"></script> --%>

	<!-- layout -->
	<%-- <link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/jquery/layout/style.css">
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/layout/jquery.layout.js"></script> --%>

	<!-- combo box -->
	<%-- <link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/jquery/dropdown/style.css">
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/dropdown/jquery.easydropdown.js"></script> --%>

	<!-- history -->
	<!--[if IE]><script type="text/javascript" src="${rc.contextPath }/js/common/json3.js"></script><![endif]-->
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/history/jquery.history.js"></script>

	<!-- form -->
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/jquery.form.js"></script>
	<link rel="stylesheet" href="${rc.contextPath }/css/validate.css" type="text/css"/>
	<link rel="stylesheet" href="${rc.contextPath }/js/jquery/validate/validationEngine.jquery.css" type="text/css"/>
	<link rel="stylesheet" href="${rc.contextPath }/js/jquery/validate/template.css" type="text/css"/>
	<script type="text/javascript"  src="${rc.contextPath }/js/jquery/validate/jquery.validationEngine-kr.js"></script>
	<script type="text/javascript"  src="${rc.contextPath }/js/jquery/validate/jquery.validationEngine.js"></script> 
	<script src="${rc.contextPath }/js/jquery/jquery.validate.js" type="text/javascript"></script>

	<script type="text/javascript" src="${rc.contextPath }/js/common/PageHandler.js"></script>

	<!-- Site -->
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/css/common.css">
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/css/base.css">

	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/css/tree_layer.css">

	<script type="text/javascript" src="${rc.contextPath }/js/common/SystemUtils.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common/CommonUtils.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common/DateUtils.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common/GridUtils.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common/PopupUtils.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common/CodeUtils.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common/ComboUtils.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common/ValidateUtils.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common/FormUtils.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common/InstUtils.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common/ChartUtils.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common/RegexpUtils.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common.js"></script>

	<script type="text/javascript" src="${rc.contextPath }/js/common/FileUtils.js"></script>

	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/css/table-utils-skin1.css">
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/css/table-utils-skin2.css">
	<script type="text/javascript" src="${rc.contextPath }/js/common/TableUtils.js"></script>

	<script type="text/javascript" src="${rc.contextPath }/js/jquery/jquery.common.js"></script>

	<%-- <script type="text/javascript" src="${rc.contextPath }/js/common/Base.min.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/common/iplib.js"></script> --%>

	<!-- board -->
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/board/style.css">

	<!-- menu -->
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/menu/menu.css">
	<script type="text/javascript" src="${rc.contextPath }/js/menu/menu.js"></script>

	<!-- highcharts 3.0.5 - JavaScript -->
	<%-- <script type="text/javascript" src="${rc.contextPath }/js/highcharts-3.0.5/highcharts.src.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/highcharts-3.0.5/no-data-to-display.src.js"></script> --%>

	<!-- highcharts 4.1.5 - JavaScript -->
	<script type="text/javascript" src="${rc.contextPath }/js/highcharts-4.1.5/highcharts.src.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/highcharts-4.1.5/highcharts-more.src.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/highcharts-4.1.5/no-data-to-display.src.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/highcharts-4.1.5/modules/heatmap.src.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/highcharts-4.1.5/modules/treemap.src.js"></script>

	<!-- zTree -->
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/zTree/css/mesh/style.css">
	<%-- <link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/zTree/css/zTree/style.css"> --%>
	<%-- <link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/zTree/css/metro/style.css"> --%>
	<script type="text/javascript" src="${rc.contextPath }/js/zTree/jquery.ztree.all-3.5.js"></script>
	<script type="text/javascript" src="${rc.contextPath }/js/zTree/jquery.ztree.exhide-3.5.js"></script>

	<!-- autosize-master : TEXTAREA -->
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/autosize-master/jquery.autosize.min.js"></script>

	<!-- steps -->
	<%-- <link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/jquery/steps/jquery.steps.css">
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/steps/jquery.steps.min.js"></script> --%>

	<!-- scrollToTop -->
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/js/jquery/scrollToTop/style.css">
	<script type="text/javascript" src="${rc.contextPath }/js/jquery/scrollToTop/jquery.scrollToTop.min.js"></script>

	<!-- Flash -->
	<%-- <link rel="stylesheet" type="text/css" href="${rc.contextPath }/map/history/history.css" />
	<script type="text/javascript" src="${rc.contextPath }/map/history/history.js"></script> --%>
	<script type="text/javascript" src="${rc.contextPath }/map/swfobject.js"></script>

	<!-- 버튼 모음 css -->
	<link rel="stylesheet" type="text/css" href="${rc.contextPath }/css/button.css">

	<script type="text/javascript" src="${rc.contextPath }/js/jquery/ui.tabs.paging.js"></script>

	<script type="text/javascript">
		jQuery.ajaxSetup({cache:false});
		Highcharts.getOptions().credits.enabled = false;
	</script>
