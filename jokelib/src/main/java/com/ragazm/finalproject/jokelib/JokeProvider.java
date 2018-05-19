package com.ragazm.finalproject.jokelib;

import java.util.Random;

public class JokeProvider {
    private static final String[] jokesArray = new String[] {
            "Have you heard about the object-oriented way to become wealthy?\n" +
                    "No...\n"+
                    "Inheritance.",

            "Why do Java developers wear glasses?\n" +
                    "Because they can't C#",

            "“I would tell you a UDP joke, but you might not get it”\n",

            "Programmer A : How much money do I owe you?\n" +
                    "Programmer B : 500 dollars.\n" +
                    "Programmer A : Shall we round it off to 512?"
    };

    public static String getJokes(){
        Random random = new Random();
        int index = random.nextInt(jokesArray.length);
        return jokesArray[index];
    }
}
