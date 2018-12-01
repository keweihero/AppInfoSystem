package com.bdqn.service.appcategory;

import com.bdqn.dao.appcategory.AppCategoryMapper;
import com.bdqn.pojo.AppCategory;
import com.bdqn.pojo.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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
    // 获取所有分类集合
    public List<AppCategory> getAllAppCategoryList() {

	    // 一级分类
        List<AppCategory> appCategoryListByLevelOne = appCategoryMapper.getAppCategoryListLevelOne();

        for (AppCategory appCategory : appCategoryListByLevelOne){
            Map<String, Object> map = new HashMap<>(16);
            map.put("parentId",appCategory.getId());
            // 二级分类
            List<AppCategory> appCategoryListLevelTwo = appCategoryMapper.getAppCategoryListByMap(map);

            for(AppCategory appCategory2 : appCategoryListLevelTwo){
                Map<String, Object> nmap = new HashMap<>(16);
                nmap.put("parentId",appCategory2.getId());
                // 三级分类
                List<AppCategory> appCategoryListLevelThree = appCategoryMapper.getAppCategoryListByMap(nmap);
                appCategory2.setList(appCategoryListLevelThree);
            }
            appCategory.setList(appCategoryListLevelTwo);
        }
        return appCategoryListByLevelOne;
    }

    @Override
    public List<AppCategory> getAllAppCategoryListLevelOne() {
        return appCategoryMapper.getAppCategoryListLevelOne();
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
