package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    List<Car> cars = new ArrayList<>();
    List<String> carNames = new ArrayList<>();
    List<String> winner = new ArrayList<>();
    int trials;
    int max;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void begin() {
        carNames = inputView.getCarNames();

        trials = inputView.getTrials();

        for (String carName : carNames) {
            cars.add(new Car(carName, trials));
        }

        outputView.newLine();
        outputView.processResult(cars, trials);

        max = findMax(cars);
        winner = findWinner(cars, max);
        outputView.printWinner(winner);
    }

    public int findMax(List<Car> cars) {
        int max = 0;

        for (Car car : cars) {
            if (car.getForward() >= max) {
                max = car.getForward();
            }
        }

        return max;
    }

    public List<String> findWinner(List<Car> cars, Integer max) {

        List<String> winner = new ArrayList<>();

        cars.forEach(
                c-> {
                    if (c.getForward().equals(max)) {
                        winner.add(c.getName());
                    }
                }
        );

        return winner;
    }
}
