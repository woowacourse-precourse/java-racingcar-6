package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Cars {
    private final static String RESULT_MESSAGE = "실행 결과";

    private List<Car> list;

    public void inputCarName(String input) {
        this.list = splitCarName(input);
    }

    private List<Car> splitCarName(String input) {
        List<String> names = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
        checkValid(names);
        return createCar(names);
    }

    private List<Car> createCar(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void checkValid(List<String> names) {
        if (!checkValidName(names)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkValidName(List<String> names) {
        return isNotDuplicate(names)
                && isValidName(names);
    }

    private boolean isNotDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (names.size() == uniqueNames.size()) {
            return true;
        }
        return false;
    }

    private boolean isValidName(List<String> names) {
        for (String name : names) {
            if (isOverMaxLength(name) || isBlank(name)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOverMaxLength(String name) {
        return name.length() > 5;
    }

    private boolean isBlank(String name) {
        return name.length() == 0;
    }

    public void moveCars() {
        for (Car car : this.list) {
            if (canMove()) {
                car.moveCar();
            }
        }
    }

    private boolean canMove() {
        return pickNumberInRange(1, 9) >= 4;
    }

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
        printResultByCar();
    }

    public void printResultByCar() {
        for (Car car : list) {
            car.printPositionWithName();
        }
    }
}
