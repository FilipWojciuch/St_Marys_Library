/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st_marys_library;

/**
 *
 * @author Phil
 */
public class Member {

    public int memberId;
    public String name;
    public String email;
    public String type;

    public Member(int memberId, String name,
                  String email, String type) {

        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.type = type;
    }
}
