package com.bdqn.pojo;
import java.io.Serializable;
import java.util.*;
import java.sql.*;
/***
*   
*/
public class DevUser implements Serializable {
        //主键id
        private Integer id;
        //开发者帐号
        private String devCode;
        //开发者名称
        private String devName;
        //开发者密码
        private String devPassword;
        //开发者电子邮箱
        private String devEmail;
        //开发者简介
        private String devInfo;
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
        public void setDevCode (String  devCode){
            this.devCode=devCode;
        }
        public  String getDevCode(){
            return this.devCode;
        }
        public void setDevName (String  devName){
            this.devName=devName;
        }
        public  String getDevName(){
            return this.devName;
        }
        public void setDevPassword (String  devPassword){
            this.devPassword=devPassword;
        }
        public  String getDevPassword(){
            return this.devPassword;
        }
        public void setDevEmail (String  devEmail){
            this.devEmail=devEmail;
        }
        public  String getDevEmail(){
            return this.devEmail;
        }
        public void setDevInfo (String  devInfo){
            this.devInfo=devInfo;
        }
        public  String getDevInfo(){
            return this.devInfo;
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
