/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12;

/**
 *
 * @author Hlch1
 */
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultipleSelectionFrame extends JFrame
{
    private final JList<String> colorJList;
    private final JList<String> copyJList;
    private JButton copyJButton;
    private static final String[] colorNames = {"Black", "Blue", "Cyan", "Dark Gray", "Gray",
        "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
    
    public MultipleSelectionFrame()
    {
        super("Multiple Selection List");
        setLayout(new FlowLayout());
        
        colorJList = new JList<String>(colorNames);
        colorJList.setVisibleRowCount(5);
        colorJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(colorJList));
        
        copyJButton = new JButton("Copy >>>");
        copyJButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                copyJList.setListData(colorJList.getSelectedValuesList().toArray(new String[0]));
            }
        });
        
        add(copyJButton);
        
        copyJList = new JList<String>();
        copyJList.setVisibleRowCount(5);
        copyJList.setFixedCellWidth(100);
        copyJList.setFixedCellHeight(15);
        copyJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add(new JScrollPane(copyJList));
    }
}
