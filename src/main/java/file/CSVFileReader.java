package file;

import flashcard.FlashCard;
import flashcard.StandardFlashCard;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CSVFileReader implements FileReader {

    private List<FlashCard> cards;

    public CSVFileReader() {
        cards = new LinkedList<FlashCard>();
        readCards();
    }

    private void readCards() {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("cards.csv")) {

            if (stream == null) {
                System.out.println("No CSV file found");
                return;
            }
            Scanner scanner = new Scanner(stream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] cells = line.split(";");
                FlashCard card = new StandardFlashCard(cells[1], cells[2], cells[0]);
                cards.add(card);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<FlashCard> getCards() {
        return cards;
    }
}
