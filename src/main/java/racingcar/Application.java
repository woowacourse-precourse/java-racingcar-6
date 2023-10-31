package racingcar;

import java.util.List;
import racingcar.input.UserInput;
import racingcar.domain.RacingGame;

public class Application {
    public static void main(String[] args) {
        int iterationNumber;
        List<String> carNames;

        UserInput userInput = new UserInput();
        carNames = userInput.getCarNames();
        iterationNumber = userInput.getIterationNumber();

        RacingGame racingGame = new RacingGame(carNames, iterationNumber);
        racingGame.playGame();
    }
}