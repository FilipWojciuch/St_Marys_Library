/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st_marys_library;

/**
 *
 * @author Phil
 */
import java.util.Scanner;

public class St_marys_library {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== ST MARY'S LIBRARY SYSTEM =====");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");

            System.out.println("5. Add Member");
            System.out.println("6. View Members");
            System.out.println("7. Update Member");
            System.out.println("8. Delete Member");

            System.out.println("9. Add Borrow Record");
            System.out.println("10. View Borrow Records");
            System.out.println("11. Update Borrow Record");
            System.out.println("12. Delete Borrow Record");

            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("Enter Title:");
                    String title = sc.nextLine();

                    System.out.println("Enter Author:");
                    String author = sc.nextLine();

                    System.out.println("Enter Category:");
                    String category = sc.nextLine();

                    System.out.println("Enter Status:");
                    String status = sc.nextLine();

                    BookDAO.addBook(
                        new Book(0, title, author, category, status)
                    );

                    break;

                case 2:

                    BookDAO.viewBooks();

                    break;

                case 3:

                    System.out.println("Enter Book ID:");
                    int bid = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter New Title:");
                    String nt = sc.nextLine();

                    System.out.println("Enter New Author:");
                    String na = sc.nextLine();

                    System.out.println("Enter New Category:");
                    String nc = sc.nextLine();

                    System.out.println("Enter New Status:");
                    String ns = sc.nextLine();

                    BookDAO.updateBook(
                        new Book(bid, nt, na, nc, ns)
                    );

                    break;

                case 4:

                    System.out.println("Enter Book ID to delete:");
                    int dbid = sc.nextInt();

                    BookDAO.deleteBook(dbid);

                    break;

                case 5:

                    System.out.println("Enter Member Name:");
                    String mn = sc.nextLine();

                    System.out.println("Enter Email:");
                    String em = sc.nextLine();

                    System.out.println("Enter Membership Type:");
                    String mt = sc.nextLine();

                    MemberDAO.addMember(
                        new Member(0, mn, em, mt)
                    );

                    break;

                case 6:

                    MemberDAO.viewMembers();

                    break;

                case 7:

                    System.out.println("Enter Member ID:");
                    int mid = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter New Name:");
                    String nn = sc.nextLine();

                    System.out.println("Enter New Email:");
                    String ne = sc.nextLine();

                    System.out.println("Enter New Membership Type:");
                    String nmt = sc.nextLine();

                    MemberDAO.updateMember(
                        new Member(mid, nn, ne, nmt)
                    );

                    break;

                case 8:

                    System.out.println("Enter Member ID to delete:");
                    int dmid = sc.nextInt();

                    MemberDAO.deleteMember(dmid);

                    break;

                case 9:

                    System.out.println("Enter Book ID:");
                    int bbid = sc.nextInt();

                    System.out.println("Enter Member ID:");
                    int mmid = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter Borrow Date:");
                    String bd = sc.nextLine();

                    System.out.println("Enter Due Date:");
                    String dd = sc.nextLine();

                    System.out.println("Enter Status:");
                    String st = sc.nextLine();

                    BorrowDAO.addBorrow(
                        new BorrowRecord(0, bbid, mmid, bd, dd, st)
                    );

                    break;

                case 10:

                    BorrowDAO.viewBorrowRecords();

                    break;

                case 11:

                    System.out.println("Enter Record ID:");
                    int rid = sc.nextInt();

                    System.out.println("Enter Book ID:");
                    int rbid = sc.nextInt();

                    System.out.println("Enter Member ID:");
                    int rmid = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter Borrow Date:");
                    String rbd = sc.nextLine();

                    System.out.println("Enter Due Date:");
                    String rdd = sc.nextLine();

                    System.out.println("Enter Status:");
                    String rst = sc.nextLine();

                    BorrowDAO.updateBorrowRecord(
                        new BorrowRecord(rid, rbid, rmid, rbd, rdd, rst)
                    );

                    break;

                case 12:

                    System.out.println("Enter Record ID to delete:");
                    int drid = sc.nextInt();

                    BorrowDAO.deleteBorrowRecord(drid);

                    break;

                case 0:

                    System.out.println("Exiting System...");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}