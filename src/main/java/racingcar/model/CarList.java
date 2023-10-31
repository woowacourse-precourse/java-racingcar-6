package racingcar.model;

import racingcar.util.Utils;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private final List<Car> cars = new ArrayList<>();

    public CarList(String carNames) {
        CarNameValidator validator = new CarNameValidator(carNames);
        validator.carNameList.stream().forEach(name -> cars.add(new Car(name)));
    }

    public void raceOneRound(CarList carList) {
        race(carList);
        printRoundResult(carList);
        System.out.println();
    }

    public void race(CarList carList) {
        carList.cars.stream().forEach(car -> car.getResult());
    }

    public void printRoundResult(CarList carList) {
        carList.cars.stream().forEach(car -> car.printRoundResult());
    }

    public void printFinalResult(CarList carList) {
       int maxDistance = Utils.getMaxDistance(carList.cars);
        String winners = cars.stream()
                .filter(car -> car.isWinner(maxDistance))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winners);
    }
}
