package racingcar.domain;

import java.util.List;
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
    }

    private void playUnitRaceGame() {
        cars.forEach(Car::move);
        OutputView.printUnitGameResult(this.cars);
    }
}
