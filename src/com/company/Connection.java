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
//                document.text().contains("This disambiguation page lists articles about people with the same name. " +
//                        "If an internal link led you here, you may wish to change the link to point directly to the intended article.")) {
//
//        }

        if (!document.text().contains("NHL") && !document.text().contains("ice hockey") && !document.text().contains("Playing career")){
            throw new NullPageException();
        } else {
            document = Jsoup.connect(MakeURL.makeNewURLWithIceHockey(completedURL)).get();
        }

        return document;
    }
}