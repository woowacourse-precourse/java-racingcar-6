package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class Circuit {

    private static final int START_INCLUSIVE = 0;

    private static final int END_INCLUSIVE = 9;

    private List<Car> cars;

    public Circuit(List<Car> cars) {
        this.cars = cars;
    }

    public void run() {
        cars = cars.stream()
                .map((car) -> car.runAndReturnNewCar(createRandomNumber()))
                .toList();
    }

    private Long createRandomNumber() {
        int randomNum = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return (long) randomNum;
    }

    public String getWinner() {
        Long maxPosition =
                cars.stream()
                        .mapToLong(Car::getPosition)
                        .max()
                        .orElseThrow(() -> new NoSuchElementException("서킷에서 관리하는 차들이 없습니다"));

        return cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    public void printCarsTrace() {
        cars.forEach(car -> System.out.println(car.getCarStatus()));
        System.out.println();
    }

}
