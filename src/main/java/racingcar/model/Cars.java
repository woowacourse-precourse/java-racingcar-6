package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.utils.Constraints;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        checkNameLength(carNames);
        checkDuplicate(carNames);
        this.cars = makeCarList(carNames);
    }

    /**
     * 자동차 이름 길이 검증
     */
    private void checkNameLength(List<String> carNames) {
        carNames.stream()
                .filter(carName -> carName.length() > Constraints.MAX_SIZE.getValue())
                .forEach(carName -> {
                    throw new IllegalArgumentException("자동차의 이름은 " + Constraints.MAX_SIZE.getValue() + "보다 작아야 합니다.");
                });
    }

    /**
     * 중복된 자동차 이름 검증
     */
    private void checkDuplicate(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNames.size() != carNamesSet.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재 합니다.");
        }
    }

    /**
     * 자동차 이름 배열 -> 자동차 객체 배열로 변경
     */
    private List<Car> makeCarList(List<String> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
