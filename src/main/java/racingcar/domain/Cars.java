package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public void add(String name) {
        cars.add(new Car(name));
    }

    public void racing() {
        for (Car car : cars) {
            car.race(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<Car> giveResult() {
        List<Car> result = Collections.unmodifiableList(cars);//읽을 수만 있게 반환
        return result;
    }

    public int maxMovement() {
        int maxValue = 0;
        for (Car car : cars) {
            maxValue = Math.max(maxValue, car.getMovement());
        }
        return maxValue;
    }

    public String findWinner() {
        List<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMovement() == maxMovement()) {
                winnerList.add(car.getName());
            }
        }
        String winner = String.join(",", winnerList);
        return winner;
    }
}
