package flashcard;

public class StandardFlashCard implements FlashCard {
    private final String question, answer, subject;
    public StandardFlashCard(String question, String answer, String subject) {
        this.question = question;
        this.answer = answer;
        this.subject = subject;
    }


    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Q: " + question + "|A: " + answer + "|Subject: " + subject;
    }
}
