package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Racing;
import racingcar.domain.car.Car;
import racingcar.view.InputView;
import racingcar.view.OutView;

public class RacingCar {

    public void play() {
        List<Car> cars = getCars();
        int raceCount = getRaceCount();
        runRace(cars, raceCount);
    }

    private List<Car> getCars() {
        OutView.printCarNames();
        String[] carNames = InputView.promptForCarNames();
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int getRaceCount() {
        OutView.printNumberOfAttempts();
        return InputView.promptNumberOfAttempts();
    }

    private void runRace(List<Car> cars, int raceCount) {
        Racing racing = new Racing(cars);
        OutView.printResults();
        for (int i = 0; i < raceCount; i++) {
            racing.start();
            OutView.printRaceResults(racing.getAllCarDistances());
        }
        OutView.printFinalWinner(racing.getCarWithLongestDistance());
    }

}
