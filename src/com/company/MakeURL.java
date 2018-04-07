package com.company;

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MakeURL {
    // creates URL link for Wikipedia


    public static String[] validNameChecker() {
        String[] nameParts;
        while (true) { // check if the entered name is valid or not
            Scanner scanner = new Scanner(System.in);
            String fullName = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[\\p{L} -]+$"); // regex to check for spaces, valid A-Z characters
            Matcher matcher = pattern.matcher(fullName);
            if (matcher.matches()) {
                nameParts = fullName.split(" ");
//                for (int i =0 ; i< nameParts.length; i++) {
//                    System.out.println(nameParts[i]);
//                }


                if (nameParts.length < 2 || nameParts.length > 3) {
                    System.out.println("Given name length too short or too long. Enter valid name");
                    // no player's name should have less than 2 parts or more than 3 parts
                } else {
                    break;
                } // break when checked that the string is valid and i have split it up
            } else {
                System.out.println("Invalid Name. Name must have only alphabetical letters. Enter valid name.");
            }
        }
        return nameParts;
    }

    // TODO:
    // think of special player names that will require a different URL type
    // for example Devante Smith-Pelly,

    public static String createURL(String[] stringArray) {
        String url = "https://en.wikipedia.org/wiki/";

        if (stringArray.length == 2) {
            String first = stringArray[0];
            first = first.substring(0,1).toUpperCase() + first.substring(1).toLowerCase();
            String last  = stringArray[1];
            // for player names such as Devante Smith-Pelly
            last = last.substring(0,1).toUpperCase() + last.substring(1).toLowerCase();
            url =  url + first + "_" + last;
        }
        //if (stringArray.length == 3 && stringArray[0])

        if (stringArray.length == 3) {
            String first = stringArray[0];
            first = first.substring(0,1).toUpperCase() + first.substring(1).toLowerCase();
            String middle = stringArray[1]; // assume middle name is not capitalized (ie James van Riemsdyk)
            String last = stringArray[2];
            last = last.substring(0,1).toUpperCase() + last.substring(1).toLowerCase();
            url = url + first + "_" + middle + "_" + last;
        }

        return url;
    }
}


//        String[] nameParts = null;
//        String url = "https://en.wikipedia.org/wiki/";
//
//        while (true) {
//            Pattern pattern = Pattern.compile("^[a-zA-Z\\\\s]*$"); // regex to check for spaces, valid A-Z characters
//            Matcher matcher = pattern.matcher(playerName);
//            if (matcher.matches()) {
//                nameParts = playerName.split(" ");
//                if (nameParts.length < 2 || nameParts.length > 3) {
//                    System.out.println("Given name length too short or too long. Enter valid name");
//                    // no player's name should have less than 2 parts or more than 3 parts
//                } else System.out.println("Invalid Name. Enter valid name. Name must have only alphabetical letters");
//            }
//            break; // break when checked that the string is valid and i have split it up
//        }

