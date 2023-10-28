package racingcar.domain;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Referee {
    int maxLength;
    List<String> winner;

    public Referee() {
        this.maxLength = 0;
        this.winner = new ArrayList<>();
    }

    public List<String> compareRacingStatus(List<Car> cars) {
        List<Integer> length = new ArrayList<>();
        for (Car car : cars) {
            length.add(car.getStatus().length());
        }

        TreeSet<Integer> sortLength = new TreeSet<>(length);
        maxLength = sortLength.last();

        determineWinner(cars);

        return winner;
    }

    private List<String> determineWinner(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            int status = cars.get(i).getStatus().length();
            if (status >= maxLength) {
                winner.add(cars.get(i).getName());
            }
        }
        return winner;
    }
}