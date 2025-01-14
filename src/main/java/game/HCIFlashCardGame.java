package game;

import file.CSVFileReader;
import file.FileReader;
import flashcard.FlashCard;
import ui.ButtonType;
import ui.FlashCardUI;
import ui.StandardFlashCardUI;

import java.util.List;
import java.util.Random;

public class HCIFlashCardGame implements FlashCardGame {

    private final int RANDOM_THRESHOLD = 20;

    private final FlashCardUI ui;
    private final Random rand;
    private List<FlashCard> cards;
    private FlashCard currentCard;

    public HCIFlashCardGame() {
        ui = new StandardFlashCardUI("HCI Flash Cards", this);
        rand = new Random();

        FileReader fileReader = new CSVFileReader();
        cards = fileReader.getCards();

        showNextQuestion();
    }


    @Override
    public void showNextQuestion() {
        int index = rand.nextInt(RANDOM_THRESHOLD);
        currentCard = cards.remove(index);
        cards.add(currentCard);

        ui.showQuestion(currentCard.getQuestion());
        ui.setSubject(currentCard.getSubject());
        ui.hideAnswer();
        ui.setButtonType(ButtonType.REVEAL);

    }

    @Override
    public void revealAnswer() {
        ui.showAnswer(currentCard.getAnswer());
        ui.setButtonType(ButtonType.NEXT);
    }
}
