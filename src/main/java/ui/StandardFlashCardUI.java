package ui;

import flashcard.FlashCard;
import game.FlashCardGame;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StandardFlashCardUI implements FlashCardUI {

    private final String REVEAL_TEXT = "Reveal answer";
    private final String NEXT_TEXT = "Next question";

    private final JFrame frame;
    private final FlashCardGame game;
    private final Map<ButtonType, String> buttonTextMap;
    private JLabel subjectPanel, questionPanel, answerPanel;
    private JButton button;
    private ButtonType buttonState;

    public StandardFlashCardUI(String title, FlashCardGame game) {
        this.game = game;
        buttonTextMap = new HashMap<ButtonType, String>();
        buttonTextMap.put(ButtonType.REVEAL, REVEAL_TEXT);
        buttonTextMap.put(ButtonType.NEXT, NEXT_TEXT);
        frame = new JFrame(title);
        setupWindow();
    }

    private void setupWindow() {
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());

        // Top panel with text
        subjectPanel = new JLabel("Top Panel Text", JLabel.CENTER);
        content.add(subjectPanel, BorderLayout.NORTH);

        // Left panel with text
        questionPanel = new JLabel("Left Panel Text", JLabel.CENTER);
        questionPanel.setPreferredSize(new Dimension(300, 300));
        questionPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        content.add(questionPanel, BorderLayout.WEST);

        // Right panel with text
        answerPanel = new JLabel("Right Panel Text", JLabel.CENTER);
        answerPanel.setPreferredSize(new Dimension(300, 300));
        questionPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        content.add(answerPanel, BorderLayout.EAST);

        // Button in the center
        button = new JButton("Center Button");
        button.addActionListener(e -> onButtonClicked());
        content.add(button, BorderLayout.CENTER);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void onButtonClicked() {
        switch (buttonState) {
            case REVEAL -> {
                game.revealAnswer();
            }
            case NEXT -> {
                game.showNextQuestion();
            }
        }
    }


    @Override
    public void showQuestion(String question) {
        questionPanel.setText("<html>Q: " + question + "</html>");
    }

    @Override
    public void showAnswer(String answer) {
        answerPanel.setText("<html>A: " + answer + "</html>");
    }

    @Override
    public void hideAnswer() {
        answerPanel.setText("<html>A: (hidden)</html>");
    }

    @Override
    public void setSubject(String subject) {
        subjectPanel.setText("<html><h1>" + subject + "</h1></html>");
    }

    @Override
    public void setButtonType(ButtonType buttonType) {
        buttonState = buttonType;
        button.setText("<html>" + buttonTextMap.get(buttonType) + "</html>");
    }
}
