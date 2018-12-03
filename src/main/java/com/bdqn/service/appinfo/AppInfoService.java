package com.bdqn.service.appinfo;

import com.bdqn.pojo.AppInfo;
import com.bdqn.pojo.PageBean;

import java.util.List;
import java.util.Map;

/**
* 业务接口
*/
public interface AppInfoService {

    AppInfo getAppInfoById(Integer id);

    List<AppInfo> getAppInfoListByMap(Map<String, Object> param);

    Integer getAppInfoCountByMap(Map<String, Object> param);

    Integer addAppInfo(AppInfo appInfo);

    Integer updateAppInfoImg(Integer id);

    Integer modifyAppInfo(AppInfo appInfo);

    Integer deleteAppInfoById(Integer id);

    PageBean<AppInfo> queryAppInfoPageByMap(Map<String, Object> param, Integer size, Integer cur);
}
