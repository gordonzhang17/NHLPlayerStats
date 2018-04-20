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
        //String position = positionSecondRow.select("a[title]").text();
        String position = positionSecondRow.text();
        //Player player = new Player(position);

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
        // TODO: this is not complete
        if (!dataRow.select("td").get(8).text().matches(".*\\d+.*")) {
            System.out.println("Did not participate in the playoffs in his latest season or is currently in the playoffs");
            //System.out.println(MakeURL.formattedName() + "did not participate in the playoffs");
        }
    }

    public static void printInfo(Player player) {
        System.out.println("Last Season Played: " + player.lastSeasonPlayed);
        System.out.println("Last Team Played For: " + player.lastTeamPlayedFor);
        System.out.println("League: " + player.league);
        System.out.println("Games Played: " + player.gamesPlayed);
    }



}
