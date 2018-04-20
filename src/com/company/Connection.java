package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Connection {

    public static Document connect(String completedURL) throws NullPageException, IOException {

        Document document;

        try {
            document = Jsoup.connect(completedURL).get();
            System.out.println("first");
        } catch (IOException e) {
            throw new NullPageException();
        }

        if (document.text().contains("Wikipedia does not have an article with this exact name.")) {
            // try to connect with new URL
            System.out.println(document.outerHtml());
            document = Jsoup.connect(MakeURL.makeNewURLWithIceHockey(completedURL)).get();
            if (document.text().contains("Wikipedia does not have an article with this exact name.")) {
                throw new NullPageException();
            }
            System.out.println("1here");
            else return document;
        } else
            System.out.println("2here");
            return document;
    }
}

//            }
//        } catch (NullPointerException e) {
//            document = connect(MakeURL.makeNewURLWithIceHockey(completedURL));
//            Player.printPosition(document);
//            dataRow = DataSelection.selectData(document);
//        }
//        return document;
//    }