package com.bdqn.dao.devuser;

import com.bdqn.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
mapper接口
*/
public interface DevUserMapper {

	DevUser getDevUserById(@Param(value = "id") Integer id);

	List<DevUser> getDevUserListByMap(Map<String, Object> param);

	Integer getDevUserCountByMap(Map<String, Object> param);

	Integer insertDevUser(DevUser devUser);

	Integer updateDevUser(DevUser devUser);

	Integer deleteDevUserById(@Param(value = "id") Integer id);

}
