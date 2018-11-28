package com.bdqn.service.devuser;

import com.bdqn.dao.devuser.DevUserMapper;
import com.bdqn.pojo.DevUser;
import com.bdqn.pojo.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
业务接口实现
*/
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {

    @Resource
    private DevUserMapper devUserMapper;

	@Override
    public DevUser getDevUserById(Integer id){
			 return devUserMapper.getDevUserById(id);
    }

	@Override
    public List<DevUser> getDevUserListByMap(Map<String,Object> param){
			return devUserMapper.getDevUserListByMap(param);
    }

	@Override
    public Integer getDevUserCountByMap(Map<String,Object> param){
			return devUserMapper.getDevUserCountByMap(param);
    }

	@Override
    public Integer addDevUser(DevUser devUser){
			return devUserMapper.insertDevUser(devUser);
    }

	@Override
    public Integer modifyDevUser(DevUser devUser){
			return devUserMapper.updateDevUser(devUser);
    }

	@Override
    public Integer deleteDevUserById(Integer id){
			return devUserMapper.deleteDevUserById(id);
    }

	@Override
    public PageBean<DevUser> queryDevUserPageByMap(Map<String,Object> param, Integer size, Integer cur){
			Integer total = devUserMapper.getDevUserCountByMap(param);
            PageBean<DevUser> pageBean = new PageBean<DevUser>(total,size,cur);
            param.put("start", (pageBean.getCurrentPage()-1)*pageBean.getPageSize());
            param.put("size", pageBean.getPageSize());
            List<DevUser> devUserList = devUserMapper.getDevUserListByMap(param);
            pageBean.setList(devUserList);
            return pageBean;
    }
}
