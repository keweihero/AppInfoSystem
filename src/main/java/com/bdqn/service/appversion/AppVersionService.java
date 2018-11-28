package com.bdqn.service.appversion;

import com.bdqn.pojo.AppVersion;
import com.bdqn.pojo.PageBean;

import java.util.List;
import java.util.Map;

/**
* 业务接口
*/
public interface AppVersionService {

    AppVersion getAppVersionById(Integer id);

    List<AppVersion> getAppVersionListByMap(Map<String, Object> param);

    Integer getAppVersionCountByMap(Map<String, Object> param);

    Integer addAppVersion(AppVersion appVersion);

    Integer modifyAppVersion(AppVersion appVersion);

    Integer deleteAppVersionById(Integer id);

    PageBean<AppVersion> queryAppVersionPageByMap(Map<String, Object> param, Integer size, Integer cur);
}
