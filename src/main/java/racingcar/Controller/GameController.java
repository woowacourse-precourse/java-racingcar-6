package racingcar.Controller;

import racingcar.Domain.Cars;
import racingcar.Domain.Round;
import racingcar.Utils.UtilsRandom;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    public void run() {
        Cars cars = Cars.of(InputView.inputGetCar());
        Round round = Round.of(InputView.inputGetRound());
        move(round, cars);
        OutputView.OutputResults(cars);
        OutputView.OutputWinners(cars);
    }
    private void move(Round round, Cars cars) {
        for (int i = 0; i < round.getCount(); i++) {
            cars.move(getRandomNumbers(cars));
        }
    }
    private List<Integer> getRandomNumbers(Cars cars) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i =0; i < cars.getCars().size(); i++) {
            randomNumbers.add(UtilsRandom.nextInt(0, 10));
        }
        return randomNumbers;
    }
}
