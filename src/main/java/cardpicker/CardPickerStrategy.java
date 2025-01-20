package cardpicker;

import flashcard.FlashCard;

import java.util.List;

public interface CardPickerStrategy {
    FlashCard pickCard(List<FlashCard> cards);
}
