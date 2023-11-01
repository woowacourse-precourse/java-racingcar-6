package racingcar;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee {

    public int checkMaxDistance(List<Car> cars) {
        int maxDistance = cars.get(0).distance.size();
        for (Car car : cars) {
            if (maxDistance < car.distance.size()) {
                maxDistance = car.distance.size();
            }
        }
        return maxDistance;
    }

    public void showWinners(List<Car> cars) {
        int maxDistance = checkMaxDistance(cars);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.distance.size() == maxDistance) {
                winners.add(car.name);
            }
        }
        System.out.println(String.join(", ",winners));
    }
}
