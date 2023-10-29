package racingcar;

import java.util.List;
import racingcar.Input.UserInput;
import racingcar.domain.CarRaceGame;

public class Application {
    public static void main(String[] args) {
        int iterationNumber;
        List<String> carNames;

        UserInput userInput = new UserInput();
        carNames = userInput.getCarNames();
        iterationNumber = userInput.getIterationNumber();

        CarRaceGame carRaceGame = new CarRaceGame(carNames, iterationNumber);
        carRaceGame.playGame();
    }
}