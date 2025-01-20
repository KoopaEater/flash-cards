package file;

import flashcard.FlashCard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FilteredFileReaderDecorator implements FileReader{

    private FileReader fileReader;
    List<FlashCard> filteredCards;

    public FilteredFileReaderDecorator(FileReader fileReader, List<String> subjectsToFilter) {
        this.fileReader = fileReader;
        filteredCards = fileReader.getCards().stream().filter(
                card -> subjectsToFilter.contains(card.getSubject())
        ).toList();
        filteredCards = new LinkedList<FlashCard>(filteredCards);
    }

    @Override
    public List<FlashCard> getCards() {
        return filteredCards;
    }
}
