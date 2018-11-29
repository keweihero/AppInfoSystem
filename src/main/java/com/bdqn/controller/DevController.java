package com.bdqn.controller;

import com.bdqn.pojo.*;
import com.bdqn.service.appcategory.AppCategoryService;
import com.bdqn.service.appinfo.AppInfoService;
import com.bdqn.service.appversion.AppVersionService;
import com.bdqn.service.datadictionary.DataDictionaryService;
import com.bdqn.service.devuser.DevUserService;
import com.bdqn.utils.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dev")
public class DevController {

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

    @RequestMapping(value = "/doLogin.action",method = RequestMethod.POST)
    public String doLogin(String devCode, String devPassword, HttpSession session, HttpServletRequest req){
        LOG.info("APP信息管理系统,DevController:doLogin()接收到请求,参数:devCode:" + devCode + ", devPassword:" + devPassword);
        Map<String, Object> param = new HashMap<>();
        param.put("devCode", devCode);
        param.put("devPassword", devPassword);
        DevUser user = devUserService.doLogin(param);
        if(null != user){
            session.setAttribute(Constants.USER_SESSION, user);
            return "redirect:/devPage/main.action";
        }else {
            req.setAttribute("e",new RuntimeException("账号或者密码不正确"));
            return "devlogin";
        }
    }

    /**
     * 封装字段 处理,查询分页`
     * @param model
     * @return
     */
    @RequestMapping("/flatform/app/list.action")
    public String doList(Model model,String currentPage, String status, String flatformId, String softwareName){
        LOG.info("APP信息管理系统,DevController:doList()接收到请求");
        Map<String, Object> appParam = new HashMap<>(16);
        LOG.info("APP信息管理系统,DevController:doList()处理请求,参数 status:" + status);
        LOG.info("APP信息管理系统,DevController:doList()处理请求,参数 softwareName:" + softwareName);
        if("0".equals(status)){
            status = null;
        }
        if("0".equals(flatformId)){
            flatformId = null;
        }
        appParam.put("status", status);
        appParam.put("softwareName", softwareName);
        appParam.put("flatformId", flatformId);
        Integer valueOf = null;
        if(null != currentPage){
            valueOf = Integer.valueOf(currentPage);
        }
        PageBean<AppInfo> appInfoPageBean = appInfoService.queryAppInfoPageByMap(appParam, null, valueOf);


        Map<String, Object> typeCodeMap = new HashMap<>(16);
        typeCodeMap.put("typeCode","APP_FLATFORM");
        List<DataDictionary> flatformList = dataDictionaryService.getDataDictionaryListByMap(typeCodeMap);

        Map<String, Object> map = new HashMap<>(16);
        map.put("typeCode","APP_STATUS");
        List<DataDictionary> statusList = dataDictionaryService.getDataDictionaryListByMap(map);

        Map<String, Object> versionMap = new HashMap<>(16);
        List<AppVersion> versionList = appVersionService.getAppVersionListByMap(versionMap);

        List<AppCategory> appCategoryListByMap = appCategoryService.getAppCategoryListByMap(new HashMap<>(16));
        for (AppInfo app : appInfoPageBean.getList()){
            for(AppCategory appCategory : appCategoryListByMap){
                if(app.getCategoryLevel1() == appCategory.getId()){
                    app.setCategoryLevel1Name(appCategory.getCategoryName());
                }
                if(app.getCategoryLevel2() == appCategory.getId()){
                    app.setCategoryLevel2Name(appCategory.getCategoryName());
                }
                if(app.getCategoryLevel3() == appCategory.getId()){
                    app.setCategoryLevel3Name(appCategory.getCategoryName());
                }
            }
            for(DataDictionary dataDictionary : flatformList){
                if(app.getFlatformId() == dataDictionary.getValueId()){
                    app.setFlatformName(dataDictionary.getValueName());
                    break;
                }
            }
            for(DataDictionary dataDictionary : statusList){
                if(app.getStatus() == dataDictionary.getValueId()){
                    app.setStatusName(dataDictionary.getValueName());
                    break;
                }
            }
            for(AppVersion appVersion : versionList){
                if(app.getVersionId() == null){
                    app.setVersionNo("未发布");
                    break;
                }else if(app.getVersionId() == appVersion.getId()){
                    app.setVersionNo(appVersion.getVersionNo());
                    break;
                }
            }
        }
        LOG.info("APP信息管理系统,DevController:doList()处理请求,集合长度:" + appInfoPageBean.getList().size());
        LOG.info("APP信息管理系统,DevController:doList()响应,appInfoList:" + appInfoPageBean);
        model.addAttribute("appInfo", appInfoPageBean);

        model.addAttribute("statusList", statusList);
        model.addAttribute("flatformList", flatformList);
        model.addAttribute("flatformId", flatformId);
        model.addAttribute("softwareName", softwareName);
        model.addAttribute("status",status);
        return "forward:/devPage/list.action";
    }
}
