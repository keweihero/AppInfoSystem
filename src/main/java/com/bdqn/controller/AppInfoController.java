package com.bdqn.controller;

import com.bdqn.pojo.AppCategory;
import com.bdqn.pojo.AppInfo;
import com.bdqn.pojo.DataDictionary;
import com.bdqn.service.appcategory.AppCategoryService;
import com.bdqn.service.appinfo.AppInfoService;
import com.bdqn.service.appversion.AppVersionService;
import com.bdqn.service.datadictionary.DataDictionaryService;
import com.bdqn.service.devuser.DevUserService;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
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



    // TODO 13参数: 实现提交参数,文件上传
    @RequestMapping(value = "/doAddAppInfo.action", method = RequestMethod.POST)
    public String doAddAppInfo(Model model,HttpServletRequest request, AppInfo appInfo, MultipartFile a_logoPicPath) throws IOException {
        appInfo.setCreationDate(new Timestamp(System.currentTimeMillis()));

        String oldFileName = a_logoPicPath.getOriginalFilename();
        String extension = FilenameUtils.getExtension(oldFileName);
        String newFileName = appInfo.getAPKName() + "." +extension;
        String rootPath = request.getServletContext().getRealPath("/");
        String relativePath = "\\statics\\uploadfiles\\" + newFileName;
        String fullPath = rootPath + relativePath;
        appInfo.setLogoPicPath(relativePath);
        appInfo.setLogoLocPath(fullPath);

        LOG.info("APP信息管理系统,AppInfoController:doAddAppInfo()接收到请求,appInfo:" + appInfo.toString());
        Integer integer = appInfoService.addAppInfo(appInfo);
        if(integer > 0){
            a_logoPicPath.transferTo(new File(fullPath));
            return "redirect:/dev/flatform/app/list.action";
        }else{
            List<AppCategory> categoryLevelOne = appCategoryService.getAllAppCategoryListLevelOne();
            Map<String, Object> typeCodeMap = new HashMap<>(16);
            typeCodeMap.put("typeCode","APP_FLATFORM");
            List<DataDictionary> flatformList = dataDictionaryService.getDataDictionaryListByMap(typeCodeMap);

            Map<String, Object> categoryLevel2map = new HashMap<>();
            categoryLevel2map.put("parentId", appInfo.getCategoryLevel1());
            List<AppCategory> categoryLevelTwo = appCategoryService.getAppCategoryListByMap(categoryLevel2map);
            model.addAttribute("categoryLevelTwo", categoryLevelTwo);


            Map<String, Object> categoryLevel3map = new HashMap<>();
            categoryLevel3map.put("parentId", appInfo.getCategoryLevel2());
            List<AppCategory> categoryLevelThree = appCategoryService.getAppCategoryListByMap(categoryLevel3map);
            model.addAttribute("categoryLevelThree", categoryLevelThree);

            model.addAttribute("categoryLevel1", appInfo.getCategoryLevel1());
            model.addAttribute("categoryLevel2", appInfo.getCategoryLevel2());
            model.addAttribute("categoryLevel3", appInfo.getCategoryLevel3());
            model.addAttribute("flatformList", flatformList);
            model.addAttribute("flatformId", appInfo.getFlatformId());
            model.addAttribute("categoryLevelOne", categoryLevelOne);
            model.addAttribute("appInfo",appInfo);
            model.addAttribute("appInfoInfo",appInfo.getAppInfo());
            // TODO 选项回显 直接返回参数
            return "forward:/devPage/appinfoadd.action";
        }



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
        LOG.info("APP信息管理系统,AppInfoController:getAppCategory()接收到请求,parentId:" + parentId);
        LOG.info("APP信息管理系统,AppInfoController:getAppCategory()接收到请求,allAppCategoryList:" + allAppCategoryList.size());
        return allAppCategoryList;
    }
}
