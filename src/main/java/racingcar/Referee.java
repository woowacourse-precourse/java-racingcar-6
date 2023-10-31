package racingcar;


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
        for (Car car : cars) {
            if (car.distance.size() == maxDistance) {
                System.out.print(car.name + " ");
            }
        }
    }
}
