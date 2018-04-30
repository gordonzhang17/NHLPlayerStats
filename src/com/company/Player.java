package com.company;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Player {

    //private String position;

    private String lastSeasonPlayed;
    private String lastTeamPlayedFor;
    private String league;
    private String gamesPlayed;

    public Player(String lastSeasonPlayed, String lastTeamPlayedFor, String league, String gamesPlayed) {
        this.lastSeasonPlayed = lastSeasonPlayed;
        this.lastTeamPlayedFor = lastTeamPlayedFor;
        this.league = league;
        this.gamesPlayed = gamesPlayed;
    }

//    public Player(String position) {
//        this.position = position;
//    }

    public static void printPosition(Document document) {

        assert document != null;
        Elements summaryTable = document.select("table[class=infobox vcard]");
        // first, we want the position of the player
        Elements positionRow = summaryTable.select("tr:nth-child(6)");
        // inside the HTML for the position
        Elements positionSecondRow = positionRow.select("td[class=role]");
        String position = positionSecondRow.text();

        // check if the player plays multiple positions:
        String[] positionParts = position.split("/");
//        for (int i = 0 ; i < positionParts.length ; i++) {
//            System.out.println(positionParts[i]);
//        }

        if (positionParts.length > 1) {
            if (positionParts[1].contains("[")) {
                positionParts[1] = positionParts[1].substring(0, positionParts[1].indexOf("["));
            }
            System.out.println("Positions: " + positionParts[0] + " and " + positionParts[1]);
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

    public static void playOffInfo(Document document, Element dataRow) {
        if (!dataRow.select("td").get(8).text().matches(".*\\d+.*")
                || !dataRow.select("td").get(12).text().matches(".*\\d+.*")) {
            System.out.println("Did not participate in the playoffs in his last season or is currently in the playoffs");
        } else if (isGoaltender(document)) {
            try {
                Goaltender.printPlayoffInfo(dataRow);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Cannot retrieve playoff statistics.");
            }
        } else try {
            NonGoaltender.printPlayoffInfo(dataRow);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Cannot retrieve the playoff statistics.");
        }
    }

    public static void printInfo(Player player) {
        System.out.println("Last Season Played: " + player.lastSeasonPlayed);
        System.out.println("Last Team Played For: " + player.lastTeamPlayedFor);
        System.out.println("League: " + player.league);
        System.out.println("Games Played: " + player.gamesPlayed);
    }

}
