package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.view.errorMessage.*;

public class RacingcarController {
    private static final RacingcarService racingcarService = new RacingcarService();
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    List<Car> carList = new ArrayList<>();

    public void run() {
        start();
    }

    private void start() {
        String[] carNames = inputView.getCarNames().split(",");

        for (String carName : carNames) {
            if(carName.length() > 5){
                throw new IllegalArgumentException(ERROR_CAR_NAME_TOO_LONG);
            }

            carList.add(new Car(carName, 0));
        }


        game();
        outputView.printFinalResult(getFinalResult());
    }

    private void getRoundCount(){

    }

    private void game(){
        int roundCount;

        try{
            roundCount = Integer.parseInt(inputView.getRoundCount());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_INTEGER_ONLY);
        }

        outputView.printResultMessage();

        for (int i = 0; i < roundCount; i++) {
            racingcarService.game(carList);

            for (Car car : carList) {
                outputView.printResult(car);
            }
            System.out.println();
        }
    }

    private List<String> getFinalResult(){
        List<String> result = new ArrayList<>();
        Car maxCar = Collections.max(carList);

        for (Car car : carList) {
            if (car.compareTo(maxCar) == 0) {
                result.add(car.getName());
            }
        }

        return result;
    }
}
