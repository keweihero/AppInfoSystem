package com.bdqn.dao.adpromotion;

import com.bdqn.pojo.AdPromotion;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
mapper接口
*/
public interface AdPromotionMapper {

	AdPromotion getAdPromotionById(@Param(value = "id") Integer id);

	List<AdPromotion> getAdPromotionListByMap(Map<String, Object> param);

	Integer getAdPromotionCountByMap(Map<String, Object> param);

	Integer insertAdPromotion(AdPromotion adPromotion);

	Integer updateAdPromotion(AdPromotion adPromotion);

	Integer deleteAdPromotionById(@Param(value = "id") Integer id);

}
