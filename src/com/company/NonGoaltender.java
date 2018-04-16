package com.company;


import org.jsoup.nodes.Element;

public class NonGoaltender extends Player {


    public static void printNonGoaltenderInfo(Element dataRow) {

        String lastSeasonPlayed = dataRow.select("td").get(0).text();
        String lastTeamPlayedFor = dataRow.select("td").get(1).text();
        String league = dataRow.select("td").get(2).text();
        String gamesPlayed = dataRow.select("td").get(3).text();

        String goals = dataRow.select("td").get(4).text();
        String assists = dataRow.select("td").get(5).text();
        String points = dataRow.select("td").get(6).text();
        String penaltyInMinutes = dataRow.select("td").get(7).text();
        System.out.println("Last Season Played: " + lastSeasonPlayed);
        System.out.println("Last Team Played For: " + lastTeamPlayedFor);
        System.out.println("League: " + league);
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Goals: " + goals);
        System.out.println("Assists: " + assists);
        System.out.println("Points: " + points);
        System.out.println("Penalty in Minutes: " + penaltyInMinutes);


        printPlayOffInfo(dataRow);

    }
}
