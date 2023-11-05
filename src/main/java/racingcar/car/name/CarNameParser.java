package racingcar.car.name;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameParser {

    private static final int MIN_CAR_COUNT = 1;
    private static final int MAX_CAR_COUNT = 20;

    public List<CarName> parse(String carNameLine) {
        List<CarName> carNameList = Arrays.stream(carNameLine.split(","))
                .map(String::trim)
                .map(CarName::new)
                .toList();

        validate(carNameList);

        return carNameList;
    }

    private void validate(List<CarName> carNameList) {
        if (carNameList.size() < MIN_CAR_COUNT || carNameList.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException("자동차의 수는 " + MIN_CAR_COUNT + "대부터 " + MAX_CAR_COUNT + "대까지 가능합니다.");
        }

        checkDuplicateNames(carNameList);
    }

    private void checkDuplicateNames(List<CarName> carNameList) {
        Set<CarName> uniqueNames = new HashSet<>(carNameList);
        if (uniqueNames.size() != carNameList.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }
}
