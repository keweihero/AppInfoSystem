package com.bdqn.dao.appcategory;

import com.bdqn.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
mapper接口
*/
public interface AppCategoryMapper {

	AppCategory getAppCategoryById(@Param(value = "id") Integer id);

	List<AppCategory> getAppCategoryListByMap(Map<String, Object> param);
	List<AppCategory> getAppCategoryListLevelOne();

	Integer getAppCategoryCountByMap(Map<String, Object> param);

	Integer insertAppCategory(AppCategory appCategory);

	Integer updateAppCategory(AppCategory appCategory);

	Integer deleteAppCategoryById(@Param(value = "id") Integer id);

}
