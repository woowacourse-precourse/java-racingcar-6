package racingcar.domain;

import racingcar.validation.GameCountValidator;

public class GameCount {

    private int count;

    private GameCount(String userInput) {
        this.count = create(userInput);
    }

    public static GameCount from(String userInput) {
        return new GameCount(userInput);
    }

    private int create(String userInput) {
        GameCountValidator.validateGameCount(userInput);
        return Integer.parseInt(userInput);
    }
}
