/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st_marys_library;

/**
 *
 * @author Phil
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:sqlite:library.db";

    public static Connection connect() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL);

            createTables(conn);
            insertData(conn);

        } catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
        }

        return conn;
    }

    private static void createTables(Connection conn) {

        try (Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS books (" +
                "book_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "author TEXT NOT NULL," +
                "category TEXT NOT NULL," +
                "availability_status TEXT NOT NULL)"
            );

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS members (" +
                "member_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "member_name TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "membership_type TEXT NOT NULL)"
            );

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS borrow_records (" +
                "record_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "book_id INTEGER NOT NULL," +
                "member_id INTEGER NOT NULL," +
                "borrow_date TEXT NOT NULL," +
                "due_date TEXT NOT NULL," +
                "return_status TEXT NOT NULL)"
            );

        } catch (SQLException e) {
            System.out.println("Table Error: " + e.getMessage());
        }
    }

    private static void insertData(Connection conn) {

        try (Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM books");
            rs.next();

            if (rs.getInt("total") > 0) {
                return;
            }

            stmt.executeUpdate(
                "INSERT INTO books (title, author, category, availability_status) VALUES " +
                "('Introduction to Java', 'John Smith', 'Programming', 'Available')," +
                "('Database Systems', 'Maria Garcia', 'Computer Science', 'Borrowed')," +
                "('Software Engineering Principles', 'Alan Brown', 'Engineering', 'Available')"
            );

            stmt.executeUpdate(
                "INSERT INTO members (member_name, email, membership_type) VALUES " +
                "('Alice Johnson', 'alice.johnson@stmarys.ac.uk', 'Student')," +
                "('Michael Lee', 'michael.lee@stmarys.ac.uk', 'Staff')," +
                "('Sara Ahmed', 'sara.ahmed@stmarys.ac.uk', 'Student')"
            );

            stmt.executeUpdate(
                "INSERT INTO borrow_records (book_id, member_id, borrow_date, due_date, return_status) VALUES " +
                "(2,1,'2025-03-01','2025-03-15','Borrowed')," +
                "(1,2,'2025-03-02','2025-03-16','Returned')," +
                "(3,3,'2025-03-05','2025-03-19','Borrowed')"
            );

        } catch (SQLException e) {
            System.out.println("Sample Data Error: " + e.getMessage());
        }
    }
}
