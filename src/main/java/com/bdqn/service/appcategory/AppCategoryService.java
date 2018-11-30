package com.bdqn.service.appcategory;

import com.bdqn.pojo.AppCategory;
import com.bdqn.pojo.PageBean;

import java.util.List;
import java.util.Map;

/**
* 业务接口
*/
public interface AppCategoryService {

    AppCategory getAppCategoryById(Integer id);

    List<AppCategory> getAppCategoryListByMap(Map<String, Object> param);

    Integer getAppCategoryCountByMap(Map<String, Object> param);

    Integer addAppCategory(AppCategory appCategory);

    Integer modifyAppCategory(AppCategory appCategory);

    Integer deleteAppCategoryById(Integer id);

    List<AppCategory> getAllAppCategoryList();
    List<AppCategory> getAllAppCategoryListLevelOne();

    PageBean<AppCategory> queryAppCategoryPageByMap(Map<String, Object> param, Integer size, Integer cur);
}
