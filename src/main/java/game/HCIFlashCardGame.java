package game;

import file.CSVFileReader;
import file.FileReader;

public class HCIFlashCardGame implements FlashCardGame {

    public HCIFlashCardGame() {
        FileReader fileReader = new CSVFileReader();
        System.out.println(fileReader.getCards());
    }



}
