package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class Race {
    private final List<Car> cars;
    private final int trialNum;
    private int trialCnt;

    public Race(List<Car> cars, int trialNum) {
        this.cars = cars;
        this.trialNum = trialNum;
        this.trialCnt = 0;
    }

    public void playRaceGame () {
        OutputView.printGameResultInfo();
        while (trialCnt < trialNum) {
            playUnitRaceGame();
            trialCnt++;
        }
        finishRaceGame();
    }

    private void playUnitRaceGame() {
        cars.forEach(Car::move);
        OutputView.printUnitGameResult(this.cars);
    }

    private void finishRaceGame() {
        List<Car> winners = findWinners(cars);
        OutputView.printWinners(winners);
    }

    private List<Car> findWinners(List<Car> cars) {
        Car maxPositionCar = cars.stream()
                .max((c1, c2) -> c1.getPosition() - c2.getPosition())
                .get();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPositionCar.getPosition())
                .collect(Collectors.toList());
    }
}
