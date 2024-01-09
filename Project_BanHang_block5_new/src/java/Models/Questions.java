
package Models;


public class Questions {
    private int questionid;
    private String question;

    public Questions() {
    }

    public Questions(int questionid, String question) {
        this.questionid = questionid;
        this.question = question;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Questions{" + "questionid=" + questionid + ", question=" + question + '}';
    }

    
}
