package com.bdqn.service.adpromotion;

import com.bdqn.dao.adpromotion.AdPromotionMapper;
import com.bdqn.pojo.AdPromotion;
import com.bdqn.pojo.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
业务接口实现
*/
@Service("adPromotionService")
public class AdPromotionServiceImpl implements AdPromotionService {

    @Resource
    private AdPromotionMapper adPromotionMapper;

	@Override
    public AdPromotion getAdPromotionById(Integer id){
			 return adPromotionMapper.getAdPromotionById(id);
    }

	@Override
    public List<AdPromotion> getAdPromotionListByMap(Map<String,Object> param){
			return adPromotionMapper.getAdPromotionListByMap(param);
    }

	@Override
    public Integer getAdPromotionCountByMap(Map<String,Object> param){
			return adPromotionMapper.getAdPromotionCountByMap(param);
    }

	@Override
    public Integer addAdPromotion(AdPromotion adPromotion){
			return adPromotionMapper.insertAdPromotion(adPromotion);
    }

	@Override
    public Integer modifyAdPromotion(AdPromotion adPromotion){
			return adPromotionMapper.updateAdPromotion(adPromotion);
    }

	@Override
    public Integer deleteAdPromotionById(Integer id){
			return adPromotionMapper.deleteAdPromotionById(id);
    }

	@Override
    public PageBean<AdPromotion> queryAdPromotionPageByMap(Map<String,Object> param, Integer size, Integer cur){
			Integer total = adPromotionMapper.getAdPromotionCountByMap(param);
            PageBean<AdPromotion> pageBean = new PageBean<AdPromotion>(total,size,cur);
            param.put("start", (pageBean.getCurrentPage()-1)*pageBean.getPageSize());
            param.put("size", pageBean.getPageSize());
            List<AdPromotion> adPromotionList = adPromotionMapper.getAdPromotionListByMap(param);
            pageBean.setList(adPromotionList);
            return pageBean;
    }
}
