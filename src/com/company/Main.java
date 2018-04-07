package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // "^[\\p{L} .'-]+$" https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters


    public static void main(String[] args) {
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

        System.out.println(completedURL);

    }


}


