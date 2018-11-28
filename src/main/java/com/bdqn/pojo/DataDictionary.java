package com.bdqn.pojo;
import java.io.Serializable;
import java.util.*;
import java.sql.*;
/***
*   
*/
public class DataDictionary implements Serializable {
        //主键ID
        private Integer id;
        //类型编码
        private String typeCode;
        //类型名称
        private String typeName;
        //类型值ID
        private Integer valueId;
        //类型值Name
        private String valueName;
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
        public void setTypeCode (String  typeCode){
            this.typeCode=typeCode;
        }
        public  String getTypeCode(){
            return this.typeCode;
        }
        public void setTypeName (String  typeName){
            this.typeName=typeName;
        }
        public  String getTypeName(){
            return this.typeName;
        }
        public void setValueId (Integer  valueId){
            this.valueId=valueId;
        }
        public  Integer getValueId(){
            return this.valueId;
        }
        public void setValueName (String  valueName){
            this.valueName=valueName;
        }
        public  String getValueName(){
            return this.valueName;
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
