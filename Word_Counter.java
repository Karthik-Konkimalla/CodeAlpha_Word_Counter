import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Word_Counter extends JFrame {
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JButton countButton;

    public Word_Counter() {
        createUI();
    }

    private void createUI() {
        // Set the frame properties
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        textArea = new JTextArea();
        wordCountLabel = new JLabel("Word Count: 0");
        countButton = new JButton("Count Words");

        // Add action listener to the button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        // Layout setup
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.add(wordCountLabel, BorderLayout.WEST);
        southPanel.add(countButton, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void countWords() {
        String text = textArea.getText();
        if (text.trim().isEmpty()) {
            wordCountLabel.setText("Word Count: 0");
        } else {
            String[] words = text.trim().split("\\s+");
            wordCountLabel.setText("Word Count: " + words.length);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Word_Counter().setVisible(true);
            }
        });
    }
}