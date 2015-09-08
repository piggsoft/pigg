<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/default.css"></spring:url>'/>
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/js/themes/default/easyui.css"></spring:url>' />
<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/js/themes/icon.css"></spring:url>' />
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.min.js"></spring:url>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/jquery.easyui.min.js"></spring:url>'></script>
<script type="text/javascript" src='<spring:url value="/resources/js/locale/easyui-lang-zh_CN.js"></spring:url>'></script>
</head>
<body>
	<table id="tt"></table>
</body>
<script type="text/javascript">
$('#tt').datagrid({
    url:'<spring:url value="/menu/search"></spring:url>',
    border : "true", //有边框
	singleSelect : "true",//单选模式
	checkOnSelect : "false",
	pagination : "true", //是否显示翻页导航
	rownumbers : "true",//是否显示行号
	striped : "true", //-奇偶行颜色交错
	nowrap : "true",//单元格数据不换行
	idField : "menuid",//主键字段 
	pageSize : 20, //每页记录数 
	frozenColumns : [ [ {
		field : 'menuid',
		checkbox : true,
		width:'10%'
	} ] ],
    columns:[[
        {field:'menuname',title:'菜单名',width:'30%'},
        {field:'icon',title:'图片',width:'30%'},
        {field:'url',title:'地址',width:'30%'}
    ]],
    toolbar : [ 
       {
			id : 'btnadd',
			text : '确认收款完成且通知商户',
			iconCls : 'icon-ok',
			handler : function() {
				console.log(arguments)
				var ids = [];
				var rows = $('#tt').datagrid('getSelections');
				console.log(rows)
			}
    	} 
    ]
});
</script>
</html>