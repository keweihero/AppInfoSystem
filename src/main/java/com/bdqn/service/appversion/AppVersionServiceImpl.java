package com.bdqn.service.appversion;

import com.bdqn.dao.appversion.AppVersionMapper;
import com.bdqn.pojo.AppVersion;
import com.bdqn.pojo.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
业务接口实现
*/
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService {

    @Resource
    private AppVersionMapper appVersionMapper;

	@Override
    public AppVersion getAppVersionById(Integer id){
			 return appVersionMapper.getAppVersionById(id);
    }

	@Override
    public List<AppVersion> getAppVersionListByMap(Map<String,Object> param){
			return appVersionMapper.getAppVersionListByMap(param);
    }

	@Override
    public Integer getAppVersionCountByMap(Map<String,Object> param){
			return appVersionMapper.getAppVersionCountByMap(param);
    }

	@Override
    public Integer addAppVersion(AppVersion appVersion){
			return appVersionMapper.insertAppVersion(appVersion);
    }

	@Override
    public Integer modifyAppVersion(AppVersion appVersion){
			return appVersionMapper.updateAppVersion(appVersion);
    }

	@Override
    public Integer deleteAppVersionById(Integer id){
			return appVersionMapper.deleteAppVersionById(id);
    }

	@Override
    public PageBean<AppVersion> queryAppVersionPageByMap(Map<String,Object> param, Integer size, Integer cur){
			Integer total = appVersionMapper.getAppVersionCountByMap(param);
            PageBean<AppVersion> pageBean = new PageBean<AppVersion>(total,size,cur);
            param.put("start", (pageBean.getCurrentPage()-1)*pageBean.getPageSize());
            param.put("size", pageBean.getPageSize());
            List<AppVersion> appVersionList = appVersionMapper.getAppVersionListByMap(param);
            pageBean.setList(appVersionList);
            return pageBean;
    }
}
