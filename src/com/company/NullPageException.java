package com.company;

import java.io.IOException;

public class NullPageException extends IOException {

    public NullPageException() {

        super();
        System.out.println("Cannot find this player. " + "Enter correct name or another player's name.");

    }

}
