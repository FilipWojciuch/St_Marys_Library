/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st_marys_library;

/**
 *
 * @author Phil
 */
public class BorrowRecord {

    public int recordId;
    public int bookId;
    public int memberId;
    public String borrowDate;
    public String dueDate;
    public String status;

    public BorrowRecord(int recordId, int bookId, int memberId,
                        String borrowDate, String dueDate,
                        String status) {

        this.recordId = recordId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.status = status;
    }
}
