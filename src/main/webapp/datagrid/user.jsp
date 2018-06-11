<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
    var toolbar = [  {
        iconCls: 'icon-save',
        text: "自定义导出",
        handler: function () {
            $("#custom_dialog").dialog("open")
        }},{
        iconCls: 'icon-save',
        text: "自定义导入",
        handler: function () {
            $("#import_dialog").dialog("open")
        }}]

    $(function () {
        $("#user_dg").edatagrid({
            singleSelect: false,
            url: "${pageContext.request.contextPath}/user/query.do",
          //  updateUrl: "${pageContext.request.contextPath}/rc/update.do",

            columns: [[
                {field: 'username', title: '名字', width: 100},
                {field: 'phoneNum', title: '电话', width: 100},
                {field: 'dharmaName', title: '法号', width: 100},
                {field: 'location', title: '地区', width: 100},
                {field: 'sex', title: '性别', width: 100},
                {field: 'sign', title: '签名', width: 100},
                {
                    field: 'status', title: '状态', width: 100,
                    editor: {
                        type: 'text',
                        options: {required: true}
                    }
                },
                {field: 'regDate', title: '时间', width: 100, align: 'right'}
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageList: [5, 10, 15, 20],
            pageSize: 5,
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    ' <td rowspan=2 style="border:0"><img src="' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.des + '</p>' +
                    '<p>状态: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        })
    })

    $("#customer_cc").combotree({
        url:'${pageContext.request.contextPath}/user/filed.do',
        required:true,
        checkbox:true,
        onlyLeafCheck:true,
        multiple:true

    });
    $("#btn1").click(function () {
//   提交form表单
        var titles = $("#customer_cc").combotree("getText");
        var value = $("#customer_cc").combotree("getValues");
        var c = "";
        $.each(value, function (index, title) {
            if (index != value.length - 1) {
                c += title + ",";
            } else {
                c += title;
            }
        })
        $('#customer_form').form('submit', {
            queryParams: {"titles": titles, "fileds": c},
            url:"${pageContext.request.contextPath}/poi/customerExport.do"
        });
        $('#custom_dialog').dialog('close');
    })

    $("#btn2").click(function () {
//   提交form表单
        $('#import_form').form('submit', {
            url:"${pageContext.request.contextPath}/poi/importFile.do"
        });
        $('#import_dialog').dialog('close');
    })



</script>
<table id="user_dg"></table>

<div id="custom_dialog" class="easyui-dialog" title="自定义导出" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="customer_form" method="post">
        <select id="customer_cc" class="easyui-combotree" style="width:200px;"
                <%--data-options="url:'${pageContext.request.contextPath}/user/query.do',required:true,checkbox:true,onlyLeafCheck:true,multiple:true"--%>
        ></select>
    </form>


    <a id="btn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">确定导出</a>

</div>

<div id="import_dialog" class="easyui-dialog" title="自定义导入" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="import_form" method="post" enctype="multipart/form-data" >
        <input type="file" name="importFile" value="请选择导入的xls文件">
    </form>


    <a id="btn2" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">确定导入</a>

</div>

