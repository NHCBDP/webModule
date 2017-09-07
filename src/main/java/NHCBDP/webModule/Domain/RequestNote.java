package NHCBDP.webModule.Domain;

/**
 * @author wbliu
 * @create 2017-09-07 11:25
 **/


public class RequestNote {
    String  formId;
    String  requestName;
    String  requestUserId;
    String  companyName;
    String  illustration;
    String  content;
    int  status;
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getRequestUserId() {
        return requestUserId;
    }

    public void setRequestUserId(String requestUserId) {
        this.requestUserId = requestUserId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIllustration() {
        return illustration;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "RequestNote{" +
                "formId='" + formId + '\'' +
                ", requestName='" + requestName + '\'' +
                ", requestUserId='" + requestUserId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", illustration='" + illustration + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", userName='" + userName + '\'' +
                '}';
    }
}
