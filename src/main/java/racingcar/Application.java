package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carNames = InputConsole.enterCarNames();
        int round = InputConsole.enterRound();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        Race race = new Race(round, cars);
        race.start();

        OutputConsole.printWinners(race.getWinners());
    }
}
