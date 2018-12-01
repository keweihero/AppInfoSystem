package com.bdqn.controller;

import com.bdqn.pojo.AppCategory;
import com.bdqn.pojo.DataDictionary;
import com.bdqn.service.appcategory.AppCategoryService;
import com.bdqn.service.appinfo.AppInfoService;
import com.bdqn.service.appversion.AppVersionService;
import com.bdqn.service.datadictionary.DataDictionaryService;
import com.bdqn.service.devuser.DevUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class AppInfoController {
    private final Logger LOG = Logger.getLogger(getClass());
    @Resource
    DevUserService devUserService;

    @Resource
    AppInfoService appInfoService;

    @Resource
    DataDictionaryService dataDictionaryService;

    @Resource
    AppCategoryService appCategoryService;

    @Resource
    AppVersionService appVersionService;


    @RequestMapping("/doAddAppInfo.action")
    public String doAddAppInfo(HttpSession session){




        return "";
    }

//    读取一级分类appinfoadd
    @RequestMapping("/appinfoadd.action")
    public String appinfoaddPage(Model model){
        List<AppCategory> categoryLevelOne = appCategoryService.getAllAppCategoryListLevelOne();
        Map<String, Object> typeCodeMap = new HashMap<>(16);
        typeCodeMap.put("typeCode","APP_FLATFORM");
        List<DataDictionary> flatformList = dataDictionaryService.getDataDictionaryListByMap(typeCodeMap);

        model.addAttribute("flatformList", flatformList);
        model.addAttribute("categoryLevelOne", categoryLevelOne);
        return "forward:/devPage/appinfoadd.action";
    }

    @RequestMapping("/checkAPKName.action")
    @ResponseBody
    public Object checkAPKName(String APKName){
        Map<String, Object> apkName = new HashMap<>(16);
        apkName.put("APKName", APKName);
        return  appInfoService.getAppInfoCountByMap(apkName);
    }

    // TODO 异步返回数据
    @RequestMapping("/getAppCategory.action")
    @ResponseBody
    public Object getAppCategory(Integer parentId){
        Map<String, Object> map = new HashMap<>();
        map.put("parentId", parentId);
        List<AppCategory> allAppCategoryList = appCategoryService.getAppCategoryListByMap(map);
        LOG.info("APP信息管理系统,DevController:getAppCategory()接收到请求,parentId:" + parentId);
        LOG.info("APP信息管理系统,DevController:getAppCategory()接收到请求,allAppCategoryList:" + allAppCategoryList.size());
        return allAppCategoryList;
    }
}
