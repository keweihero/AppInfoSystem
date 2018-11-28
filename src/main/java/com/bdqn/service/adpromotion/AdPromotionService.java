package com.bdqn.service.adpromotion;

import com.bdqn.pojo.AdPromotion;
import com.bdqn.pojo.PageBean;

import java.util.List;
import java.util.Map;

/**
* 业务接口
*/
public interface AdPromotionService {

    AdPromotion getAdPromotionById(Integer id);

    List<AdPromotion> getAdPromotionListByMap(Map<String, Object> param);

    Integer getAdPromotionCountByMap(Map<String, Object> param);

    Integer addAdPromotion(AdPromotion adPromotion);

    Integer modifyAdPromotion(AdPromotion adPromotion);

    Integer deleteAdPromotionById(Integer id);

    PageBean<AdPromotion> queryAdPromotionPageByMap(Map<String, Object> param, Integer size, Integer cur);
}
