package com.bdqn.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
/***
*   
*/
public class AppInfo implements Serializable {
    //主键id
    private Integer id;
    //软件名称
    private String softwareName;
    //APK名称（唯一）
    private String APKName;
    //支持ROM
    private String supportROM;
    //界面语言
    private String interfaceLanguage;
    //软件大小（单位：M）
    private Double softwareSize;
    //更新日期
    private Date updateDate;
    //开发者id（来源于：dev_user表的开发者id）
    private Integer devId;
    //应用简介
    private String appInfo;
    //状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
    private Integer status;
    //上架时间
    private Timestamp onSaleDate;
    //下架时间
    private Timestamp offSaleDate;
    //所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
    private Integer flatformId;
    // 所属平台名称
    private String flatformName;
    //所属三级分类（来源于：data_dictionary）
    private Integer categoryLevel3;
    //下载量（单位：次）
    private Integer downloads;
    //创建者（来源于dev_user开发者信息表的用户id）
    private Integer createdBy;
    //创建时间
    private Timestamp creationDate;
    //更新者（来源于dev_user开发者信息表的用户id）
    private Integer modifyBy;
    //最新更新时间
    private Timestamp modifyDate;
    //所属一级分类（来源于：data_dictionary）
    private Integer categoryLevel1;
    //所属二级分类（来源于：data_dictionary）
    private Integer categoryLevel2;
    //LOGO图片url路径
    private String logoPicPath;
    //LOGO图片的服务器存储路径
    private String logoLocPath;
    //最新的版本id
    private Integer versionId;
    private String categoryLevel1Name;
    private String categoryLevel2Name;
    private String categoryLevel3Name;
    private String statusName;
    private String versionNo;

    //get set 方法
    public void setId (Integer  id){
        this.id=id;
    }
    public  Integer getId(){
        return this.id;
    }
    public void setSoftwareName (String  softwareName){
        this.softwareName=softwareName;
    }
    public  String getSoftwareName(){
        return this.softwareName;
    }
    public void setAPKName (String  APKName){
        this.APKName=APKName;
    }
    public  String getAPKName(){
        return this.APKName;
    }
    public void setSupportROM (String  supportROM){
        this.supportROM=supportROM;
    }
    public  String getSupportROM(){
        return this.supportROM;
    }
    public void setInterfaceLanguage (String  interfaceLanguage){
        this.interfaceLanguage=interfaceLanguage;
    }
    public  String getInterfaceLanguage(){
        return this.interfaceLanguage;
    }
    public void setSoftwareSize (Double  softwareSize){
        this.softwareSize=softwareSize;
    }
    public  Double getSoftwareSize(){
        return this.softwareSize;
    }
    public void setUpdateDate (Date  updateDate){
        this.updateDate=updateDate;
    }
    public  Date getUpdateDate(){
        return this.updateDate;
    }
    public void setDevId (Integer  devId){
        this.devId=devId;
    }
    public  Integer getDevId(){
        return this.devId;
    }
    public void setAppInfo (String  appInfo){
        this.appInfo=appInfo;
    }
    public  String getAppInfo(){
        return this.appInfo;
    }
    public void setStatus (Integer  status){
        this.status=status;
    }
    public  Integer getStatus(){
        return this.status;
    }
    public void setOnSaleDate (Timestamp  onSaleDate){
        this.onSaleDate=onSaleDate;
    }
    public  Timestamp getOnSaleDate(){
        return this.onSaleDate;
    }
    public void setOffSaleDate (Timestamp  offSaleDate){
        this.offSaleDate=offSaleDate;
    }
    public  Timestamp getOffSaleDate(){
        return this.offSaleDate;
    }
    public void setFlatformId (Integer  flatformId){
        this.flatformId=flatformId;
    }
    public  Integer getFlatformId(){
        return this.flatformId;
    }
    public void setCategoryLevel3 (Integer  categoryLevel3){
        this.categoryLevel3=categoryLevel3;
    }
    public  Integer getCategoryLevel3(){
        return this.categoryLevel3;
    }
    public void setDownloads (Integer  downloads){
        this.downloads=downloads;
    }
    public  Integer getDownloads(){
        return this.downloads;
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
    public void setCategoryLevel1 (Integer  categoryLevel1){
        this.categoryLevel1=categoryLevel1;
    }
    public  Integer getCategoryLevel1(){
        return this.categoryLevel1;
    }
    public void setCategoryLevel2 (Integer  categoryLevel2){
        this.categoryLevel2=categoryLevel2;
    }
    public  Integer getCategoryLevel2(){
        return this.categoryLevel2;
    }
    public void setLogoPicPath (String  logoPicPath){
        this.logoPicPath=logoPicPath;
    }
    public  String getLogoPicPath(){
        return this.logoPicPath;
    }
    public void setLogoLocPath (String  logoLocPath){
        this.logoLocPath=logoLocPath;
    }
    public  String getLogoLocPath(){
        return this.logoLocPath;
    }
    public void setVersionId (Integer  versionId){
        this.versionId=versionId;
    }
    public  Integer getVersionId(){
            return this.versionId;
        }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getFlatformName() {
        return flatformName;
    }

    public void setFlatformName(String flatformName) {
        this.flatformName = flatformName;
    }

    public String getCategoryLevel1Name() {
        return categoryLevel1Name;
    }

    public void setCategoryLevel1Name(String categoryLevel1Name) {
        this.categoryLevel1Name = categoryLevel1Name;
    }

    public String getCategoryLevel2Name() {
        return categoryLevel2Name;
    }

    public void setCategoryLevel2Name(String categoryLevel2Name) {
        this.categoryLevel2Name = categoryLevel2Name;
    }

    public String getCategoryLevel3Name() {
        return categoryLevel3Name;
    }

    public void setCategoryLevel3Name(String categoryLevel3Name) {
        this.categoryLevel3Name = categoryLevel3Name;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }
}
