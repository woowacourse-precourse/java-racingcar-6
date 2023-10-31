package racingcar.domain;

import static racingcar.global.constants.NumberType.MIN_CAR_SIZE;

import java.util.List;

public class Cars {
    private List<Car> carList;

    private Cars(List<String> nameList) {
        validateNameList(nameList);
        this.carList = convertNameListToCarList(nameList);
    }

    public static Cars of(List<String> nameList) {
        return new Cars(nameList);
    }

    private List<Car> convertNameListToCarList(List<String> nameList) {
        return nameList.stream()
                .map(Car::of)
                .toList();
    }

    private void validateNameList(List<String> nameList) {
        validateListSize(nameList);
    }

    private void validateListSize(List<String> nameList) {
        if (hasSingleCar(nameList)) {
            throw new IllegalArgumentException(
                    String.format("%d대 이상의 자동차의 이름을 입력해주세요.", MIN_CAR_SIZE.getValue())
            );
        }
    }

    private boolean hasSingleCar(List<String> nameList) {
        return nameList.size() < MIN_CAR_SIZE.getValue();
    }
}