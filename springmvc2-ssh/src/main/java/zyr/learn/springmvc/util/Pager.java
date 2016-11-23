package zyr.learn.springmvc.util;

import java.util.List;

/**
 * Created by zhouweitao on 2016/11/16.
 */
public class Pager<T> {
    private int pagerOffset;
    private int pagerSize;
    private long totalRecord;
    private int totalPage;
    private List<T> datas;

    public int getPagerOffset() {
        return pagerOffset;
    }

    public void setPagerOffset(int pagerOffset) {
        this.pagerOffset = pagerOffset;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPagerSize() {
        return pagerSize;
    }

    public void setPagerSize(int pagerSize) {
        this.pagerSize = pagerSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
