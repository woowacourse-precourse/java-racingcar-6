package racingcar;

import racingcar.domain.UserInput;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        String[] carNames = userInput.getCarNames();
        int tryNumber = userInput.getTryNumber();
    }
}
