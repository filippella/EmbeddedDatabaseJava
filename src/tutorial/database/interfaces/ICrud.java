/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.database.interfaces;

import java.util.ArrayList;
import tutorial.model.Book;

/**
 *
 * @author Filippo-TheAppExpert
 */
public interface ICrud {
    
    public void addBook(Book boook);
    
    public void removeBook(String keyword);
    
    public ArrayList<Book> getAllBooks();
    
    public void updateBook(Book book);
    
    public boolean search(String keyword);
    
}
