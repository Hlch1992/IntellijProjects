/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter20;

/**
 *
 * @author Hlch1
 */
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutionException;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class FindPrimes extends JFrame
{

    private final JTextField highestPrimeJTextField = new JTextField();
    private final JButton getPrimesJButton = new JButton("Get Primes");
    private final JTextArea displayPrimesJTextArea = new JTextArea();
    private final JButton cancelJButton = new JButton("Cancel");
    private final JProgressBar progressJProgressBar = new JProgressBar();
    private final JLabel statusJLabel = new JLabel();
    private PrimeCalculator calculator;

    // constructor
    public FindPrimes()
    {
        super("Finding Primes with SwingWorker");
        setLayout(new BorderLayout());

        // initialize panel to get a number from the user
        JPanel northJPanel = new JPanel();
        northJPanel.add(new JLabel("Find primes less than: "));
        highestPrimeJTextField.setColumns(5);
        northJPanel.add(highestPrimeJTextField);
        getPrimesJButton.addActionListener(
                new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                progressJProgressBar.setValue(0); // reset JProgressBar
                displayPrimesJTextArea.setText(""); // clear JTextArea
                statusJLabel.setText(""); // clear JLabel

                int number; // search for primes up through this value

                try
                {
                    // get user input
                    number = Integer.parseInt(
                            highestPrimeJTextField.getText());
                } catch (NumberFormatException ex)
                {
                    statusJLabel.setText("Enter an integer.");
                    return;
                }

                // construct a new PrimeCalculator object                 
                calculator = new PrimeCalculator(number,
                        displayPrimesJTextArea, statusJLabel, getPrimesJButton,
                        cancelJButton);

                // listen for progress bar property changes              
                calculator.addPropertyChangeListener(
                        new PropertyChangeListener()
                {
                    public void propertyChange(PropertyChangeEvent e)
                    {
                        // if the changed property is progress,         
                        // update the progress bar                      
                        if (e.getPropertyName().equals("progress"))
                        {
                            int newValue = (Integer) e.getNewValue();
                            progressJProgressBar.setValue(newValue);
                        }
                    }
                } // end anonymous inner class                        
                ); // end call to addPropertyChangeListener              

                // disable Get Primes button and enable Cancel button
                getPrimesJButton.setEnabled(false);
                cancelJButton.setEnabled(true);

                calculator.execute(); // execute the PrimeCalculator object 
            }
        } // end anonymous inner class
        ); // end call to addActionListener
        northJPanel.add(getPrimesJButton);

        // add a scrollable JList to display results of calculation
        displayPrimesJTextArea.setEditable(false);
        add(new JScrollPane(displayPrimesJTextArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));

        // initialize a panel to display cancelJButton,
        // progressJProgressBar, and statusJLabel
        JPanel southJPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        cancelJButton.setEnabled(false);
        cancelJButton.addActionListener(
                new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                calculator.cancel(true); // cancel the calculation 
            }
        } // end anonymous inner class
        ); // end call to addActionListener
        southJPanel.add(cancelJButton);
        progressJProgressBar.setStringPainted(true);
        southJPanel.add(progressJProgressBar);
        southJPanel.add(statusJLabel);

        add(northJPanel, BorderLayout.NORTH);
        add(southJPanel, BorderLayout.SOUTH);
        setSize(350, 300);
        setVisible(true);
    }
}
