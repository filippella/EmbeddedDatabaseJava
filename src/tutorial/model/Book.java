/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.model;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class Book {
    
    private String bookId, bookTitle, bookAuthor, editionDate;

    /**
     * @return the bookId
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    /**
     * @return the bookTitle
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * @param bookTitle the bookTitle to set
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * @return the bookAuthor
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * @param bookAuthor the bookAuthor to set
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    /**
     * @return the editionDate
     */
    public String getEditionDate() {
        return editionDate;
    }

    /**
     * @param editionDate the editionDate to set
     */
    public void setEditionDate(String editionDate) {
        this.editionDate = editionDate;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + "\nBook Title: " + bookTitle + "\nBook Author: " + bookAuthor + "\nEdition Date: " + editionDate;
    }

}
