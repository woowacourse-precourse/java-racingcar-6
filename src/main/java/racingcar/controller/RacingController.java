package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.Message;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    public void startRace() {
        Cars cars = new Cars(generateRacersFromNames(InputView.readCarNames()));
        int count = InputView.readTryGame();
        Message.result();
        for (int i = 1; i <= count; i++) {
            cars.moveCars();
            List<Car> carList = cars.getCars();
            for (Car car : carList) {
                OutputView.printInfo(car.getName(), car.getPosition());
            }
            Message.insertSpace();
        }
        List<String> winners = cars.findWinners();
        OutputView.racingWinners(winners);
    }

    public String[] generateRacersFromNames(String input) {
        return input.split(",");
    }

}
