package racingcar.domain;

import java.util.*;

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

    public int getMaxLocation() {
        List<Integer> carLocations = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            carLocations.add(car.getLocation());
        }
        return Collections.max(carLocations);
    }

    public Winner getWinner() {
        List<Car> winner = new ArrayList<>();
        int maxLocation = getMaxLocation();
        for (Car car : cars) {
            int location = car.getLocation();
            if (location == maxLocation)
                winner.add(car);
        }
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

    public List<Integer> getCarsCurrentLocation() {
        List<Integer> carsCurrentLocation = new ArrayList<>();
        for (Car car : cars) {
            int currentLocation = car.getLocation();
            carsCurrentLocation.add(currentLocation);
        }
        return carsCurrentLocation;
    }

    public void validateNumberOfParticipants(List<Car> cars) {
        if (cars.size() < 2)
            throw new IllegalArgumentException("참가 인원 부족");
    }

    public void validateDuplicateName(List<Car> cars) {
        List<String> carsName = cars.stream().map(Car::getName).toList();
        Set<String> distinctName = new HashSet<>(carsName);
        if (carsName.size() != distinctName.size())
            throw new IllegalArgumentException("이름 중복");
    }

}
