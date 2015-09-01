/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tutorial.database.interfaces.ICrud;
import tutorial.model.Book;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class DatabaseManager implements ICrud {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/bookDB";
    private static final String DB_USERNAME = "test";
    private static final String DB_PASSWORD = "test";
    private Connection connection;
    private Statement stmt;

    private static final String CREATE_TABLE = "CREATE TABLE BOOKS "
            + "(bookid bigint auto_increment NOT NULL PRIMARY KEY, "
            + " booktitle VARCHAR(255), "
            + " bookauthor VARCHAR(255), "
            + " editiondate VARCHAR(255))";

    public DatabaseManager() {
        openConnection();
    }

    public void openConnection() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            stmt = connection.createStatement();
            stmt.execute(CREATE_TABLE);
        } catch (Exception ex) {
        }
    }

    @Override
    public void addBook(Book boook) {
        try {
            String sql = "INSERT INTO BOOKS (booktitle, bookauthor, editiondate) VALUES ('" + boook.getBookTitle() + "',"
                    + " '" + boook.getBookAuthor() + "', '" + boook.getEditionDate() + "')";
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeBook(String keyword) {
        try {
            String sql = "DELETE FROM BOOKS  where bookid =  '" + keyword + "'";
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();

        try {
            String sql = "SELECT * FROM BOOKS";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString("bookid"));
                book.setBookTitle(rs.getString("booktitle"));
                book.setBookAuthor(rs.getString("bookauthor"));
                book.setEditionDate(rs.getString("editiondate"));
                books.add(book);
            }
            return books;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }

    @Override
    public void updateBook(Book book) {
        try {
            String sql = "UPDATE BOOKS set booktitle = '" + book.getBookTitle() + "', bookauthor = '" + book.getBookAuthor() + "',"
                    + " editiondate = '" + book.getEditionDate() + "' where bookid =  '" + book.getBookId() + "'";
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean search(String keyword) {
        try {
            String sql = "SELECT * FROM BOOKS WHERE bookid = '" + keyword + "'";
            ResultSet rs = stmt.executeQuery(sql);
            int size = 0;
            if (rs != null) {
                rs.beforeFirst();
                rs.last();
                size = rs.getRow();
            }

            return size > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
