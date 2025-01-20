package cardpicker;

import flashcard.FlashCard;

import java.util.List;
import java.util.Random;

public class RandomFirstThirdCardPickerStrategy implements CardPickerStrategy {
    private final Random rand;
    public RandomFirstThirdCardPickerStrategy() {
        rand = new Random();
    }
    @Override
    public FlashCard pickCard(List<FlashCard> cards) {
        int maxIndex = (int) Math.ceil((double) cards.size() / 3);
        return cards.get(rand.nextInt(maxIndex));
    }
}
