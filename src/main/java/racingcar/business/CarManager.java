package racingcar.business;

import java.util.*;
import java.util.stream.Collectors;

public class CarManager {

    private List<Car> carList = new ArrayList<>();
    private NumberMaker numberMaker;

    public CarManager(NumberMaker numberMaker) {
        this.numberMaker = numberMaker;
    }

    public void generateCarList(List<String> names) {
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public List<Car> runMatch() {
        for (Car car : carList) {
            makeCarMove(car);
        }

        return new ArrayList<>(carList);
    }

    private void makeCarMove(Car car) {
        int randomNumber = numberMaker.getRandomNumber();
        car.moveCar(randomNumber);
    }

    public List<String> getWinnerNames() {
        Integer maxDistance = getMaxDistance();

        return carList.stream().filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Integer getMaxDistance() {
        Optional<Car> maxDistanceCar = carList.stream().max(Comparator.comparingInt(Car::getDistance));
        Integer maxDistance = maxDistanceCar.get().getDistance();
        return maxDistance;
    }

}
