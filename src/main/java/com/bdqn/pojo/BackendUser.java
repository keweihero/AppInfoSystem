package com.bdqn.pojo;
import java.io.Serializable;
import java.util.*;
import java.sql.*;
/***
*   
*/
public class BackendUser implements Serializable {
        //主键id
        private Integer id;
        //用户编码
        private String userCode;
        //用户名称
        private String userName;
        //用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
        private Integer userType;
        //创建者（来源于backend_user用户表的用户id）
        private Integer createdBy;
        //创建时间
        private Timestamp creationDate;
        //更新者（来源于backend_user用户表的用户id）
        private Integer modifyBy;
        //最新更新时间
        private Timestamp modifyDate;
        //用户密码
        private String userPassword;
        //get set 方法
        public void setId (Integer  id){
            this.id=id;
        }
        public  Integer getId(){
            return this.id;
        }
        public void setUserCode (String  userCode){
            this.userCode=userCode;
        }
        public  String getUserCode(){
            return this.userCode;
        }
        public void setUserName (String  userName){
            this.userName=userName;
        }
        public  String getUserName(){
            return this.userName;
        }
        public void setUserType (Integer  userType){
            this.userType=userType;
        }
        public  Integer getUserType(){
            return this.userType;
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
        public void setUserPassword (String  userPassword){
            this.userPassword=userPassword;
        }
        public  String getUserPassword(){
            return this.userPassword;
        }
}
