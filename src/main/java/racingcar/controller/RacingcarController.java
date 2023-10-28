package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingcarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;


import java.util.ArrayList;
import java.util.List;

public class RacingcarController {
    private static final RacingcarService racingcarService = new RacingcarService();
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    List<Car> carList = new ArrayList<>();
    private int roundCount;

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
    }

    private void game(){
        roundCount = Integer.parseInt(inputView.getRoundCount());
        outputView.printResultInfo();

        for (int i = 0; i < roundCount; i++) {
            racingcarService.game(carList);

            for (Car car : carList) {
                outputView.printResult(car);
            }
            System.out.println();
        }
    }
}
