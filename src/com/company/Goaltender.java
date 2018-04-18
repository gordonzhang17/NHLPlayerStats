package com.company;

import org.jsoup.nodes.Element;

public class Goaltender extends Player {

    public static void printGoaltender(Element dataRow) {
        String lastSeasonPlayed;
        String lastTeamPlayedFor;
        String league;
        String gamesPlayed;


        String wins;
        String loses;
        String overtimeLoses;
        String totalMinutes;
        String goalsAllowed;
        String shutouts;
        String goalsAllowedAverage;
        String savePercentage;


        lastSeasonPlayed = dataRow.select("td").get(0).text();
        lastTeamPlayedFor = dataRow.select("td").get(1).text();
        league = dataRow.select("td").get(2).text();
        gamesPlayed = dataRow.select("td").get(3).text();

        wins = dataRow.select("td").get(4).text();
        loses = dataRow.select("td").get(5).text();

        // if its an older goalie there may have been ties so check for that

        if (dataRow.select("td").get(6).text().matches(-)) {
            // for example Luongo
            // TODO: FIX THIS!

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

        System.out.println("Last Season Played: " + lastSeasonPlayed);
        System.out.println("Last Team Played For: " + lastTeamPlayedFor);
        System.out.println("League: " + league);
        System.out.println("Games Played: " + gamesPlayed);

        System.out.println("Wins: " + wins);
        System.out.println("Loses: " + loses);
        System.out.println("Overtime Loses : " + overtimeLoses);
        System.out.println("Total Minutes: " + totalMinutes);
        System.out.println("Goals Allowed: " + goalsAllowed);
        System.out.println("Goals Allowed Average: " + goalsAllowedAverage);
        System.out.println("Shutouts: " + shutouts);
        System.out.println("Save percentage: " + savePercentage);

        printPlayOffInfo(dataRow);
    }

}
