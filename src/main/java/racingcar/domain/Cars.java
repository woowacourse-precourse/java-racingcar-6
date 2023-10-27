package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final int START_LINE = 0;

    private List<Car> cars;

    public Cars(List<String> carNames) {
        cars = new ArrayList<>(carNames.size());
        for (int index = 0; index < carNames.size(); index++) {
            String carName = carNames.get(index);
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public List<Car> moveAllCar() {
        for (int index = 0; index < cars.size(); index++) {
            int randomNumber = generateRandomNumber();
            moveCarIfBiggerThanThree(randomNumber, index);
        }
        return cars;
    }

    private void moveCarIfBiggerThanThree(int randomNumber, int index) {
        if (randomNumber > 3) {
            moveCar(index);
        }
    }

    private void moveCar(int index) {
        Car car = cars.get(index);
        car.move();
    }

    private int generateRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int number = randomNumberGenerator.generateNumber();
        return number;
    }

    public Winners findWinner() {
        List<String> winnerList = new ArrayList<>();
        int furthestDistance = findFurthestDistance();
        for (Car car : cars) {
            if (car.isFurthestDistance(furthestDistance)) {
                car.registerOnWinnerList(winnerList);
            }
        }
        Winners winners = new Winners(winnerList);
        return winners;
    }

    private int findFurthestDistance() {
        int position = START_LINE;
        for (Car car : cars) {
            position = car.comparePosition(position);
        }
        return position;
    }
}
