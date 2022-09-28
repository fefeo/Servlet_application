package com.example.ztp_proj1.book;

import java.util.ArrayList;

public class Book {
    protected String title;
    protected String author;
    protected int year;

    public Book (String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toString(){
        return title+", "+author+", "+year;
    }

    public static ArrayList<String> FillExampleBooks(ArrayList list){
        list.add(new Book("Pamiętnik Pułku Jazdy Wołyńskiej", "Karol Różycki", 2022));
        list.add(new Book("Przygody Tomka Sawyera", "Mark Twain", 1876));
        list.add(new Book("Dzieci z Bullerbyn ", "Astrid Lindgren", 1947));
        return list;
    }
}
