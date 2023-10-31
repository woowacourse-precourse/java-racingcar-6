package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    public void start() {
        UserInputHandler inputHandler = new UserInputHandler();

        String[] carNames = inputHandler.inputNames();

        if(!ExceptionInput.checkNameLength(carNames)) {
            throw new IllegalArgumentException();
        }

        int gamePlayNum = inputHandler.inputRacingNumber();
    }

}
