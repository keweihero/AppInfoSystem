package com.bdqn.service.devuser;

import com.bdqn.pojo.DevUser;
import com.bdqn.pojo.PageBean;

import java.util.List;
import java.util.Map;

/**
* 业务接口
*/
public interface DevUserService {

    DevUser getDevUserById(Integer id);

    List<DevUser> getDevUserListByMap(Map<String, Object> param);

    Integer getDevUserCountByMap(Map<String, Object> param);

    Integer addDevUser(DevUser devUser);

    Integer modifyDevUser(DevUser devUser);

    Integer deleteDevUserById(Integer id);

    PageBean<DevUser> queryDevUserPageByMap(Map<String, Object> param, Integer size, Integer cur);
}
