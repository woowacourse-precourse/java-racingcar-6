package racingcar;

import domain.Car;
import domain.Race;
import ui.InputView;
import ui.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        List<Car> cars = createCars(carNames);
        int numberOfTries = InputView.inputNumberOfTries();
        System.out.println("실행 결과");
        Race race = new Race(cars);

        race.runRace(numberOfTries);

        List<Car> winners = race.findWinners();
        ResultView.printWinners(winners);
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}