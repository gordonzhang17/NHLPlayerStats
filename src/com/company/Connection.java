package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Connection {

    public static Document connect(String completedURL) throws IOException {
        Document document = null;
        try {
            document = Jsoup.connect(completedURL).get();
        } catch (IOException ioe) {
            System.out.println("Invalid Name");
            ioe.printStackTrace();
        }
        return document;
    }
}