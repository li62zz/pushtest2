package com.qf.bean;

import java.util.Date;

public class Food {
    private String foodid;

    private String foodname;

    private Double foodprice;

    private String fooddesc;

    private String foodicon;

    private String foodimage;

    private Integer foodtypeid;

    private Integer foodstatus;

    private Integer foodcount;

    private Date createtime;

    private Date updatetime;

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid == null ? null : foodid.trim();
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname == null ? null : foodname.trim();
    }

    public Double getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(Double foodprice) {
        this.foodprice = foodprice;
    }

    public String getFooddesc() {
        return fooddesc;
    }

    public void setFooddesc(String fooddesc) {
        this.fooddesc = fooddesc == null ? null : fooddesc.trim();
    }

    public String getFoodicon() {
        return foodicon;
    }

    public void setFoodicon(String foodicon) {
        this.foodicon = foodicon == null ? null : foodicon.trim();
    }

    public String getFoodimage() {
        return foodimage;
    }

    public void setFoodimage(String foodimage) {
        this.foodimage = foodimage == null ? null : foodimage.trim();
    }

    public Integer getFoodtypeid() {
        return foodtypeid;
    }

    public void setFoodtypeid(Integer foodtypeid) {
        this.foodtypeid = foodtypeid;
    }

    public Integer getFoodstatus() {
        return foodstatus;
    }

    public void setFoodstatus(Integer foodstatus) {
        this.foodstatus = foodstatus;
    }

    public Integer getFoodcount() {
        return foodcount;
    }

    public void setFoodcount(Integer foodcount) {
        this.foodcount = foodcount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}