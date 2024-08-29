package DB;

import DB.DatabaseConnection;
import DB.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {
    private DatabaseConnection connection;

    public CRUD(DatabaseConnection connection) {
        this.connection = connection;
    }

    // Insert methods for adding data to the database

    /**
     * Adds a new User to the `public.users` table.
     *
     * @param name Name of the user to be inserted.
     */
    public void addUser(String name) {
        String sql = """
                INSERT INTO public."user" (name)
                VALUES (?);
                """;
        
        Connection conn;
        
        try {
            conn = this.connection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, name);
            pstmt.executeUpdate(); // Run the SQL command to insert the user
            
            conn.close();
        } 
        catch (SQLException err)
        {
            err.printStackTrace();
        }
    }
    
    public void editUser(int id, int brw) {
        String query = "UPDATE public.\"user\" SET borrowing=? WHERE id=?";
        
        Connection conn;
        
        try {
            conn = this.connection.connect();
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, brw);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            
            conn.close();
        } 
        catch (SQLException err)
        {
            err.printStackTrace();
        }
    }
    
    public void deleteUser(int id) {
        String query = "DELETE FROM public.\"user\" WHERE id=?";
        
        Connection conn;
        
        try {
            conn = this.connection.connect();
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            
            conn.close();
        } 
        catch (SQLException err)
        {
            err.printStackTrace();
        }
    }
    
    public void addBook(String title, int author) {
        String query = "INSERT INTO public.book(title, author) VALUES (?, ?)";
        
        Connection conn;
        
        try {
            conn = this.connection.connect();
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, title);
            pstmt.setInt(2, author);
            pstmt.executeUpdate();
            
            conn.close();
        } 
        catch (SQLException err)
        {
            err.printStackTrace();
        }
    }
    
    public void editBook(int id, boolean avb){
        String query = "UPDATE public.\"book\" SET available=? WHERE id=?";
        
        Connection conn;
        
        try {
            conn = this.connection.connect();
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setBoolean(1, avb);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            
            conn.close();
        } 
        catch (SQLException err)
        {
            err.printStackTrace();
        }
    }
    
    public void deleteBook(int id) {
        String query = "DELETE FROM public.\"book\" WHERE id=?";
        
        Connection conn;
        
        try {
            conn = this.connection.connect();
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            
            conn.close();
        } 
        catch (SQLException err)
        {
            err.printStackTrace();
        }
    }
    
    public ResultSet getUsers() {
        String query = "SELECT id, name, borrowing FROM public.\"user\" ORDER BY id";
        
        Connection conn;
        
        try {
            conn = this.connection.connect();
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            var res = pstmt.executeQuery();
            
            conn.close();
            
            return res;
        } 
        catch (SQLException err)
        {
            err.printStackTrace();
        }
        
        return null;
    }
    
    public ResultSet getBooks() {
        String query = "SELECT * FROM public.\"book\" ORDER BY id";
        
        Connection conn;
        
        try {
            conn = this.connection.connect();
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            var res = pstmt.executeQuery();
            
            conn.close();
            
            return res;
        } 
        catch (SQLException err)
        {
            err.printStackTrace();
        }
        
        return null;
    }
}
