package ui;

public interface FlashCardUI {
    void showQuestion(String question);
    void showAnswer(String answer);
    void hideAnswer();
    void setSubject(String subject);
    void setButtonType(ButtonType buttonType);


}
