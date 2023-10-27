package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGame {

    public void race() {
        List<Car> carList = Car.createCarFrom(InputView.inputCarName());
        Cars cars = Cars.createCarsFrom(carList);
        int round = InputView.inputRound();
        ResultView resultView = new ResultView();
        resultView.printShowResult();
        while (round-- > 0) {
            cars.startRound();
            resultView.showRoundResult(carList);
        }
        Winners winners = Winners.createWinnersFrom(cars.findFinalWinners());
        resultView.callWinner(winners.getWinnerName());
    }
}
