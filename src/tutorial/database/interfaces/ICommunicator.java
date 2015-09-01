/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.database.interfaces;

import tutorial.model.Book;

/**
 *
 * @author Filippo-TheAppExpert
 */
public interface ICommunicator {

    public void saveBook(Book book);
    
    public void editBook(Book book);
}
