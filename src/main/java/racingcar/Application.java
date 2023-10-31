package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserInputHandler inputHandler = new UserInputHandler();

        List<String> carNames = inputHandler.inputNames();
        int gamePlayNum = inputHandler.inputRacingNumber();
    }
}
