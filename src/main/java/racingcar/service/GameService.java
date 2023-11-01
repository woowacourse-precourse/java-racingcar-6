package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

public class GameService {
    private static final int CAR_NAME_MAX_NUMBER = 5;
    private static final int MOVE_MIN_NUMBER = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    public List<Car> createCars(String inputCarNames) {
        List<String> carNames = Arrays.stream(inputCarNames.split(",")).toList();
        List<Car> cars = carNames.stream()
                .filter(this::validateCarName)
                .map(Car::new)
                .toList();

        return cars;
    }

    private boolean validateCarName(String carName) {
        if (carName.length() > CAR_NAME_MAX_NUMBER) {
            throw new IllegalArgumentException("자동차의 이름이 5자를 초과합니다.");
        }

        return true;
    }

    public void playOneAttempt(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = getRandomNumber();
            if (moveForwardOrNot(randomNumber)) {
                car.moveForward();
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    private boolean moveForwardOrNot(int number) {
        return number >= MOVE_MIN_NUMBER;
    }

    public List<Car> getWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return getCowinner(cars, maxPosition);
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .mapToInt(position -> position)
                .max().orElse(0);
    }

    private List<Car> getCowinner(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public void validateAttemptNumber(String attemptNumber) {
        try {
            Integer.parseInt(attemptNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력입니다.");
        }
    }
}
