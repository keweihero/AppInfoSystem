package com.bdqn.dao.datadictionary;

import com.bdqn.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
mapper接口
*/
public interface DataDictionaryMapper {

	DataDictionary getDataDictionaryById(@Param(value = "id") Integer id);

	List<DataDictionary> getDataDictionaryListByMap(Map<String, Object> param);

	Integer getDataDictionaryCountByMap(Map<String, Object> param);

	Integer insertDataDictionary(DataDictionary dataDictionary);

	Integer updateDataDictionary(DataDictionary dataDictionary);

	Integer deleteDataDictionaryById(@Param(value = "id") Integer id);

}
