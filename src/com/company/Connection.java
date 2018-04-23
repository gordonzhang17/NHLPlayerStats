package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Connection {

    public static Document connect(String completedURL) throws IOException {

        Document document;

        try {
            // this try/catch block is for the jsoup connect function
            document = Jsoup.connect(completedURL).get();
        } catch (IOException e) {
            throw new NullPageException();
        }

        if (document.text().contains("Wikipedia does not have an article with this exact name.")) {
            throw new NullPageException();
        }

        if (!document.text().contains("NHL") && !document.text().contains("ice hockey")
                && !document.text().contains("Shoots")){
            throw new NullPageException();
        } else {
            document = Jsoup.connect(MakeURL.makeNewURLWithIceHockey(completedURL)).get();
        }

        return document;
    }
}