

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TravelCurrencyConverterGUI extends JFrame {

    // creates an instance of the TravelCurrencyConverter
    TravelCurrencyConverter converter;

    //JLabel
    private JLabel country2;
    private JLabel languages;
    private JLabel amount;
    private JLabel flag;
    private JLabel convertedValue;

    // Image icon
    private ImageIcon image;

    //JComboBox
    private JComboBox country;
    private JComboBox language;

    // JButton
    private JButton calculate;
    private JButton reset;
    private JButton exit;

    // JTextfield
    private JTextField userInput;
    private JTextField displayResult;

    //JTextArea
    private JTextArea result;

    //JPanel
    private JPanel panel1;
    private JPanel panel2, panel3;

    public TravelCurrencyConverterGUI(){
        // set title
        setTitle("Travel Currency Converter @9ja Pikins");
        // set size
        setSize(350,250);

        // don't forget to close
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //builds panel
        buildPanel();
        // set Layout
        setLayout(new BorderLayout());
        // puts panel 1 in the North
        add(panel1, BorderLayout.NORTH);
        //puts panel2 in the center
        add(panel2, BorderLayout.CENTER);
        //puts panel3 in the south
        add(panel3, BorderLayout.SOUTH);
        //packs
        pack();
        // makes it visible
        setVisible(true);


    }// end of no agr constructor

    public void buildPanel(){
        // puts all the countries into a string
        String[] countries = {"Nigeria", "Japan", "Canada","Spain","Nepal","England"};

        //JComboBox
        country = new JComboBox(countries);
        country.addActionListener(new ComboBoxListener());

        converter = new TravelCurrencyConverter();
        language = new JComboBox(converter.language(String.valueOf(country.getSelectedItem())));

        //JLabel
        amount = new JLabel("Input Value (USD):");
        languages = new JLabel("Language:");
        country2 = new JLabel("Destination:");
        convertedValue = new JLabel("Converted Value:");


        // JTextField
        userInput = new JTextField(10);
        displayResult = new JTextField(10);
        displayResult.setEditable(false);

        // JButton
        calculate = new JButton("Calculate");
        calculate.setBackground(Color.GREEN);
        calculate.addActionListener(new ButtonListener());

        reset = new JButton("Reset");
        reset.setBackground(Color.WHITE);
        reset.addActionListener(new ButtonListener());

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.addActionListener(new ButtonListener());

        // JTextArea
        result = new JTextArea();
        result.setEditable(false);
        result.setText("Welcome to the Travel Currency Converter Application");
        result.setFont(new Font(Font.SERIF,Font.BOLD,17));

        // ImageIcon
        image = new ImageIcon(country.getSelectedItem().toString()+" Flag-CSASS.jpg");
        flag = new JLabel(image);

        //panel1
        panel1 = new JPanel();
        panel1.add(amount);
        panel1.add(userInput);
        panel1.add(country2);
        panel1.add(country);
        panel1.add(languages);
        panel1.add(language);

        //panel2
        panel2 = new JPanel();
        panel2.add(flag);
        panel2.add(result);
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));

        // panel 3
        panel3 = new JPanel();
        panel3.add(convertedValue);
        panel3.add(displayResult);
        panel3.add(calculate);
        panel3.add(reset);
        panel3.add(exit);

    }//end buildPanel

    // class for ComboBoxes
    private class ComboBoxListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            language.setModel(new DefaultComboBoxModel(converter.language(String.valueOf(country.getSelectedItem()))));
            image = new ImageIcon(country.getSelectedItem().toString()+" Flag-CSASS.jpg");
            flag.setIcon(image);
        }
    }//end of  ComboBoxListener

    //class for ButtonListener
    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==exit){
                System.exit(0);
            }
            if(e.getSource()==reset){
                result.setText("Welcome to the Travel Converter Application");
                userInput.setText("");
                displayResult.setText("");
                country.setSelectedIndex(0);
                language.setSelectedIndex(0);
            }
            else{
                String what =converter.message(Double.parseDouble(userInput.getText()),country.getSelectedItem().toString(),language.getSelectedItem().toString());
                result.setText(what);

                double convertedValue = converter.convertUserInput(Double.parseDouble(userInput.getText()),converter.convertCountry(country.getSelectedItem().toString()));
                displayResult.setText(String.valueOf(convertedValue));
            }
        }
    }
}//end class

