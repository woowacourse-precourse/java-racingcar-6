package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> carNames = InputView.getCars();
        int racingRound = InputView.getRacingRound();

        Race race = new Race(carNames, racingRound);
        race.start();

        ResultView.printWinners(race.getCars());
    }
}
