package com.licunzhi.model;

import com.licunzhi.tools.StringUtil;

/**
 * 题库显示的信息
 *
 * @author LiCunzhi
 */
public class Questions {
    private Integer id;
    private String qtype;
    private String qtitle;

    private String qoptions;
    private String[] qoptionsAttr;//属性的开始就要被初始化才可以存储

    private String qanswer;
    private Page page;

    public Questions() {
        // TODO Auto-generated constructor stub
    }

    public Questions(Integer id, String qtype, String qtitle, String qoptions, String[] qoptionsAttr, String qanswer,
                     Page page) {
        super();
        this.id = id;
        this.qtype = qtype;
        this.qtitle = qtitle;
        this.qoptions = qoptions;
        this.qoptionsAttr = qoptionsAttr;
        this.qanswer = qanswer;
        this.page = page;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    public String getQtitle() {
        return qtitle;
    }

    public void setQtitle(String qtitle) {
        this.qtitle = qtitle;
    }

    public String getQoptions() {
        return qoptions;
    }

    public void setQoptions(String qoptions) {
        this.qoptions = qoptions;
        this.qoptionsAttr = StringUtil.removeSd(qoptions);
    }

    public void setQoptionsAttr(String[] qoptionsAttr) {
        this.qoptionsAttr = qoptionsAttr;
    }

    public String[] getQoptionsAttr() {
        return qoptionsAttr;
    }

    public String getQanswer() {
        return qanswer;
    }

    public void setQanswer(String qanswer) {
        this.qanswer = qanswer;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Questions [id=" + id + ", qtype=" + qtype + ", qtitle=" + qtitle
                + ", qoptions=" + qoptions + ", qanswer=" + qanswer + ", page=" + page + "]";
    }


}
