/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter7;

/**
 *
 * @author Hlch1
 */
public class Barchart
{
    public static void main(String[] args)
    {
        int[] array = { 0, 0, 0, 0, 0, 0, 1, 2, 4, 2, 1 };
        
        System.out.println("Grade distribution:");
        
        for (int counter = 0; counter < array.length; counter++)
        {
            if (counter == 10)
                System.out.printf("%5d: ", 100);
            else
                System.out.printf("%02d-%02d: ", counter * 10, counter * 10 + 9);
            
            for (int stars = 0; stars < array[counter]; stars++)
                System.out.print("*");
            
            System.out.println();
        }
    }
}
