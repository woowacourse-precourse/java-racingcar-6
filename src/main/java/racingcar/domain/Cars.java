package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;
    Output output = new Output();

    public Cars(List<String> carNames) {
        cars = new ArrayList<>(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            Car car = new Car(carNames.get(i));
            cars.add(car);
        }
    }

    public List<Car> move() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = randomNumberGenerator.generateNumber();
            Car car = cars.get(i);
            moveIfGreaterThanThree(car, randomNumber);
        }
        return cars;
    }

    private void moveIfGreaterThanThree(Car car, int randomNumber) {
        if (randomNumber > 3) {
            car.move();
        }
    }

    public List<String> whosWinner() {
        List<String> winners = new ArrayList<>();
        int furthestDistance = findFurthestDistance();
        for (Car car : cars) {
            if (car.getPosition() == furthestDistance)
                winners.add(car.getName());
        }
        return winners;
    }

    private int findFurthestDistance() {
        int furthestDistance = 0;
        for (Car car : cars) {
            if (car.getPosition() > furthestDistance)
                furthestDistance = car.getPosition();
        }
        return furthestDistance;
    }
}
