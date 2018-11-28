package com.bdqn.service.backenduser;

import com.bdqn.pojo.BackendUser;
import com.bdqn.pojo.PageBean;

import java.util.List;
import java.util.Map;

/**
* 业务接口
*/
public interface BackendUserService {

    BackendUser getBackendUserById(Integer id);

    List<BackendUser> getBackendUserListByMap(Map<String, Object> param);

    Integer getBackendUserCountByMap(Map<String, Object> param);

    Integer addBackendUser(BackendUser backendUser);

    Integer modifyBackendUser(BackendUser backendUser);

    Integer deleteBackendUserById(Integer id);

    PageBean<BackendUser> queryBackendUserPageByMap(Map<String, Object> param, Integer size, Integer cur);
}
