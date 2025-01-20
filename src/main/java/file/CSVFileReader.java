package file;

import flashcard.FlashCard;
import flashcard.StandardFlashCard;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CSVFileReader implements FileReader {

    private final DeHTMLifier deHTMLifier;
    private List<FlashCard> cards;

    public CSVFileReader() {
        deHTMLifier = new StandardDeHTMLifier();
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
                String question = deHTMLifier.deHTMLify(cells[1].trim());
                String answer = deHTMLifier.deHTMLify(cells[2].trim());
                String subject = deHTMLifier.deHTMLify(cells[0].trim());
                FlashCard card = new StandardFlashCard(question, answer, subject);
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
