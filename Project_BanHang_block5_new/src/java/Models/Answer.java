
package Models;


public class Answer {
    private String user; 
    private int questionId;
    private String answer;

    public Answer() {
    }

    public Answer(String user, int questionId, String answer) {
        this.user = user;
        this.questionId = questionId;
        this.answer = answer;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" + "user=" + user + ", questionId=" + questionId + ", answer=" + answer + '}';
    }

   
}
