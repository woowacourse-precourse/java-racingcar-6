package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Judgment {
    // 차 이름, 전진 모양, 횟수
    List<Car> cars = new ArrayList<>();
    List<Car> winnerCars = new ArrayList<>();
    Car maxMovementCar = cars.stream().max(Comparator.comparing(Car::getForwardMovementNumber)).get();
    Integer maxMovement = maxMovementCar.forwardMovementNumber;

    public List<Integer> getMovement(List<Car> cars) {
        this.cars = cars;
        List<Integer> movementNumbers = new ArrayList<>();

        for (Car car: cars) {
            movementNumbers.add(car.forwardMovementNumber);
        } return movementNumbers;
    }


    public List<Integer> extractWinnerCarIndex() {
        List<Integer> getMovement = getMovement(cars);
        List<Integer> getWinnerCarMovement = getMovement(winnerCars);

        for (Integer movement: getMovement) {
            if (movement.equals(maxMovement)) {
                getWinnerCarMovement.add(getMovement.indexOf(movement));
            }
        }
        return getWinnerCarMovement;
    }

    public boolean checkJointWinner() {
        List<Integer> extractWinnerCar = extractWinnerCarIndex();
        return extractWinnerCar.size() != 0;
    }

    public List<String> getWinnerCarName() {
        List<Integer> getWinnerIndex = extractWinnerCarIndex();
        List<String> getWinnerCarName = new ArrayList<>();

        for (Integer index: getWinnerIndex) {
            getWinnerCarName.add(cars.get(index).carName);
        }
        return getWinnerCarName;
    }
}
