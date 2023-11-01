package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarManager {

    private final List<Car> cars;
    private final List<Car> winner;

    public CarManager(List<Car> cars) {
        this.cars = cars;
        this.winner = new ArrayList<>();
    }

    public int maxPosition() {
        int max = Integer.MIN_VALUE;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void attempt(int attempt) {
        for (int i = 0; i < attempt; i++) {
            for (Car car : cars) {
                int random = Randoms.pickNumberInRange(0, 9);
                car.move(random);
            }
            System.out.println();
        }
    }

    public List<Car> winner(int max) {

        for (Car car : cars) {
            if (car.getPosition() == max) {
                winner.add(car);
            }
        }
        return winner;
    }
}
