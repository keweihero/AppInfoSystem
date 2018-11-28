package com.bdqn.pojo;
import java.io.Serializable;
import java.sql.Timestamp;
/***
*   
*/
public class AdPromotion implements Serializable {
        //主键id
        private Integer id;
        //appId（来源于：app_info表的主键id）
        private Integer appId;
        //广告图片存储路径
        private String adPicPath;
        //广告点击量
        private Integer adPV;
        //轮播位（1-n）
        private Integer carouselPosition;
        //起效时间
        private Timestamp startTime;
        //失效时间
        private Timestamp endTime;
        //创建者（来源于backend_user用户表的用户id）
        private Integer createdBy;
        //创建时间
        private Timestamp creationDate;
        //更新者（来源于backend_user用户表的用户id）
        private Integer modifyBy;
        //最新更新时间
        private Timestamp modifyDate;
        //get set 方法
        public void setId (Integer  id){
            this.id=id;
        }
        public  Integer getId(){
            return this.id;
        }
        public void setAppId (Integer  appId){
            this.appId=appId;
        }
        public  Integer getAppId(){
            return this.appId;
        }
        public void setAdPicPath (String  adPicPath){
            this.adPicPath=adPicPath;
        }
        public  String getAdPicPath(){
            return this.adPicPath;
        }
        public void setAdPV (Integer  adPV){
            this.adPV=adPV;
        }
        public  Integer getAdPV(){
            return this.adPV;
        }
        public void setCarouselPosition (Integer  carouselPosition){
            this.carouselPosition=carouselPosition;
        }
        public  Integer getCarouselPosition(){
            return this.carouselPosition;
        }
        public void setStartTime (Timestamp  startTime){
            this.startTime=startTime;
        }
        public  Timestamp getStartTime(){
            return this.startTime;
        }
        public void setEndTime (Timestamp  endTime){
            this.endTime=endTime;
        }
        public  Timestamp getEndTime(){
            return this.endTime;
        }
        public void setCreatedBy (Integer  createdBy){
            this.createdBy=createdBy;
        }
        public  Integer getCreatedBy(){
            return this.createdBy;
        }
        public void setCreationDate (Timestamp  creationDate){
            this.creationDate=creationDate;
        }
        public  Timestamp getCreationDate(){
            return this.creationDate;
        }
        public void setModifyBy (Integer  modifyBy){
            this.modifyBy=modifyBy;
        }
        public  Integer getModifyBy(){
            return this.modifyBy;
        }
        public void setModifyDate (Timestamp  modifyDate){
            this.modifyDate=modifyDate;
        }
        public  Timestamp getModifyDate(){
            return this.modifyDate;
        }
}
