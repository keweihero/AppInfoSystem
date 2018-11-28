package com.bdqn.service.backenduser;

import com.bdqn.dao.backenduser.BackendUserMapper;
import com.bdqn.pojo.BackendUser;
import com.bdqn.pojo.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
业务接口实现
*/
@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService {

    @Resource
    private BackendUserMapper backendUserMapper;

	@Override
    public BackendUser getBackendUserById(Integer id){
			 return backendUserMapper.getBackendUserById(id);
    }

	@Override
    public List<BackendUser> getBackendUserListByMap(Map<String,Object> param){
			return backendUserMapper.getBackendUserListByMap(param);
    }

	@Override
    public Integer getBackendUserCountByMap(Map<String,Object> param){
			return backendUserMapper.getBackendUserCountByMap(param);
    }

	@Override
    public Integer addBackendUser(BackendUser backendUser){
			return backendUserMapper.insertBackendUser(backendUser);
    }

	@Override
    public Integer modifyBackendUser(BackendUser backendUser){
			return backendUserMapper.updateBackendUser(backendUser);
    }

	@Override
    public Integer deleteBackendUserById(Integer id){
			return backendUserMapper.deleteBackendUserById(id);
    }

	@Override
    public PageBean<BackendUser> queryBackendUserPageByMap(Map<String,Object> param, Integer size, Integer cur){
			Integer total = backendUserMapper.getBackendUserCountByMap(param);
            PageBean<BackendUser> pageBean = new PageBean<BackendUser>(total,size,cur);
            param.put("start", (pageBean.getCurrentPage()-1)*pageBean.getPageSize());
            param.put("size", pageBean.getPageSize());
            List<BackendUser> backendUserList = backendUserMapper.getBackendUserListByMap(param);
            pageBean.setList(backendUserList);
            return pageBean;
    }
}
