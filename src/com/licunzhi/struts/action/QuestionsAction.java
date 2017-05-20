package com.licunzhi.struts.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.licunzhi.model.Questions;
import com.licunzhi.service.PaperService;
import com.opensymphony.xwork2.Action;

@Controller
@Scope("prototype")
public class QuestionsAction extends BaseAction<Questions> implements SessionAware, Action {

    private static final long serialVersionUID = 1L;

    @Resource(name = "paperService")
    private PaperService paperService;

    private HttpServletRequest request = ServletActionContext.getRequest();

    private Map<String, Object> session;

    //增加试题的过程  根据不同的URL指定跳转不同的界面
    public String toAddQuestionPage() {
        String qtype = request.getParameter("qtype");
        session.put("qt", qtype);
        String pid = request.getParameter("pid");
        session.put("pid", pid);
        if (qtype.equals("单选题")) {
            return "addsimplepage";
        } else if (qtype.equals("多选题")) {
            return "addmulitypage";
        } else if (qtype.equals("填空题")) {
            return "addblanksimpleanswertotalpage";
        } else if (qtype.equals("判断题")) {
            return "addjudgepage";
        } else if (qtype.equals("简答题")) {
            return "addblanksimpleanswertotalpage";
        } else if (qtype.equals("综合题")) {
            return "addblanksimpleanswertotalpage";
        }
        return "input";
    }

    //实际操作增加问题过程操作
    public String doAddQuestion() {
        System.err.println(model.getQoptions());
        String qid = request.getParameter("pid");
        Integer qqid = Integer.valueOf(qid);
        model.setPage(paperService.getEntity(qqid));
        paperService.saveEntity(model);
        return "toAddPageAction";
    }

    //删除指定的id的问题对象
    public String doDeleteQuestion() {
        String questionid = request.getParameter("id");
        Integer quesid = Integer.valueOf(questionid);
        paperService.deleteQuestionsEntity(quesid);
        return "toAddPageAction";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
