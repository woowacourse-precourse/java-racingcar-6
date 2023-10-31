package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private static List<Car> cars;

    public Cars(List<Car> cars) {
        validateNumberOfParticipants(cars);
        validateDuplicateName(cars);
        this.cars = cars;
    }

    public void move(List<Integer> moveNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (moveNumbers.get(i) > 3)
                car.move();
        }
    }

    public Winner getWinner() {
        Car maxPositionCar = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(IllegalStateException::new);

        List<Car> winner = cars.stream()
                .filter(c -> c.getPosition() == maxPositionCar.getPosition())
                .collect(Collectors.toList());

        return new Winner(winner);
    }

    public int getNumberOfPeople() {
        return cars.size();
    }

    public List<String> getCarsName() {
        List<String> nameOfCars = new ArrayList<>();
        for (Car car : cars) {
            nameOfCars.add(car.getName());
        }
        return nameOfCars;
    }

    public List<Integer> getCarsCurrentPosition() {
        List<Integer> carsCurrentPosition = new ArrayList<>();
        for (Car car : cars) {
            int currentPosition = car.getPosition();
            carsCurrentPosition.add(currentPosition);
        }
        return carsCurrentPosition;
    }

    public void validateNumberOfParticipants(List<Car> cars) {
        if (cars.size() < 2)
            throw new IllegalArgumentException("참가 자동차 부족");
    }

    public void validateDuplicateName(List<Car> cars) {
        List<String> carsName = cars.stream().map(Car::getName).toList();
        Set<String> distinctName = new HashSet<>(carsName);
        if (carsName.size() != distinctName.size())
            throw new IllegalArgumentException("이름 중복");
    }

}
