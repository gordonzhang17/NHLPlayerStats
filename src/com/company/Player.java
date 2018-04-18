package com.company;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Player {

    String lastSeasonPlayed;
    String lastTeamPlayedFor;
    String league;
    String gamesPlayed;


    public static void printPosition(Document document) {

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
    }

    public static boolean isGoaltender(Document document) {

        Elements summaryTable = document.select("table[class=infobox vcard]");
        // first, we want the position of the player
        Elements positionRow = summaryTable.select("tr:nth-child(6)");
        // inside the HTML for the position
        Elements positionSecondRow = positionRow.select("td[class=role]");
        return positionSecondRow.select("a[title]").text().contains("Goaltender");
    }

    public static void printPlayOffInfo(Element dataRow) {
        if (!dataRow.select("td").get(8).text().matches(".*\\d+.*")) {
            System.out.println("Did not participate in the playoffs in his latest season or is currently in the playoffs");
            //System.out.println(MakeURL.formattedName() + "did not participate in the playoffs");
        }
    }


}
