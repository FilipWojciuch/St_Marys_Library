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

public class BorrowDAO {

    public static void addBorrow(BorrowRecord b) {

        String sql =
            "INSERT INTO borrow_records(book_id,member_id,borrow_date,due_date,return_status) VALUES(?,?,?,?,?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, b.bookId);
            ps.setInt(2, b.memberId);
            ps.setString(3, b.borrowDate);
            ps.setString(4, b.dueDate);
            ps.setString(5, b.status);

            ps.executeUpdate();

            System.out.println("Borrow record added successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewBorrowRecords() {

        String sql = "SELECT * FROM borrow_records";

        try (Connection conn = DBConnection.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println("\nRECORD ID: " + rs.getInt("record_id"));
                System.out.println("BOOK ID: " + rs.getInt("book_id"));
                System.out.println("MEMBER ID: " + rs.getInt("member_id"));
                System.out.println("BORROW DATE: " + rs.getString("borrow_date"));
                System.out.println("DUE DATE: " + rs.getString("due_date"));
                System.out.println("STATUS: " + rs.getString("return_status"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateBorrowRecord(BorrowRecord b) {

        String sql =
            "UPDATE borrow_records SET book_id=?, member_id=?, borrow_date=?, due_date=?, return_status=? WHERE record_id=?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, b.bookId);
            ps.setInt(2, b.memberId);
            ps.setString(3, b.borrowDate);
            ps.setString(4, b.dueDate);
            ps.setString(5, b.status);
            ps.setInt(6, b.recordId);

            ps.executeUpdate();

            System.out.println("Borrow record updated successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteBorrowRecord(int id) {

        String sql = "DELETE FROM borrow_records WHERE record_id=?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Borrow record deleted successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}