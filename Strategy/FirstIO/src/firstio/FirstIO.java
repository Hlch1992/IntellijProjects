/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstio;


import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 *
 * @author Hlch1
 */
public class FirstIO 
{
    private static Scanner input;
    private static Formatter output;
    private static String[] file;
    
    public static void openFile()
    {
        try
        {
            input = new Scanner(Paths.get("c:/Users/Hlch1/ReadInThisFile.txt"));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }
    
    public static void readRecords()
    {
        
        try
        {
            for(int count=1; count<=4;count++)
                file[count]=input.nextLine();
            
        }
        catch (NoSuchElementException elementException)
        {
            System.err.println("File imporperly formed. Terminating.");
        }
        catch (IllegalStateException stateException)
        {
            System.err.println("Error reading from file. Terminating.");
        }
    }
    
    public static void closeFile()
    {
        if (input != null)
            input.close();
    }
       
    
    
    public static void openWriteFile()
    {
        try
        {
            output = new Formatter("c:/Users/Hlch1/WriteThisFile.txt");
        }
        catch (SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }
    
    public static void addRecords()
    {
                
        for (int count = 1; count <=4; count++)
        {
            try
            {
                output.format(file[count]);
            }
            catch (FormatterClosedException formatterCloseException)
            {
                System.err.println("Error writing to file. Terminating.");
                break;
            }
            catch (NoSuchElementException elementException)
            {
                System.err.println("Invalid input. Please try again.");
                input.nextLine();
            }
            System.out.print("? ");
        }
    }
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        openFile();
        readRecords();
        closeFile();
        openWriteFile();
        addRecords();
        closeFile();
    }
    
}
