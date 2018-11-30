package com.bdqn.pojo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/***
*   
*/
public class AppCategory implements Serializable {
    //主键ID
    private Integer id;
    //分类编码
    private String categoryCode;
    //分类名称
    private String categoryName;
    //父级节点id
    private Integer parentId;
    //创建者（来源于backend_user用户表的用户id）
    private Integer createdBy;
    //创建时间
    private Timestamp creationTime;
    //更新者（来源于backend_user用户表的用户id）
    private Integer modifyBy;
    //最新更新时间
    private Timestamp modifyDate;
    private List<AppCategory> list;

    @Override
    public String toString() {
        return "AppCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", list=" + list +
                '}';
    }

    //get set 方法
    public void setId (Integer  id){
        this.id=id;
    }
    public  Integer getId(){
        return this.id;
    }
    public void setCategoryCode (String  categoryCode){
        this.categoryCode=categoryCode;
    }
    public  String getCategoryCode(){
        return this.categoryCode;
    }
    public void setCategoryName (String  categoryName){
        this.categoryName=categoryName;
    }
    public  String getCategoryName(){
        return this.categoryName;
    }
    public void setParentId (Integer  parentId){
        this.parentId=parentId;
    }
    public  Integer getParentId(){
        return this.parentId;
    }
    public void setCreatedBy (Integer  createdBy){
        this.createdBy=createdBy;
    }
    public  Integer getCreatedBy(){
        return this.createdBy;
    }
    public void setCreationTime (Timestamp  creationTime){
        this.creationTime=creationTime;
    }
    public  Timestamp getCreationTime(){
        return this.creationTime;
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

    public List<AppCategory> getList() {
        return list;
    }

    public void setList(List<AppCategory> list) {
        this.list = list;
    }
}
