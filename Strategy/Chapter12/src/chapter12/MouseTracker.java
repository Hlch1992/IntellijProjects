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
import javax.swing.JFrame;

public class MouseTracker
{
    public static void main(String[] args)
    {
        MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
        mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mouseTrackerFrame.setSize(300,120);
        mouseTrackerFrame.setVisible(true);
    }
}
