package com.company;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Document document;
        Element dataRow;
        String completedURL;

        System.out.println("NHL PLAYER STATS FINDER \n");
        System.out.println("Finds the latest statistics for the player in their most recent NHL season \n");
        System.out.println("Please enter in the full name of the player you would like statistics for. \n" + "Name entered must be a valid player " +
        "If player has middle name, enter middle name's capitalization exactly. Other capitalizations don't matter");


        while (true) {
            try {
                completedURL = MakeURL.createURL();
                document = Connection.connect(completedURL);
                break;
            } catch (NullPageException e) {
            }
        }

        Player.printPosition(document);
        dataRow = DataSelection.selectData(document);

        if (Player.isGoaltender(document)) {
            Goaltender.printInfo(document, dataRow);
        } else {
            NonGoaltender.printInfo(document, dataRow);
        }

    }
}


