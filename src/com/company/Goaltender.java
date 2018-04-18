package com.company;

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

    public static void printInfo(Element dataRow) {

        String overtimeLoses = null;
        String totalMinutes = null;
        String goalsAllowed = null;
        String shutouts = null;
        String goalsAllowedAverage = null;
        String savePercentage = null;

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
        System.out.println("Save percentage: " + goaltender.savePercentage);

        printPlayOffInfo(dataRow);
    }

}
