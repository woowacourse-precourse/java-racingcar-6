package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public static final String RESULT_MESSAGE = "실행결과";
    private final InputView inputView;

    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void racingGame() {
        CarList carList = initializeCarList();
        int settingGameNumber = settingGameNumber();

        System.out.println();
        System.out.println(RESULT_MESSAGE);
        List<Car> cars = null;
        for (int i = 0; i < settingGameNumber; i++) {
            cars = racingCarService.race(carList);
        }
        String winner = racingCarService.compareMileage(cars);
        pickWinner(winner);
    }

    public int settingGameNumber() {
        inputView.gameRunningNumberLog();
        return inputView.gameRunningNumber();
    }

    public CarList initializeCarList() {
        inputView.gameStartLog();
        return inputView.addCarName();
    }

    public void pickWinner(String winner) {
        outputView.finalWinner(winner);
    }
}
