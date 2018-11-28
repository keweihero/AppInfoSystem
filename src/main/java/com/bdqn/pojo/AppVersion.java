package com.bdqn.pojo;
import java.io.Serializable;
import java.util.*;
import java.sql.*;
/***
*   
*/
public class AppVersion implements Serializable {
        //主键id
        private Integer id;
        //appId（来源于：app_info表的主键id）
        private Integer appId;
        //版本号
        private String versionNo;
        //版本介绍
        private String versionInfo;
        //发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
        private Integer publishStatus;
        //下载链接
        private String downloadLink;
        //版本大小（单位：M）
        private Double versionSize;
        //创建者（来源于dev_user开发者信息表的用户id）
        private Integer createdBy;
        //创建时间
        private Timestamp creationDate;
        //更新者（来源于dev_user开发者信息表的用户id）
        private Integer modifyBy;
        //最新更新时间
        private Timestamp modifyDate;
        //apk文件的服务器存储路径
        private String apkLocPath;
        //上传的apk文件名称
        private String apkFileName;
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
        public void setVersionNo (String  versionNo){
            this.versionNo=versionNo;
        }
        public  String getVersionNo(){
            return this.versionNo;
        }
        public void setVersionInfo (String  versionInfo){
            this.versionInfo=versionInfo;
        }
        public  String getVersionInfo(){
            return this.versionInfo;
        }
        public void setPublishStatus (Integer  publishStatus){
            this.publishStatus=publishStatus;
        }
        public  Integer getPublishStatus(){
            return this.publishStatus;
        }
        public void setDownloadLink (String  downloadLink){
            this.downloadLink=downloadLink;
        }
        public  String getDownloadLink(){
            return this.downloadLink;
        }
        public void setVersionSize (Double  versionSize){
            this.versionSize=versionSize;
        }
        public  Double getVersionSize(){
            return this.versionSize;
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
        public void setApkLocPath (String  apkLocPath){
            this.apkLocPath=apkLocPath;
        }
        public  String getApkLocPath(){
            return this.apkLocPath;
        }
        public void setApkFileName (String  apkFileName){
            this.apkFileName=apkFileName;
        }
        public  String getApkFileName(){
            return this.apkFileName;
        }
}
