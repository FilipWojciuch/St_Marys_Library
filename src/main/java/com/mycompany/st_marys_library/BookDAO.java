/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st_marys_library;

/**
 *
 * @author Phil
 */
import java.sql.*;

public class BookDAO {

    public static void addBook(Book b) {

        String sql =
            "INSERT INTO books(title,author,category,availability_status) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, b.title);
            ps.setString(2, b.author);
            ps.setString(3, b.category);
            ps.setString(4, b.status);

            ps.executeUpdate();

            System.out.println("Book added successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewBooks() {

        String sql = "SELECT * FROM books";

        try (Connection conn = DBConnection.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println("\nBOOK ID: " + rs.getInt("book_id"));
                System.out.println("TITLE: " + rs.getString("title"));
                System.out.println("AUTHOR: " + rs.getString("author"));
                System.out.println("CATEGORY: " + rs.getString("category"));
                System.out.println("STATUS: " + rs.getString("availability_status"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateBook(Book b) {

        String sql =
            "UPDATE books SET title=?, author=?, category=?, availability_status=? WHERE book_id=?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, b.title);
            ps.setString(2, b.author);
            ps.setString(3, b.category);
            ps.setString(4, b.status);
            ps.setInt(5, b.bookId);

            ps.executeUpdate();

            System.out.println("Book updated successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteBook(int id) {

        String sql = "DELETE FROM books WHERE book_id=?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Book deleted successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}