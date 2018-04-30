package com.company;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class NonGoaltender extends Player {

    private String goals;
    private String assists;
    private String points;
    private String penaltyInMinutes;

    public NonGoaltender(String lastSeasonPlayed, String lastTeamPlayedFor, String league, String gamesPlayed,
                         String goals, String assists, String points, String penaltyInMinutes) {

        super(lastSeasonPlayed, lastTeamPlayedFor, league, gamesPlayed);

        this.goals = goals;
        this.assists = assists;
        this.points = points;
        this.penaltyInMinutes = penaltyInMinutes;

    }

    public static void printInfo(Document document, Element dataRow){

        String lastSeasonPlayed = dataRow.select("td").get(0).text();
        String lastTeamPlayedFor = dataRow.select("td").get(1).text();
        String league = dataRow.select("td").get(2).text();
        String gamesPlayed = dataRow.select("td").get(3).text();

        String goals = dataRow.select("td").get(4).text();
        String assists = dataRow.select("td").get(5).text();
        String points = dataRow.select("td").get(6).text();
        String penaltyInMinutes = dataRow.select("td").get(7).text();

        NonGoaltender nonGoaltender = new NonGoaltender(lastSeasonPlayed, lastTeamPlayedFor, league, gamesPlayed, goals, assists, points, penaltyInMinutes);

        printInfo(nonGoaltender);

        System.out.println("Goals: " + nonGoaltender.goals);
        System.out.println("Assists: " + nonGoaltender.assists);
        System.out.println("Points: " + nonGoaltender.points);
        System.out.println("Penalty in Minutes: " + nonGoaltender.penaltyInMinutes + "\n");

        playOffInfo(document, dataRow);

    }

    public static void printPlayoffInfo(Element dataRow) {

        String gamesPlayed = dataRow.select("td").get(8).text();
        String goals = dataRow.select("td").get(9).text();
        String assists = dataRow.select("td").get(10).text();
        String points = dataRow.select("td").get(11).text();
        String penaltyInMinutes = dataRow.select("td").get(12).text();

        System.out.println("Playoff games: " + gamesPlayed);
        System.out.println("Playoff goals: " + goals);
        System.out.println("Playoff assists: " + assists);
        System.out.println("Playoff points: " + points);
        System.out.println("Playoff in Minutes: " + penaltyInMinutes);


    }
}
