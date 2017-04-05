package com.qxl.mvpproject.tab1.view.data;

import java.util.List;

/**
 * Created by xiaoling on 2016/11/11.
 */
public class UploadBean {


    /**
     * successCount : 1
     * failCount : 0
     * url : ["http://101.200.146.232:8080/virtualpath/18600862404/201610/1477234578639_0.jpg"]
     */

    private int successCount;
    private int failCount;
    private List<String> url;

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    public List<String> getUrl() {
        return url;
    }

    @Override
    public String toString() { //去掉前后大括号,所有照片就是“”。“”，“”的形式，符合服务器要求的多张照片用“，”分割
        StringBuilder sb = new StringBuilder(url.toString());
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }
}
