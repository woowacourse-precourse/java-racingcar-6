package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    static private final String MARK = "-";

    final private List<Car> cars;
    final private int time;

    public Race() {
        String[] names = Screen.askCarNames();
        time = Screen.askRacingTime();
        cars = new ArrayList<>();

        for (String name : names)
            cars.add(new Car(name));
    }

    public Race(List<Car> cars, int time) {
        this.cars = cars;
        this.time = time;
    }

    public boolean isRunning(int time) {
        return time < this.time;
    }

    public void runOneRound() {
        for (Car car : cars) {
            car.moveFoward(Randoms.pickNumberInRange(0, 9));
        }
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();

        for (Car car : cars) {
            result.append(String.format("%s : %s\n", car.getName(), MARK.repeat(car.getNumberOfMove())));
        }
        return result.toString();
    }

    public String getWinners() {
        StringBuilder winners = new StringBuilder();
        int maximumMove = Collections.max(cars).getNumberOfMove();

        for (Car car : cars) {
            if (car.getNumberOfMove() == maximumMove) {
                winners.append(", ");
                winners.append(car.getName());
            }
        }
        return winners.toString().replaceFirst(", ", "");
    }
}
