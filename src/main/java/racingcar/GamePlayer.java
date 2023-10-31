package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GamePlayer {
    private final List<Car> cars;
    private final int attempts;
    private final RandomNumber randomNumber;

    public GamePlayer(List<Car> cars, int attempts, RandomNumber randomNumber) {
        this.cars = cars;
        this.attempts = attempts;
        this.randomNumber = randomNumber;
    }

    public void play() {
        for (int i = 0; i < attempts; i++) {
            System.out.print(OutputView.ENTER);
            for (int j = 0; j < cars.size(); j++) {
                int number = randomNumber.generate();
                cars.get(j).move(randomNumber.judge(number));
                OutputView.printGameResult(cars.get(j), cars.get(j).getDistance());
            }
        }
        OutputView.printWinners(findWinners(findFurthestMovedCar()));
    }

    private Car findFurthestMovedCar() {
        Car furthestMovedCar = null;
        for (int i = 0; i < cars.size() - 1; i++) {
            int firstPlace = cars.get(i).compare(cars.get(i), cars.get(i + 1));
            if (firstPlace > 0) {
                furthestMovedCar = cars.get(i);
            }
            if (firstPlace <= 0) {
                furthestMovedCar = cars.get(i + 1);
            }
        }
        return furthestMovedCar;
    }

    private List<Car> findWinners(Car furthestMovedCar) {
        List<Car> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (furthestMovedCar.getDistance().size() == cars.get(i).getDistance().size()) {
                winners.add(cars.get(i));
            }
        }
        return winners;
    }
}
