/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libsys.model;

import java.sql.*;

import DB.PostgreSQL;
import DB.CRUD;
import DB.Books;
import DB.User;
import DB.UserLibrary;

/**
 *
 * @author Renier
 */
public class LibSysModel {
    public ResultSet getUsers() {
        var conn = new PostgreSQL();
        var crud = new CRUD(conn);
        
        return crud.getUsers();
    }
    
    public ResultSet getBooks() {
        var conn = new PostgreSQL();
        var crud = new CRUD(conn);
        
        return crud.getBooks();
    }
    
    public void addBook(String title, int author) {
        var conn = new PostgreSQL();
        var crud = new CRUD(conn);
        
        crud.addBook(title, author);
    }
    
    public void editBook(int id, boolean avb) {
        var conn = new PostgreSQL();
        var crud = new CRUD(conn);
        
        crud.editBook(id, avb);
    }
    
    public void deleteBook(int id) {
        var conn = new PostgreSQL();
        var crud = new CRUD(conn);
        
        crud.deleteBook(id);
    }
    
    public void addUser(String name) {
        var conn = new PostgreSQL();
        var crud = new CRUD(conn);
        
        crud.addUser(name);
    }
    
    public void editUser(int id, int brw) {
        var conn = new PostgreSQL();
        var crud = new CRUD(conn);
        
        crud.editUser(id, brw);
    }
    
    public void deleteUser(int id) {
        var conn = new PostgreSQL();
        var crud = new CRUD(conn);
        
        crud.deleteUser(id);
    }
}
