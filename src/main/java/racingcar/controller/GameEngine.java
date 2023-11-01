package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.enums.ErrorMessage;
import racingcar.enums.GameConstant;
import racingcar.model.Cars;
import racingcar.model.GameState;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameEngine {
    private Cars cars;
    private GameState gameState;
    private Generator generator;

    public GameEngine() {
        this.generator = new Generator();
        this.gameState = new GameState();
    }

    public void proceedGame() {
        initGame();
        OutputView.printLineFeed();
        OutputView.printStartMessageOfResult();

        while (this.gameState.continueGame()) {
            List<Integer> randomNumbers = generateRandomNumbers();
            this.cars.moveAll(randomNumbers);

            OutputView.printProgressAfterCarForward(this.cars);

            this.gameState.increaseAttempsCount();
        }

        Cars winner = new Cars(cars.getMaximumMovedCarNameList());
        OutputView.printWinnerOfGameMessage(winner);
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        Integer sizeOfCars = this.cars.size();

        for (int i = 0; i < sizeOfCars; ++i) {
            Integer randomNumber = generator.generateRandomValue0To9();

            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }

    private void initGame() {
        generateCars();
        validateDuplicateCarName();

        generateAttempsNumber();
    }

    private void generateCars() {
        String carNameString = InputView.inputCarName();
        List<String> carNameList = generator.convertStringToStringList(carNameString);

        validateCountOfCar(carNameList.size());

        this.cars = new Cars(carNameList);
    }

    private void generateAttempsNumber() {
        String attempsNumberString = InputView.inputAttemptsNumber();
        this.gameState.updateAttempsCount(attempsNumberString);
    }

    private void validateCountOfCar(Integer countOfCar) {
        Integer minimumCountOfCar = GameConstant.MINIMUM_COUNT_OF_CAR.getContentToInteger();

        if (minimumCountOfCar > countOfCar) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_COUNT_OF_CAR.getMessage());
        }
    }

    private void validateDuplicateCarName() {
        String carListString = this.cars.toString();
        String delimiter = GameConstant.DELIMITER.getContent();
        List<String> carList = new ArrayList<>();

        for (String carName : carListString.split(delimiter)) {
            if (carList.contains(carName)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
            }

            carList.add(carName);
        }
    }
}
