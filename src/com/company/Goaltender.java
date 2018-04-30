package com.company;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Goaltender extends Player {

    private String wins;
    private String loses;
    private String overtimeLoses;
    private String totalMinutes;
    private String goalsAllowed;
    private String shutouts;
    private String goalsAllowedAverage;
    private String savePercentage;

    public Goaltender(String lastSeasonPlayed, String lastTeamPlayedFor, String league, String gamesPlayed, String wins, String loses,
                      String overtimeLoses, String totalMinutes, String goalsAllowed, String shutouts, String goalsAllowedAverage, String savePercentage) {

        super(lastSeasonPlayed, lastTeamPlayedFor, league, gamesPlayed);

        this.wins = wins;
        this.loses = loses;
        this.overtimeLoses = overtimeLoses;
        this.totalMinutes = totalMinutes;
        this.goalsAllowed = goalsAllowed;
        this.shutouts = shutouts;
        this.goalsAllowedAverage = goalsAllowedAverage;
        this.savePercentage = savePercentage;
    }

    public static void printInfo(Document document, Element dataRow) {

        String overtimeLoses;
        String totalMinutes;
        String goalsAllowed;
        String shutouts;
        String goalsAllowedAverage;
        String savePercentage;

        String lastSeasonPlayed = dataRow.select("td").get(0).text();
        String lastTeamPlayedFor = dataRow.select("td").get(1).text();
        String league = dataRow.select("td").get(2).text();
        String gamesPlayed = dataRow.select("td").get(3).text();

        String wins = dataRow.select("td").get(4).text();
        String loses = dataRow.select("td").get(5).text();

        // if its an older goalie there may have been ties so check for that (like Roberto Luongo)

        if (dataRow.select("td").get(6).text().contains("—")) {

            overtimeLoses = dataRow.select("td").get(7).text();
            totalMinutes = dataRow.select("td").get(8).text();
            goalsAllowed = dataRow.select("td").get(9).text();
            shutouts = dataRow.select("td").get(10).text();
            goalsAllowedAverage = dataRow.select("td").get(11).text();
            savePercentage = dataRow.select("td").get(12).text();

        } else {

            overtimeLoses = dataRow.select("td").get(6).text();
            totalMinutes = dataRow.select("td").get(7).text();
            goalsAllowed = dataRow.select("td").get(8).text();
            shutouts = dataRow.select("td").get(9).text();
            goalsAllowedAverage = dataRow.select("td").get(10).text();
            savePercentage = dataRow.select("td").get(11).text();
        }


        Goaltender goaltender = new Goaltender(lastSeasonPlayed, lastTeamPlayedFor, league, gamesPlayed, wins, loses, overtimeLoses, totalMinutes,
                goalsAllowed,shutouts, goalsAllowedAverage, savePercentage);

        printInfo(goaltender);

        System.out.println("Wins: " + goaltender.wins);
        System.out.println("Loses: " + goaltender.loses);
        System.out.println("Overtime Loses : " + goaltender.overtimeLoses);
        System.out.println("Total Minutes: " + goaltender.totalMinutes);
        System.out.println("Goals Allowed: " + goaltender.goalsAllowed);
        System.out.println("Goals Allowed Average: " + goaltender.goalsAllowedAverage);
        System.out.println("Shutouts: " + goaltender.shutouts);
        System.out.println("Save percentage: " + goaltender.savePercentage + "\n");

        playOffInfo(document, dataRow);
    }

    public static void printPlayoffInfo(Element dataRow) {

        String gamesPlayed;
        String wins;
        String loses;
        String totalMinutes;
        String goalsAllowed;
        String shutouts;
        String goalsAllowedAverage;
        String savePercentage;


        if (dataRow.select("td").get(6).text().contains("—")) {

            gamesPlayed = dataRow.select("td").get(11).text();
            wins = dataRow.select("td").get(12).text();
            loses = dataRow.select("td").get(13).text();
            totalMinutes = dataRow.select("td").get(14).text();
            goalsAllowed = dataRow.select("td").get(15).text();
            shutouts = dataRow.select("td").get(16).text();
            goalsAllowedAverage = dataRow.select("td").get(17).text();
            savePercentage = dataRow.select("td").get(18).text();

        } else {

            gamesPlayed = dataRow.select("td").get(12).text();
            wins = dataRow.select("td").get(13).text();
            loses = dataRow.select("td").get(14).text();
            totalMinutes = dataRow.select("td").get(15).text();
            goalsAllowed = dataRow.select("td").get(16).text();
            shutouts = dataRow.select("td").get(17).text();
            goalsAllowedAverage = dataRow.select("td").get(18).text();
            savePercentage = dataRow.select("td").get(19).text();

        }

        System.out.println("Playoff Games Played: " + gamesPlayed);
        System.out.println("Playoff Wins: " + wins);
        System.out.println("Playoff Loses: " + loses);
        System.out.println("Playoff Total Minutes: " + totalMinutes);
        System.out.println("Playoff Goals Allowed: " + goalsAllowed);
        System.out.println("Playoff Shutouts: " + shutouts);
        System.out.println("Playoff Goals Allowed Average: " + goalsAllowedAverage);
        System.out.println("Playoff Save percentage: " + savePercentage);

    }

}
