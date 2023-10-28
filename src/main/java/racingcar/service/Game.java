package racingcar.service;

import racingcar.domain.model.Car;
import racingcar.domain.util.Judgement;
import racingcar.domain.util.NumberGenerator;
import racingcar.domain.validation.InputValidator;
import racingcar.ui.Message;
import racingcar.ui.input.InputProcessor;
import racingcar.ui.output.OutputProcessor;

public class Game {
    private final Car cars = new Car();
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final Judgement judgement = new Judgement();
    private final InputValidator inputValidator = new InputValidator();
    private final InputProcessor inputProcessor = new InputProcessor();
    private final OutputProcessor outputProcessor = new OutputProcessor();
    private String carNames;
    private String tryCount;

    public void playGame() {
        init();
    }

    private void init() {
        initCarNames();
        initTryCount();
        initCars();
    }

    private void initCarNames() {
        carNames = getInput(Message.START_MESSAGE_CAR_NAMES.getMessage());
        inputValidator.validateCarNames(carNames);
    }

    private void initTryCount() {
        tryCount = getInput(Message.START_MESSAGE_TRY_COUNT.getMessage());
        inputValidator.validateTryCount(tryCount);
    }

    private void initCars() {
        cars.addCar(carNames);
    }

    private String getInput(String message) {
        outputProcessor.printMessage(message);
        return inputProcessor.readInput();
    }

    private void inGame() {
        outputProcessor.printResult();
        for (int i = 0; i < Integer.parseInt(tryCount); i++) {
            for (String carName : cars.carList.keySet()) {
                if (judgement.isMoving(numberGenerator.createNumber())) {
                    cars.updateCar(carName);
                }
            }
        }
        outputProcessor.printResult(cars.carList);
    }
}
