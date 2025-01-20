package game;

import cardpicker.CardPickerStrategy;
import cardpicker.RandomFirstThirdCardPickerStrategy;
import file.CSVFileReader;
import file.FileReader;
import file.FilteredFileReaderDecorator;
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
    private final CardPickerStrategy cardPickerStrategy;
    private List<FlashCard> cards;
    private FlashCard currentCard;

    public HCIFlashCardGame() {
        ui = new StandardFlashCardUI("HCI Flash Cards", this);
        rand = new Random();
        cardPickerStrategy = new RandomFirstThirdCardPickerStrategy();

        FileReader fileReader = new FilteredFileReaderDecorator(new CSVFileReader(), List.of("Understanding People 1: Perception, Cognition and Motor Skills"));
        cards = fileReader.getCards();

        showNextQuestion();
    }


    @Override
    public void showNextQuestion() {
        currentCard = cardPickerStrategy.pickCard(cards);
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
