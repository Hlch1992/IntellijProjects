/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10;

/**
 *
 * @author Hlch1
 */
public class PayableInterfaceTest
{
    public PayableInterfaceTest()
    {
        Payable[] payableObjects = new Payable[4];
        
        payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
        payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
        payableObjects[2] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
        payableObjects[3] = new SalariedEmployee("Lisa", "Barnes", "888-88-8888", 1200.00);
        
        System.out.println("Invoices and Employees processed polymorphically:");
        
        for (Payable currentPayable : payableObjects)
        {
            System.out.printf("%n%s %n%s: $%,.2f%n",currentPayable.toString(), "payment due", currentPayable.getPaymentAmount());
        }
    }
}
