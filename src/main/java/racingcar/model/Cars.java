package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void add(String name) {
        Car car = new Car(name, 0);
        cars.add(car);
    }

    public void moveAll() {
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            car.move(randomNumber);
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxDistance == car.getDistance()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
