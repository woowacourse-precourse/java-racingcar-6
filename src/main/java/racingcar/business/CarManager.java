package racingcar.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarManager {

    NumberMaker numberMaker = new NumberMaker();

    List<Car> carList = new ArrayList<>();

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

    public String getWinnerNames() {
        Optional<Car> maxDistanceCar = carList.stream().max(Comparator.comparingInt(Car::getDistance));
        Integer maxDistance = maxDistanceCar.get().getDistance();

        return carList.stream().filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
