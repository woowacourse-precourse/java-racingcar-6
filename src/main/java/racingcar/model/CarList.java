package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class CarList {
    private final List<Car> carList = new ArrayList<>();


    public void addCar(Car car) {
        carList.add(car);
    }

    public int getNumberOfCars() {
        return carList.size();
    }

    public List<Car> provideRacingCars() {
        return carList;
    }

    public void updateCarsPosition(List<Boolean> movementResult) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).calculatePosition(movementResult.get(i));
        }
    }

    public List<Car> calculateWinningCars() {
        int highestPosition = findHighestPosition();
        return findFastestCars(highestPosition);
    }

    private List<Car> findFastestCars(int highestPosition) {
        return carList.stream()
                .filter((car)-> car.provideCarStatus().get("position").equals(highestPosition))
                .collect(Collectors.toList());
    }

    private int findHighestPosition() {
        return carList.stream()
                .map((car) -> (Integer) car.provideCarStatus().get("position"))
                .max(Comparator.comparingInt(Integer::intValue))
                .orElseThrow(() -> new NoSuchElementException());
    }
}
