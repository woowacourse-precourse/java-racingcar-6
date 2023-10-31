package racingcar.Controller;

import racingcar.model.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {


    public void start() {
        Cars cars = new Cars(InputView.inputName());
        TryCount tryCount = new TryCount(InputView.inputCnt());
        int cnt = Integer.parseInt(tryCount.getTryCount());
        race(cars, cnt);
        winners();

    }

    public void race(Cars cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            OutputView.carsStatus(cars.getCars());
        }

    }

    public void winners() {
        OutputView.winner(Winner.findWinners(Car.getCarMap()));
    }

}
