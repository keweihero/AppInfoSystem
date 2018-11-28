package com.bdqn.dao.appinfo;

import com.bdqn.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
mapper接口
*/
public interface AppInfoMapper {

	AppInfo getAppInfoById(@Param(value = "id") Integer id);

	List<AppInfo> getAppInfoListByMap(Map<String, Object> param);

	Integer getAppInfoCountByMap(Map<String, Object> param);

	Integer insertAppInfo(AppInfo appInfo);

	Integer updateAppInfo(AppInfo appInfo);

	Integer deleteAppInfoById(@Param(value = "id") Integer id);

}
