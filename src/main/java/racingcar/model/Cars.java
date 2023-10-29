package racingcar.model;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    List<Car> racingCars = new ArrayList<>();

    public void addCar(Car car) {
        racingCars.add(car);
    }

    public int getNumberOfCars() {
        return racingCars.size();
    }

    public List<Car> provideRacingCars() {
        return racingCars;
    }

    public void updateCarsPosition(List<Boolean> moveResult) {
        for (int i = 0; i < racingCars.size(); i++) {
            racingCars.get(i).calculatePosition(moveResult.get(i));
        }
    }

    public List<Car> calculateFastestCar() {
        int highestPosition = findHighestPosition();
        return findFastestCars(highestPosition);
    }

    private List<Car> findFastestCars(int highestPosition) {
        return racingCars.stream()
                .filter((car)-> car.provideCarStatus().get("position").equals(highestPosition))
                .collect(Collectors.toList());
    }

    private int findHighestPosition() {
        return racingCars.stream()
                .map((car) -> (Integer) car.provideCarStatus().get("position"))
                .max(Comparator.comparingInt(Integer::intValue))
                .orElseThrow(NoSuchElementException::new);
    }

    private boolean isCoFastestCars() {
        Set<Integer> carPositions = new HashSet<>();
        for (Car car : racingCars) {
            carPositions.add((Integer) car.provideCarStatus().get("position"));
        }
        return carPositions.size() != racingCars.size();
    }
}
