package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingcarService;
import racingcar.view.ExceptionHandler;
import racingcar.view.InputView;
import racingcar.view.OutputView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.view.ExceptionHandler.*;

public class RacingcarController {
    private static final RacingcarService racingcarService = new RacingcarService();
    private static final ExceptionHandler exceptionHandler = new ExceptionHandler();
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    List<Car> carList = new ArrayList<>();

    public void run() {
        start();
    }

    private void start() {
        String[] carNames = inputView.getCarNames().split(",");
        validateCarNames(carNames);

        for (String carName : carNames) {
            carList.add(new Car(carName, 0));
        }

        int roundCount = getRoundCount();
        game(roundCount);
        getFinalResult();
    }

    private void validateCarNames(String[] carNames){
        for (String carName : carNames) {
            exceptionHandler.isValidCarName(carName);
        }
    }

    private int getRoundCount(){
        String roundCount = inputView.getRoundCount();
        exceptionHandler.isIntegerInput(roundCount);

        return Integer.parseInt(roundCount);
    }

    private void game(int roundCount){
        outputView.printResultMessage();

        for (int i = 0; i < roundCount; i++) {
            racingcarService.game(carList);

            for (Car car : carList) {
                outputView.printResult(car);
            }
            System.out.println();
        }
    }

    private void getFinalResult(){
        List<String> result = new ArrayList<>();
        Car maxCar = Collections.max(carList);

        for (Car car : carList) {
            if (car.compareTo(maxCar) == 0) {
                result.add(car.getName());
            }
        }

        outputView.printFinalResult(result);
    }
}
