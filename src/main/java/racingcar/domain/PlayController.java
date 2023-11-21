package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.view.OutputView;

public class PlayController {
    OutputView outputView = new OutputView();

    public void move(Cars cars) {
        cars.move();
    }

    public void printResultTitle() {
        outputView.printResultTitle();
    }

    public void printRoundResult(Cars cars) {
        List<Car> roundResult = cars.getCars();
        outputView.printRountResult(roundResult);
    }

    public void printWinner(Cars cars) {
        List<String> winnerNames = cars.getWinner();
        outputView.printWinners(winnerNames);
    }
}
