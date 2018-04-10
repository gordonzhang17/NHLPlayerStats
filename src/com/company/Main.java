package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    // "^[\\p{L} .'-]+$" https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters

    public static void main(String[] args) throws IOException {
        Document document = null;
        // TODO:
        // given the user input of the player name, create a URL based on the given name
        // for now, assume given name doesn't contain dashes, or non-"american" letters such as the U with 2 dots on top
        // and this will need to be worked on

        System.out.println("NHL PLAYER STATS FINDER \n");
        System.out.println("Created by Gordon Zhang :) \n");
        System.out.println("Finds the latest statistics for the NHL player in their most recent season \n");
        System.out.println("Please enter in the full name of the player you would like statistics for. Do not include dashes for players with middle names");

        String[] checkedNameAndSeparated = MakeURL.validNameChecker();

        String completedURL = MakeURL.createURL(checkedNameAndSeparated);

        //System.out.println(completedURL);

        try {
             document = Jsoup.connect(completedURL).get();
            //System.out.println(document.outerHtml());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        //System.out.println("title: " + title);

        //Element element = document.select(".mw-content-ltr");
        //Elements divClass = element.select(".mw-parser-output");
        // this gets me inside the contents of the Wikipedia page

        Element dataTable = document.select("table[border=\"0\" cellpadding=\"1\" cellspacing=\"0\" style=\"text-align:center]").first();
        System.out.println(dataTable.outerHtml());
//        Element dataTableTBody = element.select("tbody");
//        // now I am at the table
//        Elements rows = dataTable.select("tr");
//        // now im at the
//
//        Element row = rows.get(rows.get(rows.size()));



        // attributes of a player

//        String lastSeasonPlayed;
//        String lastTeamPlayedFor;
//        String gamesPlayed;
//        String goals;
//        String assists;
//        String points;
//        String penaltyMinutes;


    }
}


