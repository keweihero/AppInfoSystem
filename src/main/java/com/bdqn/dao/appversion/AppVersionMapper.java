package com.bdqn.dao.appversion;

import com.bdqn.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
mapper接口
*/
public interface AppVersionMapper {

	AppVersion getAppVersionById(@Param(value = "id") Integer id);

	List<AppVersion> getAppVersionListByMap(Map<String, Object> param);

	Integer getAppVersionCountByMap(Map<String, Object> param);

	Integer insertAppVersion(AppVersion appVersion);

	Integer updateAppVersion(AppVersion appVersion);

	Integer deleteAppVersionById(@Param(value = "id") Integer id);

}
