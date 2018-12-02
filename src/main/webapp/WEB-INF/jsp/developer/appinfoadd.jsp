<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>新增APP基础信息 <i class="fa fa-user"></i><small>${sessionScope.userSession.devName}</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content">
	  <!-- <div class="item form-group">
               <label class="control-label col-md-3 col-sm-3 col-xs-12" ></label>
               <div class="col-md-6 col-sm-6 col-xs-12">
                 <form action="uploadlogo" class="dropzone" style="height:100px;">
                 </form>
            <div class="clearfix"></div>
         </div>
       </div> -->
           <div class="clearfix"></div>
        <form class="form-horizontal form-label-left" action="${pageContext.request.contextPath}/app/doAddAppInfo.action"
              method="post" enctype="multipart/form-data" onsubmit="return check()">
          <input type="hidden" name="devId" value="${sessionScope.userSession.id}">
          <input type="hidden" name="createdBy" value="${sessionScope.userSession.id}">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">软件名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="softwareName" class="form-control col-md-7 col-xs-12" 
               data-validate-length-range="20" data-validate-words="1" name="softwareName"  required="required"
               placeholder="请输入软件名称" type="text" value="${appInfo.softwareName}">
            </div>
              <label class="control-label col-md-2 col-sm-2 col-xs-12" for="name" style="text-align: left" id="softwareNameInfo"></label>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APK名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <%--  异步验证唯一 --%>
              <input id="APKName" class="form-control col-md-7 col-xs-12" 
              	data-validate-length-range="20" data-validate-words="1" name="APKName"   required="required"
              	placeholder="请输入APK名称" type="text" value="${appInfo.APKName}">
            </div>
           <label class="control-label col-md-2 col-sm-2 col-xs-12" for="name" style="text-align: left" id="APKNameInfo"></label>
          </div>

          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">支持ROM <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="supportROM" class="form-control col-md-7 col-xs-12" name="supportROM" 
              	data-validate-length-range="20" data-validate-words="1"   required="required"
              	placeholder="请输入支持的ROM" type="text" value="${appInfo.supportROM}">
            </div>
              <label class="control-label col-md-2 col-sm-2 col-xs-12" for="name" style="text-align: left" id="supportROMInfo"></label>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">界面语言 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="interfaceLanguage" class="form-control col-md-7 col-xs-12" 
              data-validate-length-range="20" data-validate-words="1" name="interfaceLanguage"   required="required"
              placeholder="请输入软件支持的界面语言" type="text" value="${appInfo.supportROM}">
            </div>
              <label class="control-label col-md-2 col-sm-2 col-xs-12" for="name" style="text-align: left" id="interfaceLanguageInfo"></label>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">软件大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <%-- 软件大小使用数字框 --%>
              <input type="number" id="softwareSize" name="softwareSize"   required="required" onkeyup="value=value.replace(/[^\d]/g,'')"
              data-validate-minmax="10,500"  placeholder="请输入软件大小，单位为Mb   软件大小只能输入数字" class="form-control col-md-7 col-xs-12" value="${appInfo.softwareSize}">
            </div>
            <label class="control-label col-md-2 col-sm-2 col-xs-12" for="name" style="text-align: left" id="softwareSizeInfo"></label>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">下载次数 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <%--  下载次数 使用数字框 --%>
              <input type="number" id="downloads" name="downloads"   required="required" onkeyup="value=value.replace(/[^\d]/g,'')"
              data-validate-minmax="10,500"  placeholder="请输入下载次数 下载次数只能输入数字" class="form-control col-md-7 col-xs-12" value="${appInfo.downloads}">
            </div>
            <label class="control-label col-md-2 col-sm-2 col-xs-12" for="name" style="text-align: left" id="downloadsInfo"></label>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="select">所属平台 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="flatformId" id="flatformId" class="form-control"   required="required">
                <c:if test="${flatformList != null}">
                  <option value="0">--请选择--</option>
                  <c:forEach var="flatform" items="${flatformList}">
                    <option
                            <c:if test="${flatform.valueId == flatformId }">selected="selected"</c:if>
                            value="${flatform.valueId}">${flatform.valueName}</option>
                  </c:forEach>
                </c:if>
              </select>
            </div>
            <label class="control-label col-md-2 col-sm-2 col-xs-12" for="name" style="text-align: left" id="flatformIdInfo"></label>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">一级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categoryLevel1" id="categoryLevel1" class="form-control"   required="required" >
                <c:if test="${categoryLevelOne != null}">
                  <option value="0">--请选择--</option>
                  <c:forEach var="category" items="${categoryLevelOne}">
                    <option
                            <c:if test="${category.id == categoryLevel1 }">selected="selected"</c:if>
                            value="${category.id}">${category.categoryName}</option>
                  </c:forEach>
                </c:if>
              </select>
            </div>
            <label class="control-label col-md-2 col-sm-2 col-xs-12" for="name" style="text-align: left" id="categoryLevel1Info"></label>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="select">二级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categoryLevel2" id="categoryLevel2" class="form-control"  required="required">
                  <c:if test="${categoryLevelTwo != null}">
                    <option value="0">--请选择--</option>
                    <c:forEach var="category" items="${categoryLevelTwo}">
                      <option
                              <c:if test="${category.id == categoryLevel2 }">selected="selected"</c:if>
                              value="${category.id}">${category.categoryName}</option>
                    </c:forEach>
                  </c:if>
              </select>
            </div>
            <label class="control-label col-md-2 col-sm-2 col-xs-12" for="name" style="text-align: left" id="categoryLevel2Info"></label>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">三级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categoryLevel3" id="categoryLevel3" class="form-control"  required="required">
                <c:if test="${categoryLevelThree != null}">
                  <option value="0">--请选择--</option>
                  <c:forEach var="category" items="${categoryLevelThree}">
                    <option
                            <c:if test="${category.id == categoryLevel3 }">selected="selected"</c:if>
                            value="${category.id}">${category.categoryName}</option>
                  </c:forEach>
                </c:if>
              </select>
            </div>
            <label class="control-label col-md-2 col-sm-2 col-xs-12" for="name" style="text-align: left" id="categoryLevel3Info"></label>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APP状态 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<input type="hidden" name="status" id="status" value="1">待审核
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">应用简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appInfo" name="appInfo"     required="required"
              placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12"></textarea>
            </div>
            <label class="control-label col-md-2 col-sm-2 col-xs-12" for="name" style="text-align: left" id="appInfoInfo"></label>
          </div>
           <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">LOGO图片 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            <input type="file" class="form-control col-md-7 col-xs-12" name="a_logoPicPath"  required="required" id="a_logoPicPath"/>
            	显示上传文件错误信息
            </div>
             <label class="control-label col-md-2 col-sm-2 col-xs-12" for="name" style="text-align: left" id="a_logoPicPathInfo"></label>
          </div>
          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button id="send" type="submit" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back">返回</button>
              <br/><br/>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/appinfoadd.js"></script>
