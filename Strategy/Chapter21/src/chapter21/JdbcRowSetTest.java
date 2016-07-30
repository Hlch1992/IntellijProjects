/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter21;

/**
 *
 * @author Hlch1
 */
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetTest
{
    private static final String DATABASE_URL = "jdbc:derby:c:\\Users\\Hlch1\\Documents\\examples\\ch21\\books_examples\\books";
    private static final String USERNAME = "deitel";
    private static final String PASSWORD = "deitel";
    
    public JdbcRowSetTest()
    {
        try(JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet())
        {
            rowSet.setUrl(DATABASE_URL);
            rowSet.setUsername(USERNAME);
            rowSet.setPassword(PASSWORD);
            rowSet.setCommand("SELECT * FROM Authors");
            rowSet.execute();
            
            ResultSetMetaData metaData = rowSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.printf("Authors Table of Books Database:%n%n");
            
            for (int i = 1; i <= numberOfColumns; i++)
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            System.out.println();
            
            while (rowSet.next())
            {
                for (int i = 1; i <= numberOfColumns; i++)
                    System.out.printf("%-8s\t", rowSet.getObject(i));
                System.out.println();
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }
}
