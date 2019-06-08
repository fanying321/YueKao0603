package com.fy.fanying20190603.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/3 14:17
 * @Description：描述信息
 */
@Entity
public class Result {
    @Id
    private long commodityId;
    private String commodityName;
    private String masterPic;
    private int price;
    private int saleNum;
    @Generated(hash = 986399218)
    public Result(long commodityId, String commodityName, String masterPic,
            int price, int saleNum) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.masterPic = masterPic;
        this.price = price;
        this.saleNum = saleNum;
    }
    @Generated(hash = 1176609929)
    public Result() {
    }
    public long getCommodityId() {
        return this.commodityId;
    }
    public void setCommodityId(long commodityId) {
        this.commodityId = commodityId;
    }
    public String getCommodityName() {
        return this.commodityName;
    }
    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
    public String getMasterPic() {
        return this.masterPic;
    }
    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getSaleNum() {
        return this.saleNum;
    }
    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }
}
