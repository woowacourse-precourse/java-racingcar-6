package racingcar.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.util.ExceptionUtil;

public class Participations { // 일급컬렉션
    private List<Car> cars;
    private final String DUPLICATE_NAME_MESSAGE = "중복된 이름은 입력할 수 없습니다.";

    private Participations(List<Car> carList) {
        validateDuplicatedName(carList);
        cars = carList;
    }

    public static Participations create(List<Car> carList) {
        return new Participations(carList);
    }

    public List<Car> getParticipations() {
        return cars;
    }

    public int size() {
        return cars.size();
    }

    public int calcMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getLastPosition)
                .max()
                .orElse(0);
    }

    private void validateDuplicatedName(List<Car> carList) {
        Set<String> carNamesSet = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (carNamesSet.size() != carList.size()) {
            ExceptionUtil.throwInvalidValueException(DUPLICATE_NAME_MESSAGE);
        }
    }
}
