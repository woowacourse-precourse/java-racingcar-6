package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.enums.GameConstant;
import racingcar.model.Cars;
import racingcar.model.GameState;
import racingcar.view.InputView;

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

        while (this.gameState.continueGame()) {
            List<Integer> randomNumbers = generateRandomNumbers();
            this.cars.moveAll(randomNumbers);
        }
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
        generateAttempsNumber();
    }

    private void generateCars() {
        String carNameString = InputView.inputCarName();
        List<String> carNameList = generator.convertStringToStringList(carNameString);
        this.cars = new Cars(carNameList);
    }

    public void generateAttempsNumber() {
        String attempsNumberString = InputView.inputAttemptsNumber();
        this.gameState.updateAttempsCount(attempsNumberString);
    }
}
