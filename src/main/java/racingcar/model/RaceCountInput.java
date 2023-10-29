package racingcar.model;

import racingcar.view.InputView;

public class RaceCountInput {

    private static final String REGEX = "\\d+";

    public void process() {
        String userInput = InputView.getUserInput();
        int gameCount = valid(userInput);
    }

    public int valid(String userInput) {
        validIsNumber(userInput);
        int userCount = toInt(userInput);
        validNotZero(userCount);
        return userCount;
    }

    public void validIsNumber(String userInput) {
        if (!userInput.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public void validNotZero(int userCount) {
        if (userCount == 0) {
            throw new IllegalArgumentException();
        }
    }

    public int toInt(String userInput) {
        return Integer.parseInt(userInput);
    }
}
