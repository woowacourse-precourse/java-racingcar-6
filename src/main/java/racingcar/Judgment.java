package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Judgment {
    List<Car> cars = new ArrayList<Car>();
    List<Car> winnerCars = new ArrayList<Car>();
    Car maxMovementCar = cars.stream().max(Comparator.comparing(Car::getForwardMovementNumber)).get();
    Integer maxMovement = maxMovementCar.forwardMovementNumber;

    public List<Integer> getMovement(List<Car> cars) {
        this.cars = cars;
        List<Integer> movementNumbers = new ArrayList<Integer>();

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
        List<String> getWinnerCarName = new ArrayList<String>();

        for (Integer index: getWinnerIndex) {
            getWinnerCarName.add(cars.get(index).carName);
        }
        return getWinnerCarName;
    }
}
