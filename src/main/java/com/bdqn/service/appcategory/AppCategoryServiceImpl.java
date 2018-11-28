package com.bdqn.service.appcategory;

import com.bdqn.dao.appcategory.AppCategoryMapper;
import com.bdqn.pojo.AppCategory;
import com.bdqn.pojo.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
业务接口实现
*/
@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService {

    @Resource
    private AppCategoryMapper appCategoryMapper;

	@Override
    public AppCategory getAppCategoryById(Integer id){
			 return appCategoryMapper.getAppCategoryById(id);
    }

	@Override
    public List<AppCategory> getAppCategoryListByMap(Map<String,Object> param){
			return appCategoryMapper.getAppCategoryListByMap(param);
    }

	@Override
    public Integer getAppCategoryCountByMap(Map<String,Object> param){
			return appCategoryMapper.getAppCategoryCountByMap(param);
    }

	@Override
    public Integer addAppCategory(AppCategory appCategory){
			return appCategoryMapper.insertAppCategory(appCategory);
    }

	@Override
    public Integer modifyAppCategory(AppCategory appCategory){
			return appCategoryMapper.updateAppCategory(appCategory);
    }

	@Override
    public Integer deleteAppCategoryById(Integer id){
			return appCategoryMapper.deleteAppCategoryById(id);
    }

	@Override
    public PageBean<AppCategory> queryAppCategoryPageByMap(Map<String,Object> param, Integer size, Integer cur){
			Integer total = appCategoryMapper.getAppCategoryCountByMap(param);
            PageBean<AppCategory> pageBean = new PageBean<AppCategory>(total,size,cur);
            param.put("start", (pageBean.getCurrentPage()-1)*pageBean.getPageSize());
            param.put("size", pageBean.getPageSize());
            List<AppCategory> appCategoryList = appCategoryMapper.getAppCategoryListByMap(param);
            pageBean.setList(appCategoryList);
            return pageBean;
    }
}
