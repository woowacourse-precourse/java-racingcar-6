package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
                throw new IllegalArgumentException("자동차 이름은 5글자 이하입니다.");
            }

            carList.add(new Car(carName, 0));
        }

        game();
        outputView.printFinalResult(getFinalResult());
    }

    private void game(){
        int roundCount = Integer.parseInt(inputView.getRoundCount());
        outputView.printResultInfo();

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
