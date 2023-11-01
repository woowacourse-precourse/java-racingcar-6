package racingcar.domain.racing;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.racing.car.Car;
import racingcar.util.ExceptionUtil;
import racingcar.util.StringUtil;

/**
 * 참가자들의 목록을 관리하는 일급 컬렉션입니다.
 */
public class Participations {

    private final String EMPTY_INPUT_MESSAGE = "자동차 이름을 하나 이상 입력하세요.";
    private final String DUPLICATE_NAME_MESSAGE = "중복된 이름은 입력할 수 없습니다.";
    private List<Car> cars;

    private Participations(String carNames) {
        carNames = StringUtil.deleteAllSpaces(carNames);
        List<Car> carList = processCarNamesInput(carNames);
        validateCars(carNames, carList);

        cars = carList;
    }

    private Participations(List<Car> carList) {
        validateDuplicatedName(carList);
        cars = carList;
    }

    public static Participations create(String carNames) {
        return new Participations(carNames);
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
                .mapToInt(Car::calcMaxPosition)
                .max()
                .orElse(0);
    }

    private List<Car> processCarNamesInput(String carNames) {
        return Car.createList(StringUtil.parseListseperatedByComma(carNames));
    }

    private void validateEmptyInput(String input, List<Car> carList) {
        if (input.isEmpty() || carList.isEmpty()) {
            ExceptionUtil.throwInvalidValueException(EMPTY_INPUT_MESSAGE);
        }
    }

    private void validateDuplicatedName(List<Car> carList) {
        Set<String> carNamesSet = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (carNamesSet.size() != carList.size()) {
            ExceptionUtil.throwInvalidValueException(DUPLICATE_NAME_MESSAGE);
        }
    }

    private void validateCars(String carNames, List<Car> carList) {
        validateEmptyInput(carNames, carList);
        validateDuplicatedName(carList);
    }
}
