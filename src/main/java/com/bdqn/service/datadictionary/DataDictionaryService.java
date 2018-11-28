package com.bdqn.service.datadictionary;

import com.bdqn.pojo.DataDictionary;
import com.bdqn.pojo.PageBean;

import java.util.List;
import java.util.Map;

/**
* 业务接口
*/
public interface DataDictionaryService {

    DataDictionary getDataDictionaryById(Integer id);

    List<DataDictionary> getDataDictionaryListByMap(Map<String, Object> param);

    Integer getDataDictionaryCountByMap(Map<String, Object> param);

    Integer addDataDictionary(DataDictionary dataDictionary);

    Integer modifyDataDictionary(DataDictionary dataDictionary);

    Integer deleteDataDictionaryById(Integer id);

    PageBean<DataDictionary> queryDataDictionaryPageByMap(Map<String, Object> param, Integer size, Integer cur);
}
