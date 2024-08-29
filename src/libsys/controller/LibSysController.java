/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libsys.controller;

import java.sql.ResultSet;

import DB.PostgreSQL;
import DB.CRUD;

import libsys.model.LibSysModel;

/**
 *
 * @author Renier
 */
public class LibSysController {
    private final LibSysModel model;

    public LibSysController() {
        this.model = new LibSysModel();
    }
    
    public ResultSet getUsers() {
        return this.model.getUsers();
    }
    
    public ResultSet getBooks() {
        return this.model.getBooks();
    }
    
    public void addBook(String title, String author){
        try{
            var authorID = Integer.parseInt(author, 10);
            this.model.addBook(title, authorID);
        } catch (NumberFormatException err) { return; }
    }
    
    public void editBook(String id, String available){
        this.model.editBook(Integer.parseInt(id), Boolean.parseBoolean(available));
    }
    
    public void deleteBook(String id) {
        this.model.deleteBook(Integer.parseInt(id));
    }
    
    public void addUser(String name) {
        this.model.addUser(name);
    }
    
    public void editUser(String id, String brw) {
        this.model.editUser(Integer.parseInt(id), Integer.parseInt(brw));
    }
    
    public void deleteUser(String id) {
        this.model.deleteUser(Integer.parseInt(id));
    }
}
