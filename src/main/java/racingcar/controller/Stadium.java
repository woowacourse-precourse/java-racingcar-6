package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winner;
import racingcar.dto.WinnerDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Stadium {

    private final Cars cars = new Cars();

    private int attempt;
    public void start(){
        cars.join(InputView.getInputCar());
        attempt = InputView.getInputAttempt();
        game();
        WinnerDto winners = Winner.decision(cars);

        OutputView.result(winners);
    }

    private void game(){
        OutputView.printGameStartMessage();
        for(int round = 0; round < attempt; round++){
            moving();
            OutputView.currentRacingPosition(cars);
        }
    }

    private void moving(){
        for(Car driver : cars.getCars()){
            driver.choice();
        }
    }
}