package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    private List<Car> cars = new ArrayList<>();

    public Race(String[] carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void start(int rounds) {
        for (int i = 0; i < rounds; i++) {
            round();
            System.out.println();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void round() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
            System.out.println(car);
        }
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.toString().split(" : ")[0]);
            }
        }
        return winners;
    }
}
