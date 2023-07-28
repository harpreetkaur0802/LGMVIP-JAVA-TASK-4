import javax.swing.*;                 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class SimpleSearchEngine extends JFrame {
    private JTextField searchField;
    private JTextArea resultArea;                    
    private List<String> documents;
    public SimpleSearchEngine() {
        setTitle("SIMPLE SEARCH ENGINE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1000, 200);
        searchField = new JTextField();
        searchField.setFont(new Font("Georgia", Font.BOLD, 14));
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Gill Sans", Font.BOLD, 14));
        searchButton.addActionListener(new SearchButtonListener());
        resultArea = new JTextArea();
        resultArea.setFont(new Font("Georgia", Font.PLAIN, 16));
        resultArea.setEditable(false);
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);
        add(searchPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        documents = new ArrayList<>();
        documents.add("Google is a multinational technology company renowned for its search engine, Google Search, which has become synonymous with finding information on the internet. Founded in 1998 by Larry Page and Sergey Brin while they were Ph.D. students at Stanford University, Google has since expanded its offerings to include various products and services, such as Gmail, Google Maps, YouTube, and Google Drive. Today, Google remains a dominant force in the tech industry, continuously innovating and influencing the way people access and interact with information online.");
        documents.add("Cricket is a popular bat-and-ball sport played between two teams, each consisting of eleven players, with the objective of scoring runs and taking wickets to dismiss the opposing team. It is widely followed and cherished in many countries, particularly in South Asia, the United Kingdom, Australia, and the West Indies, and it has various formats, including Test matches, One-Day Internationals (ODIs), and Twenty20 (T20) cricket.");
        documents.add("Elon Musk is a visionary entrepreneur and innovator known for his leadership in founding and leading companies such as SpaceX, Tesla, and Neuralink, pushing the boundaries of technology and sustainability while pursuing ambitious goals, including space exploration, electric vehicles, and brain-computer interfaces.");
        documents.add("Lionel Messi, often considered one of the greatest football (soccer) players of all time, is an Argentine forward known for his incredible dribbling skills, goal-scoring prowess, and mesmerizing playmaking abilities, having spent the majority of his career with FC Barcelona before joining Paris Saint-Germain (PSG) in 2021.");
        documents.add("Narendra Modi, the Prime Minister of India, known for his strong leadership and policies aimed at economic growth, development, and social reforms in the country. However, please note that information might have changed since then, so it's essential to verify the latest details about any individual");
    }
    private class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String query = searchField.getText().toLowerCase();
            List<String> results = searchDocuments(query);
            displaySearchResults(results);
        }
        private List<String> searchDocuments(String query) {
            List<String> res = new ArrayList<>();
            for (String d : documents) {
                if (d.toLowerCase().contains(query)) {
                    res.add(d);
                }
            }
            return res;
        }
        private void displaySearchResults(List<String> results) {
            if (results.isEmpty()) {
                resultArea.setText("No data regarding this information was found");
            } else {
                StringBuilder a = new StringBuilder();
                for (String result : results) {
                    a.append(result).append("\n");
                }
                resultArea.setText(a.toString());
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleSearchEngine().setVisible(true);
            }
        });
    }
}
