package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validation.CarValidator;

public class RacingCar {

    private final List<Car> cars;

    public RacingCar(String userInput) {
        List<String> carNames = splitInputByComma(userInput);
        CarValidator.validateCarNameList(carNames);
        List<Car> cars = carNames.stream().map(Car::new).toList();
        CarValidator.validateCarListSize(cars);
        this.cars = cars;
    }

    RacingCar(List<Car> cars) {
        this.cars = cars;
    }

    public void moveRandomAllCar() {
        cars.forEach(car -> car.moveForward(createRandomNumber()));
    }

    public List<Car> findWinners() {
        Integer maxDistance = findMaxDistance();
        return findCarsMovingSameDistance(maxDistance);
    }

    public List<Car> getCars() {
        return cars;
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private Integer findMaxDistance() {
        int max = Integer.MIN_VALUE;
        for (Car car : cars) {
            max = Math.max(car.getTravelDistance(), max);
        }
        return max;
    }

    private List<Car> findCarsMovingSameDistance(Integer distance) {
        return this.cars.stream()
                .filter(car -> car.getTravelDistance().equals(distance))
                .collect(Collectors.toList());
    }

    private List<String> splitInputByComma(String userInput) {
        return Arrays.asList(userInput.split(","));
    }
}
