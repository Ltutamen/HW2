package org.ua.axiom;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class Model {
    private enum MODEL_STATE{ENTRANCE, OVER}
    private static final int DEFAULT_LIMIT = 100;

    private int lowerBound, upperBound;
    private int secretNumber;
    private Queue<Integer> guesses;
    private MODEL_STATE currentState;

    public Model() {
        this.currentState = MODEL_STATE.ENTRANCE;
        this.guesses = new ArrayDeque<>();
        this.secretNumber = new Random().nextInt(DEFAULT_LIMIT);
        this.lowerBound = 0;
        this.upperBound = DEFAULT_LIMIT;
    }

    public void setSecretNumber(int limit) {
        this.upperBound = limit;
        this.lowerBound = 0;

        this.secretNumber = new Random().nextInt(limit);
    }

    public boolean isRunning() {
        return currentState != MODEL_STATE.OVER;
    }

    public String acceptInput(String input) {
        int iinput = Integer.parseInt(input);
        StringBuilder result = new StringBuilder();
        guesses.add(iinput);

        if(iinput > secretNumber) {
            upperBound = iinput;
            result.append(Viewer.BIGGER_INPUT);
        } else if(iinput < secretNumber) {
            lowerBound = iinput;
            result.append(Viewer.SMALLER_INPUT);
        } else {
            this.currentState = MODEL_STATE.OVER;
            return Viewer.CORRECT_INPUT;
        }
        result.
                append("\nAnswer lies between ").
                append(lowerBound).
                append(" and ").
                append(upperBound);

        return result.toString();
    }

    public Queue<Integer> getGuesses() {
        return guesses;
    }

    public Integer getUpperBound() {
        return upperBound;
    }

    public Integer getLowerBound() {
        return lowerBound;
    }
}
