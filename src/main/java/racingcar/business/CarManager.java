package racingcar.business;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarManager {

    public static final int MIN_NUMBER_RANGE = 0;
    public static final int MAX_NUMBER_RANGE = 9;

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
        int randomNumber = getRandomNumber();
        car.moveCar(randomNumber);
    }

    public Integer getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }

    public String getWinnerNames() {
        Optional<Car> maxDistanceCar = carList.stream().max(Comparator.comparingInt(Car::getDistance));
        Integer maxDistance = maxDistanceCar.get().getDistance();

        return carList.stream().filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
