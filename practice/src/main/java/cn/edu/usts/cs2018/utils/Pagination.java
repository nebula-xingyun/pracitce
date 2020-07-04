package cn.edu.usts.cs2018.utils;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @program: JavaWebApp
 * @description: PageView
 * @author: Mr.Lu, DCE, USTS.
 * @create: 2020-03-22 23:37
 **/
public class Pagination<T> {
    private List<T> records;                 // 当前页记录
    private Long totalrecordnumber;         // 总记录数
    private Integer startindex;                  // 第一页
    private Integer endindex;                   // 最后一页
    private Integer totalpagenumber;        // 总页数
    private Integer currentpage;                // 当前页
    // 构造方法

    /**
    * @description:
    * @param: [records, totalrecordnumber, currentpage, maximum, viewperpage]
     *                  当前页的记录，总记录数，当前页数，每页记录数 ，显示页数
    * @return:
    */
    public Pagination(List<T> records, Long totalrecordnumber, int currentpage,
                      int maximum, int viewperpage)  {
        this.records = records;
        this.totalrecordnumber = totalrecordnumber;
        this.currentpage = currentpage;
        totalpagenumber = (int) (totalrecordnumber % maximum == 0 ? totalrecordnumber
                / maximum
                : totalrecordnumber / maximum + 1);         //获得总页数
        setIndex(currentpage, viewperpage, totalpagenumber);
    }

    public Pagination(List<T> records, Long totalrecordnumber, int currentpage,
                      int maximum) {
        this.records = records;
        this.totalrecordnumber = totalrecordnumber;
        this.currentpage = currentpage;
        totalpagenumber = (int) (totalrecordnumber % maximum == 0 ? totalrecordnumber
                / maximum
                : totalrecordnumber / maximum + 1);         //获得总页数
        setIndex(currentpage, 5, totalpagenumber);
    }

    public List<T> getRecords() {
        return records;
    }

    public Long getTotalrecordnumber() {
        return totalrecordnumber;
    }
    public Integer getStartindex() {
        return startindex;
    }

    public Integer getEndindex() {
        return endindex;
    }

    public Integer getTotalpagenumber() {
        return totalpagenumber;
    }

    public Integer getCurrentpage() {
        return currentpage;
    }

    //获得总页数 显示页数 当前页数 第一页 最后一页
    public void setIndex(int currentpage, int viewperpage, int totalpagenumber) {
        if (viewperpage >= totalpagenumber) {
            startindex = 1;
            endindex = totalpagenumber;
        } else {
            if (currentpage <= viewperpage / 2) {
                startindex = 1;
                endindex = viewperpage;
            } else if ((currentpage + viewperpage / 2) > totalpagenumber) {
                startindex = totalpagenumber - viewperpage + 1;
                endindex = totalpagenumber;
            } else {
                startindex = currentpage - (viewperpage - 1) / 2;
                endindex = currentpage + viewperpage / 2;
            }
        }
    }

    // 返回给客户的当前页的数据，转为JSON格式。
    public String toJSON() {
        String strJSON;
        strJSON = JSON.toJSONString(new PageData(totalrecordnumber, records));
        return strJSON;
    }

    // 为EasyUI DataGrid组件设计的类，提供表格中的数据。
    class PageData{
        public long total;               //数据的总条数
        public List <T> rows;       //在当前页需要显示的数据

        public PageData(long totalpagenumber, List<T> records){
            this.total = totalpagenumber;
            this.rows = records;
        }
    }
}
