package racingcar.domain;

import racingcar.validation.GameCountValidator;

public class GameCount {

    private String count;

    private GameCount(String userInput) {
        this.count = create(userInput);
    }

    public static GameCount from(String userInput) {
        return new GameCount(userInput);
    }

    private String create(String userInput) {
        GameCountValidator.validateGameCount(userInput);
        return userInput;
    }

    public int convertStrToInt() {
        return Integer.parseInt(this.count);
    }
}
