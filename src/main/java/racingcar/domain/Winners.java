package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Winners {
    private List<Car> winners;

    public Winners(List<Car> cars) {
        winners = new ArrayList<>();
        decideWinners(cars);
    }

    public void printWinners() {
        OutputView.printWinners(winners);
    }
    private void decideWinners(List<Car> cars) {
        cars.sort(Comparator.reverseOrder());

        Car firstWinner = cars.get(0);
        int carIndex = 0;
        while (carIndex < cars.size() && nextCarIsWinner(cars.get(carIndex), firstWinner)) {
            winners.add(cars.get(carIndex));
            carIndex++;
        }
    }

    private boolean nextCarIsWinner(Car car, Car winner) {
        return (car.compareTo(winner) == 0);
    }
}
