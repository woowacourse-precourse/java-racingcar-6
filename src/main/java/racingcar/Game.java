package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.ui.OutputView;

public class Game {
    private final List<Car> cars;
    private final int round;

    public Game(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void play() {
        for (int i = 0; i < round; i++) {
            System.out.print(OutputView.ENTER);
            for (int j = 0; j < cars.size(); j++) {
                int number = NumberGenerator.generate();
                cars.get(j).move(number);

                OutputView.printGameResult(cars.get(j), cars.get(j).getDistance());
            }
        }
        OutputView.printWinners(findWinners(findMaxDistance()));
    }

    private int findMaxDistance() {
        int maxDistance = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getDistance() >= maxDistance) {
                maxDistance = cars.get(i).getDistance();
            }
        }
        return maxDistance;
    }

    private List<Car> findWinners(int maxDistance) {
        List<Car> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getDistance() == maxDistance) {
                winners.add(cars.get(i));
            }
        }
        return winners;
    }
}
