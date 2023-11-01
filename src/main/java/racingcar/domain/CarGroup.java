package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.util.ErrorMessage;

public class CarGroup {

    private final List<Car> carList = new ArrayList<>();

    private CarGroup(String carNames) {
        validateNullOrEmpty(carNames);
        createCarListByNames(carNames);
    }

    private void validateNullOrEmpty(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_NULL_OR_EMPTY.getMessage());
        }
    }

    private void createCarListByNames(String carNames) {
        List<String> nameList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .toList();

        for (String name : nameList) {
            validateUniqueName(name);
            carList.add(new Car(name));
        }
    }

    private void validateUniqueName(String name) {
        boolean hasDuplicate = carList.stream()
                .anyMatch(car -> car.getName().equals(name));
        if (hasDuplicate) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_NOT_UNIQUE.getMessage());
        }
    }

    public static CarGroup createNewCarGroupByNames(String carNames) {
        return new CarGroup(carNames);
    }

    public int size() {
        return carList.size();
    }

    public List<Car> getList() {
        return Collections.unmodifiableList(carList);
    }

    public void run() {
        carList.forEach(car -> car.run(Randoms.pickNumberInRange(0, 9)));
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition() {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get()
                .getPosition();
    }
}
