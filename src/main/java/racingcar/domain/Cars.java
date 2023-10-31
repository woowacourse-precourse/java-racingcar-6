package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.InputValidator;
import racingcar.view.View;

public class Cars {
    private static final int FIRST_IDX = 0;
    private static final int RAND_MIN = 0;
    private static final int RAND_MAX = 9;
    private static final int MOVE_CRITERIA = 4;

    private final List<Car> cars;
    private final View view = new View();

    public Cars(String names) {
        String[] splitNames = names.split(",");
        cars = Arrays.stream(splitNames)
                .map(name -> new Car(name.strip()))
                .collect(Collectors.toList());
        validateCarNames();
    }

    private void validateCarNames() {
        InputValidator validator = new InputValidator();
        validator.nameNonInputValidate(cars.size(), firstElement().getName());
        for (Car car : cars) {
            validator.nameLengthValidate(car);
        }
    }

    private Car firstElement() {
        return cars.get(FIRST_IDX);
    }

    public void roundStatus(int round) {
        for (int i = FIRST_IDX; i < round; i++) {
            printRoundResult();
        }
    }

    private void printRoundResult() {
        for (Car car : cars) {
            updatePositionComparedToRandNum(car);
            view.carResultMsg(car.getName(), car.process());
        }
        view.printEmptyLine();
    }

    private void updatePositionComparedToRandNum(Car car) {
        int randNum = Randoms.pickNumberInRange(RAND_MIN, RAND_MAX);
        if (randNum >= MOVE_CRITERIA) {
            car.updatePosition();
        }
    }

    public List<String> findWinners() {
        Car frontLineCar = findMaxPositionCar();

        return cars.stream()
                .filter(frontLineCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("컬렉션 내부에 자동차가 존재하지 않습니다!"));
    }
}
