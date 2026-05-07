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

public class MemberDAO {

    public static void addMember(Member m) {

        String sql =
            "INSERT INTO members(member_name,email,membership_type) VALUES(?,?,?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.name);
            ps.setString(2, m.email);
            ps.setString(3, m.type);

            ps.executeUpdate();

            System.out.println("Member added successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewMembers() {

        String sql = "SELECT * FROM members";

        try (Connection conn = DBConnection.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println("\nMEMBER ID: " + rs.getInt("member_id"));
                System.out.println("MEMBER NAME: " + rs.getString("member_name"));
                System.out.println("EMAIL: " + rs.getString("email"));
                System.out.println("MEMBERSHIP TYPE: " + rs.getString("membership_type"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateMember(Member m) {

        String sql =
            "UPDATE members SET member_name=?, email=?, membership_type=? WHERE member_id=?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.name);
            ps.setString(2, m.email);
            ps.setString(3, m.type);
            ps.setInt(4, m.memberId);

            ps.executeUpdate();

            System.out.println("Member updated successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteMember(int id) {

        String sql = "DELETE FROM members WHERE member_id=?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Member deleted successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
