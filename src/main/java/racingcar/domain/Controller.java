package racingcar.domain;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.InputData;
import racingcar.preprocess.ProcessNames;
import racingcar.view.View;

public class Controller {
    public void gameLogic() {
        String inputCarName = View.input();
        Car car = createCar(inputCarName);
        validateCarNames(car);

        int attemptsCount = askForAttemptsCount();
        InputData inputData = new InputData(String.valueOf(attemptsCount));
        validateInputAttemptsCount(inputData);

        runRace(inputData, car);
        showWinnerMessage();
    }

    private Car createCar(String inputCarName) {
        ProcessNames processNames = new ProcessNames();
        List<String> carNames = processNames.processNames(inputCarName);
        return new Car(carNames);
    }

    private void validateCarNames(Car car) {
        ValidatorException.validateCarNames(car);
    }

    private int askForAttemptsCount() {
        View.askForAttemptsCount();
        String inputAttemptsCount = View.input();
        return Integer.parseInt(inputAttemptsCount);
    }

    private void validateInputAttemptsCount(InputData inputData) {
        ValidatorException.validateInputAttemptsCount(inputData);
    }

    private void runRace(InputData inputData, Car car) {
        View.resultMessage();
        RacingCarGame.playRace(inputData, car);
    }

    private void showWinnerMessage() {
        View.winnerMessage();
    }
}

