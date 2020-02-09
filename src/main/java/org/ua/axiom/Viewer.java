package org.ua.axiom;

import javax.jws.WebParam;

public class Viewer {
    public static final String WRONG_INPUT_FORMAT_MSG = "Wrong input format, try again";
    public static final String CORRECT_INPUT_FORMAT_MSG = "";

    public static final String LIMIT_REQUEST = "Enter limit for secret number:";
    public static final String INPUT_REQUEST = "Enter your guess";

    public static final String BIGGER_INPUT = "You have entered number, bigger then the secret one";
    public static final String SMALLER_INPUT = "You have entered number, smaller then the secret one";
    public static final String CORRECT_INPUT = "You have entered correct number!";


    public void output(String content) {
        System.out.println(content);
    }

    public String getGameReview(Model model) {
        StringBuilder result = new StringBuilder();
        result.
                append("Your guesses:\n").
                append(model.getGuesses().toString()).
                append('\n').append("You have spend ").
                append(model.getGuesses().size()-1).
                append(" tries to win the game, that's ").
                append((int)(model.getGuesses().size() - Math.log(model.getUpperBound() - model.getLowerBound())) + 1).
                append(" more than needed in the worst case!");

        return result.toString();
    }

    public static String getBoundInfo(Model model) {
        StringBuilder result = new StringBuilder();

        result.
                append("\nAnswer lies between ").
                append(model.getLowerBound()).
                append(" and ").
                append(model.getUpperBound());

        return result.toString();
    }
}
