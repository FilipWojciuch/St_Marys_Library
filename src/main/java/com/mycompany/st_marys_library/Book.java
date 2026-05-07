/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st_marys_library;

/**
 *
 * @author Phil
 */
public class Book {

    public int bookId;
    public String title;
    public String author;
    public String category;
    public String status;

    public Book(int bookId, String title, String author,
                String category, String status) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = status;
    }
}