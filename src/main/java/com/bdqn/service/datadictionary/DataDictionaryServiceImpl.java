package com.bdqn.service.datadictionary;

import com.bdqn.dao.datadictionary.DataDictionaryMapper;
import com.bdqn.pojo.DataDictionary;
import com.bdqn.pojo.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
业务接口实现
*/
@Service("dataDictionaryService")
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Resource
    private DataDictionaryMapper dataDictionaryMapper;

	@Override
    public DataDictionary getDataDictionaryById(Integer id){
			 return dataDictionaryMapper.getDataDictionaryById(id);
    }

	@Override
    public List<DataDictionary> getDataDictionaryListByMap(Map<String,Object> param){
			return dataDictionaryMapper.getDataDictionaryListByMap(param);
    }

	@Override
    public Integer getDataDictionaryCountByMap(Map<String,Object> param){
			return dataDictionaryMapper.getDataDictionaryCountByMap(param);
    }

	@Override
    public Integer addDataDictionary(DataDictionary dataDictionary){
			return dataDictionaryMapper.insertDataDictionary(dataDictionary);
    }

	@Override
    public Integer modifyDataDictionary(DataDictionary dataDictionary){
			return dataDictionaryMapper.updateDataDictionary(dataDictionary);
    }

	@Override
    public Integer deleteDataDictionaryById(Integer id){
			return dataDictionaryMapper.deleteDataDictionaryById(id);
    }

	@Override
    public PageBean<DataDictionary> queryDataDictionaryPageByMap(Map<String,Object> param, Integer size, Integer cur){
			Integer total = dataDictionaryMapper.getDataDictionaryCountByMap(param);
            PageBean<DataDictionary> pageBean = new PageBean<DataDictionary>(total,size,cur);
            param.put("start", (pageBean.getCurrentPage()-1)*pageBean.getPageSize());
            param.put("size", pageBean.getPageSize());
            List<DataDictionary> dataDictionaryList = dataDictionaryMapper.getDataDictionaryListByMap(param);
            pageBean.setList(dataDictionaryList);
            return pageBean;
    }
}