<script src="${pageContext.request.contextPath }/statics/localjs/appinfolist.js"></script>
<script type="text/javascript">
    // TODO 检查数据,提交表单
    function check(){
        var flatformIdValue = $("#flatformId").val();
        var categoryLevel1Value = $("#categoryLevell").val();
        var categoryLevel2Value = $("#categoryLevel2").val();
        var categoryLevel3Value = $("#categoryLevel3").val();

        if(flatformIdValue == 0){
            var  html1 = "";
            html1 += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
            html1 += "<span style=\"color: red\">   请选择所属平台</span>";
            $("#flatformIdInfo").empty();
            $("#flatformIdInfo").append(html1);
            return false;
        }
        if(categoryLevel1Value == 0){
            var  html2 = "";
            html2 += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
            html2 += "<span style=\"color: red\">   请选择一级分类</span>";
            $("#categoryLevel1Info").empty();
            $("#categoryLevel1Info").append(html2);
            return false;
        }
        if(categoryLevel2Value == 0){
            var  html3 = "";
            html3 += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
            html3 += "<span style=\"color: red\">   请选择二级分类</span>";
            $("#categoryLevel2Info").empty();
            $("#categoryLevel2Info").append(html3);
            return false;
        }
        if(categoryLevel3Value == 0){
            var  html4 = "";
            html4 += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
            html4 += "<span style=\"color: red\">   请选择三级分类</span>";
            $("#categoryLevel3Info").empty();
            $("#categoryLevel3Info").append(html4);
            return false;
        }
        return true;
    }
    $(function () {

        // 表单验证 softwareName supportROM interfaceLanguage softwareSize downloads
        //  categoryLevel1 categoryLevel2 categoryLevel3 a_logoPicPath appInfoInfo
        $("#a_logoPicPath").blur(function () {
            var a_logoPicPathValue = $(this).val();
            $("#a_logoPicPathInfo").empty();
            var html = "";
            if(a_logoPicPathValue == null || a_logoPicPathValue == ""){
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                html += "<span style=\"color: red\">   请选择需要上传的LOGO</span>";
            }else{
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/yes.png\">";
            }
            $("#a_logoPicPathInfo").append(html);
        });

        $("#appInfo").blur(function () {
            var appInfoInfoValue = $(this).val();
            $("#appInfoInfo").empty();
            var html = "";
            if(appInfoInfoValue == null || appInfoInfoValue == ""){
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                html += "<span style=\"color: red\">   请输入软件简介</span>";
            }else{
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/yes.png\">";
            }
            $("#appInfoInfo").append(html);
        });

        $("#flatformId").blur(function () {
            var html = "";
            var flatformIdValue = $(this).val();
            $("#flatformIdInfo").empty();
            if(flatformIdValue == 0){
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                html += "<span style=\"color: red\">   请选择所属平台</span>";
            }else {
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/yes.png\">";
            }
            $("#flatformIdInfo").append(html);
        });

        $("#categoryLevel1").blur(function () {
            var html = "";
            var categoryLevelValue = $(this).val();
            $("#categoryLevel1Info").empty();
            if(categoryLevelValue == 0){
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                html += "<span style=\"color: red\">   请选择一级分类</span>";
            }else {
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/yes.png\">";
            }
            $("#categoryLevel1Info").append(html);
        });

        $("#categoryLevel2").blur(function () {
            var html = "";
            var categoryLeve2Value = $(this).val();
            $("#categoryLevel2Info").empty();
            if(categoryLeve2Value == 0){
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                html += "<span style=\"color: red\">   请选择二级分类</span>";
            }else {
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/yes.png\">";
            }
            $("#categoryLevel2Info").append(html);
        });


        $("#categoryLevel3").blur(function () {
            var html = "";
            var categoryLeve3Value = $(this).val();
            $("#categoryLevel3Info").empty();
            if(categoryLeve3Value == 0){
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                html += "<span style=\"color: red\">   请选择三级分类</span>";
            }else {
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/yes.png\">";
            }
            $("#categoryLevel3Info").append(html);
        });



        $("#downloads").blur(function () {
            var downloadsValue = $(this).val();
            var pattern = /^[0-9]+(.[0-9]{0,3})?$/;
            $("#downloadsInfo").empty();
            var html = "";
            if(downloadsValue == null || downloadsValue == ""){
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                html += "<span style=\"color: red\">   请输入下载次数</span>";
            }else {
                    html += "<img src=\"${pageContext.request.contextPath}/statics/images/yes.png\">";
            }
            $("#downloadsInfo").append(html);
        });
        $("#softwareSize").blur(function () {
            var softwareSizeValue = $(this).val();
            var pattern = /^[0-9]+(.[0-9]{0,3})?$/;
            $("#softwareSizeInfo").empty();
            var html = "";
            if(softwareSizeValue == null || softwareSizeValue == ""){
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                html += "<span style=\"color: red\">   请输入软件大小</span>";
            }else {
                    html += "<img src=\"${pageContext.request.contextPath}/statics/images/yes.png\">";
            }
            $("#softwareSizeInfo").append(html);
        });


        $("#softwareName").blur(function () {
            var softwareName = $(this).val();
            $("#softwareNameInfo").empty();
            var html = "";
            if(softwareName == null || softwareName == ""){
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                html += "<span style=\"color: red\">   请输入软件名称</span>";
            }else{
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/yes.png\">";
            }
            $("#softwareNameInfo").append(html);
        });

        $("#supportROM").blur(function () {
            var supportROMValue = $(this).val();
            var html = "";
            $("#supportROMInfo").empty();
            if(supportROMValue == null || supportROMValue == ""){
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                html += "<span style=\"color: red\">   请输入ROM支持</span>";
            }else{
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/yes.png\">";
            }
            $("#supportROMInfo").append(html);
        });

        $("#interfaceLanguage").blur(function () {
            var interfaceLanguageValue = $(this).val();
            var html = "";
            $("#interfaceLanguageInfo").empty();
            if(interfaceLanguageValue == null || interfaceLanguageValue == ""){
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                html += "<span style=\"color: red\">   请输入界面语言</span>";
            }else{
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/yes.png\">";
            }
            $("#interfaceLanguageInfo").append(html);
        });



        $("#APKName").blur(function () {
            var APKName = $(this).val();
            $("#APKNameInfo").empty();
            if(APKName != null && APKName != ""){
                $.ajax({
                    type:"GET",
                    url: "${pageContext.request.contextPath }/app/checkAPKName.action",
                    data: {"APKName":APKName},
                    success: function(data){
                        var html = "";
                        if(data == 1){
                            html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                            html += "<span style=\"color: red\">   APK名称已被使用</span>";
                        }else{
                            html += "<img src=\"${pageContext.request.contextPath}/statics/images/yes.png\">";
                        }
                        $("#APKNameInfo").append(html);
                    },
                    error: function (e) {
                        alert(e.toString());
                    }
                });
            }else {
                $("#APKNameInfo").empty();
                var html = "";
                html += "<img src=\"${pageContext.request.contextPath}/statics/images/no.png\" style=\"width: 22px\">";
                html += "<span style=\"color: red\">   请输入APK名称</span>";
                $("#APKNameInfo").append(html);
            }

        });

        $("#categoryLevel1").change(function () {
            var parentId = $(this).val();
            $('#categoryLevel2').empty();
            $('#categoryLevel3').empty();
            $.ajax({
                type:"GET",
                url: "${pageContext.request.contextPath }/app/getAppCategory.action",
                data: {"parentId":parentId},
                success: function(data){
                    var obj = eval("("+data+")");
                    var html = "";
                    if(obj.length == 0){
                        html += "<option value=\"0\">-没有分类-</option>";
                    }else {
                        html += "<option value=\"0\">--请选择--</option>";
                        for(var i = 0;i<obj.length;i++){
                            html += "<option value="+ obj[i].id+">"+obj[i].categoryName+"</option>";
                        }
                    }

                    $('#categoryLevel2').append(html);
                },
                error: function (e) {
                    alert(e.toString());
                }
            });
        });

        $("#categoryLevel2").change(function () {
            var parentId = $(this).val();
            $('#categoryLevel3').empty();
            $.ajax({
                type:"GET",
                url: "${pageContext.request.contextPath }/app/getAppCategory.action",
                data: {"parentId":parentId},
                success: function(data){
                    var obj = eval("("+data+")");
                    var html = "";
                    if(obj.length == 0){
                        html += "<option value=\"0\">-没有分类-</option>";
                    }else {
                        html += "<option value=\"0\">--请选择--</option>";
                        for(var i = 0;i<obj.length;i++){
                            html += "<option value="+ obj[i].id+">"+obj[i].categoryName+"</option>";
                        }
                    }
                    $('#categoryLevel3').append(html);
                },
                error: function (e) {
                    alert(e.toString());
                }
            });
        });
    });

</script>