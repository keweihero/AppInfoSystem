package com.bdqn.dao.backenduser;

import com.bdqn.pojo.BackendUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
mapper接口
*/
public interface BackendUserMapper {

	BackendUser getBackendUserById(@Param(value = "id") Integer id);

	List<BackendUser> getBackendUserListByMap(Map<String, Object> param);

	Integer getBackendUserCountByMap(Map<String, Object> param);

	Integer insertBackendUser(BackendUser backendUser);

	Integer updateBackendUser(BackendUser backendUser);

	Integer deleteBackendUserById(@Param(value = "id") Integer id);

}
