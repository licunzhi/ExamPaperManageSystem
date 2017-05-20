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

    //��������Ĺ���  ���ݲ�ͬ��URLָ����ת��ͬ�Ľ���
    public String toAddQuestionPage() {
        String qtype = request.getParameter("qtype");
        session.put("qt", qtype);
        String pid = request.getParameter("pid");
        session.put("pid", pid);
        if (qtype.equals("��ѡ��")) {
            return "addsimplepage";
        } else if (qtype.equals("��ѡ��")) {
            return "addmulitypage";
        } else if (qtype.equals("�����")) {
            return "addblanksimpleanswertotalpage";
        } else if (qtype.equals("�ж���")) {
            return "addjudgepage";
        } else if (qtype.equals("�����")) {
            return "addblanksimpleanswertotalpage";
        } else if (qtype.equals("�ۺ���")) {
            return "addblanksimpleanswertotalpage";
        }
        return "input";
    }

    //ʵ�ʲ�������������̲���
    public String doAddQuestion() {
        System.err.println(model.getQoptions());
        String qid = request.getParameter("pid");
        Integer qqid = Integer.valueOf(qid);
        model.setPage(paperService.getEntity(qqid));
        paperService.saveEntity(model);
        return "toAddPageAction";
    }

    //ɾ��ָ����id���������
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
