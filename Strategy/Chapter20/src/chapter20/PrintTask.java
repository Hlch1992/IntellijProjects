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
import java.security.SecureRandom;

public class PrintTask implements Runnable
{

    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime;
    private final String taskName;

    public PrintTask(String taskName)
    {
        this.taskName = taskName;
        
        sleepTime = generator.nextInt(5000);
    }
    
    public void run()
    {
        try
        {
            System.out.printf("%s going to sleep for %d milliseconds.%n", taskName, sleepTime);
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException exception)
        {
            exception.printStackTrace();
            Thread.currentThread().interrupt();
        }
        
        System.out.printf("%s done sleeping%n", taskName);
    }
}
