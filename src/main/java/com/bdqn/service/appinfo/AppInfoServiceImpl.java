package com.bdqn.service.appinfo;

import com.bdqn.dao.appinfo.AppInfoMapper;
import com.bdqn.pojo.AppInfo;
import com.bdqn.pojo.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
业务接口实现
*/
@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {

    @Resource
    private AppInfoMapper appInfoMapper;

	@Override
    public AppInfo getAppInfoById(Integer id){
			 return appInfoMapper.getAppInfoById(id);
    }

	@Override
    public List<AppInfo> getAppInfoListByMap(Map<String,Object> param){
			return appInfoMapper.getAppInfoListByMap(param);
    }

	@Override
    public Integer getAppInfoCountByMap(Map<String,Object> param){
			return appInfoMapper.getAppInfoCountByMap(param);
    }

	@Override
    public Integer addAppInfo(AppInfo appInfo){
			return appInfoMapper.insertAppInfo(appInfo);
    }

    @Override
    public Integer updateAppInfoImg(Integer id) {
        return appInfoMapper.updateAppInfoImg(id);
    }

    @Override
    public Integer modifyAppInfo(AppInfo appInfo){
			return appInfoMapper.updateAppInfo(appInfo);
    }

	@Override
    public Integer deleteAppInfoById(Integer id){
			return appInfoMapper.deleteAppInfoById(id);
    }

	@Override
    public PageBean<AppInfo> queryAppInfoPageByMap(Map<String,Object> param, Integer size, Integer cur){
			Integer total = appInfoMapper.getAppInfoCountByMap(param);
            PageBean<AppInfo> pageBean = new PageBean<AppInfo>(total,size,cur);
            param.put("start", (pageBean.getCurrentPage()-1)*pageBean.getPageSize());
            param.put("size", pageBean.getPageSize());
            List<AppInfo> appInfoList = appInfoMapper.getAppInfoListByMap(param);
            pageBean.setList(appInfoList);
            return pageBean;
    }
}
