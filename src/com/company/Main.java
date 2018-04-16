package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

public class Main {
    // "^[\\p{L} .'-]+$" https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters

    public static void main(String[] args) throws IOException {
        Document document = null;
        Element dataRow;
        // TODO:
        // given the user input of the player name, create a URL based on the given name
        // for now, assume given name doesn't contain dashes, or non-"american" letters such as the U with 2 dots on top
        // and this will need to be worked on

        System.out.println("NHL PLAYER STATS FINDER \n");
        System.out.println("Created by Gordon Zhang :) \n");
        System.out.println("Finds the latest statistics for the player in their most recent NHL season \n");
        System.out.println("Please enter in the full name of the player you would like statistics for. Do not include dashes for players with middle names");

        String[] checkedNameAndSeparated = MakeURL.validNameChecker();

        String completedURL = MakeURL.createURL(checkedNameAndSeparated);

        //System.out.println(completedURL);

        // TODO: maybe try to put this connection in a class
        try {
            document = Jsoup.connect(completedURL).get();
            //System.out.println(document.outerHtml());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //System.out.println("title: " + title);

        Player.printPosition(document);

        dataRow = DataSelection.selectData(document);

        // TODO: what if there is another person with the name?

        // NOTE: ASSUME THIS IS FOR A NON-GOALIE PLAYER
        // TODO: create a separate template for goaltenders (and this is determine by the position we have parsed earlier)

        if (Player.isGoaltender(document)) {
            Goaltender.printGoaltender(dataRow);
        } else {
            NonGoaltender.printNonGoaltenderInfo(dataRow);
        }

    }
}


