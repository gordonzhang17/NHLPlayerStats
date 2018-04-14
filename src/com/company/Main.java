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
        //Elements divClass = document.select(".mw-parser-output");

        //Elements dataTable = document.select("table[border=\"0\" cellpadding=\"1\" cellspacing=\"0\"]");
        assert document != null;
        Elements summaryTable = document.select("table[class=infobox vcard]");
        // first, we want the position of the player
        Elements positionRow = summaryTable.select("tr:nth-child(6)");
        // inside the HTML for the position
        Elements positionSecondRow = positionRow.select("td[class=role]");
        String position = positionSecondRow.select("a[title]").text();

        // check if the player plays multiple positions:
        String[] positionParts = position.split(" ");
        if (positionParts.length > 2) {
            System.out.println("Positions: " + positionParts[0] + " and " + positionParts[1] + " " + positionParts[2]);
        } else {
            System.out.println("Position: " + position);
        }



        Element dataTable = document.select("table[border = 0]").first();
        Element latestYearPlayedRow = dataTable.select("tr").last().previousElementSibling();
        // TODO: deal with the situation where the player has played in a different professional league (not NHL)
        // TODO: what if there is another person with the name?

        // now i have the information I need, split it up into parts

        // NOTE: ASSUME THIS IS FOR A NON-GOALIE PLAYER
        // TODO: create a separate template for goaltenders (and this is determine by the position we have parsed earlier)

        String lastSeasonPlayed = latestYearPlayedRow.select("td").get(0).text();
        String lastTeamPlayedFor = latestYearPlayedRow.select("td").get(1).text();
        String league = latestYearPlayedRow.select("td").get(2).text();
        String gamesPlayed = latestYearPlayedRow.select("td").get(3).text();
        String goals = latestYearPlayedRow.select("td").get(4).text();
        String assists = latestYearPlayedRow.select("td").get(5).text();
        String points = latestYearPlayedRow.select("td").get(6).text();
        String penaltyInMinutes = latestYearPlayedRow.select("td").get(7).text();
        System.out.println("Last Season Played: " + lastSeasonPlayed);
        System.out.println("Last Team Played For: " + lastTeamPlayedFor);
        System.out.println("League: " + league);
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Goals: " + goals);
        System.out.println("Assists: " + assists);
        System.out.println("Points: " + points);
        System.out.println("Penalty in Minutes: " + penaltyInMinutes);

        if (!latestYearPlayedRow.select("td").get(8).text().matches(".*\\d+.*")) {
            System.out.println("Did not participate in the playoffs in his latest season or is currently in the playoffs");
            //System.out.println(MakeURL.formattedName() + "did not participate in the playoffs");
        }
    }
}


