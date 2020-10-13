package com.stock.answer.beans;

public class AppconfigBean {

    /**
     * isUpdate : 0
     * isWap : 0
     * wapUrl : https://np.zonghengqihuo.com
     * updateUrl :
     */

    private int isUpdate;
    private int isWap;
    private String wapUrl;
    private String updateUrl;

    public int getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(int isUpdate) {
        this.isUpdate = isUpdate;
    }

    public int getIsWap() {
        return isWap;
    }

    public void setIsWap(int isWap) {
        this.isWap = isWap;
    }

    public String getWapUrl() {
        return wapUrl;
    }

    public void setWapUrl(String wapUrl) {
        this.wapUrl = wapUrl;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }
}
