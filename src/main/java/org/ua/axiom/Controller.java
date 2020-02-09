package org.ua.axiom;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private Model model;
    private Viewer viewer;

    public Controller(Model model, Viewer viewer) {
        this.model = model;
        this.viewer = viewer;
    }

    public void run(InputStream inputSource) {
        Scanner scanner = new Scanner(inputSource);

        viewer.output(Viewer.LIMIT_REQUEST);
        model.setSecretNumber(Integer.parseInt(getInput(scanner)));

        while (model.isRunning()) {
            viewer.output(Viewer.INPUT_REQUEST);
            viewer.output(model.acceptInput(getInput(scanner)));
        }

        viewer.output(viewer.getGameReview(model));

        scanner.close();
    }

    private String getInput(Scanner s) {
        Pattern pattern = Pattern.compile("[0-9]+");

        while (true) {
            Matcher matcher = pattern.matcher(s.nextLine());
            if(matcher.matches()) {
                viewer.output(Viewer.CORRECT_INPUT_FORMAT_MSG);
                return matcher.group();
            }
            else
                viewer.output(Viewer.WRONG_INPUT_FORMAT_MSG);
        }
    }
}
