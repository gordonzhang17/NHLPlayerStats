package com.company;

import org.jsoup.HttpStatusException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main {
    // "^[\\p{L} .'-]+$" https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters

    public static void main(String[] args) throws IOException {
        Document document;
        Element dataRow;
        String completedURL;

        // TODO:
        // given the user input of the player name, create a URL based on the given name
        // for now, assume given name doesn't contain dashes, or non-"american" letters such as the U with 2 dots on top
        // and this will need to be worked on

        System.out.println("NHL PLAYER STATS FINDER \n");
        System.out.println("Finds the latest statistics for the player in their most recent NHL season \n");
        System.out.println("Please enter in the full name of the player you would like statistics for. " + "Name entered must be a valid player " +
        "If player has middle name, enter middle name's capitalization exactly. Other capitalization do not matter");


        while (true) {
            try {
                completedURL = MakeURL.createURL();
                document = Connection.connect(completedURL);
                break;
            } catch (NullPageException e) {
                continue;
            }
        }


        Player.printPosition(document);
        dataRow = DataSelection.selectData(document);

        // TODO: what if there is another person with the name?

        if (Player.isGoaltender(document)) {
            Goaltender.printInfo(dataRow);
        } else {
            NonGoaltender.printInfo(dataRow);
        }

    }
}


