package org.ua.axiom;

import java.io.OutputStream;
import java.io.PrintStream;

public class Viewer {
    public static final String WRONG_INPUT_FORMAT_MSG = "Wrong input format, try again";
    public static final String CORRECT_INPUT_FORMAT_MSG = "";

    public static final String LIMIT_REQUEST = "Enter limit for secret number:";
    public static final String INPUT_REQUEST = "Enter your guess";

    public static final String BIGGER_INPUT = "You have entered number, bigger then the secret one";
    public static final String SMALLER_INPUT = "You have entered number, smaller then the secret one";
    public static final String CORRECT_INPUT = "You have entered correct number!";

    private final PrintStream outputStream;

    public Viewer(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public void output(String content) {
        outputStream.println(content);
    }

    public String getGameReview(Model model) {
        StringBuilder result = new StringBuilder();
        result.
                append("Your guesses:\n").
                append(model.getGuesses().toString()).
                append('\n').append("You have spend ").
                append(model.getGuesses().size()+1).
                append(" tries to win the game, that's ").
                append((int)(model.getGuesses().size() + 1 - Math.log(model.getUpperBound() - model.getLowerBound())) + 1).
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
