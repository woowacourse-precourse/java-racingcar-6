package model;

import util.ErrorMessages;
import util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.StringUtils.splitByDelimiter;
import static util.StringUtils.stripStringArray;

/**
 * packageName    : model
 * fileName       : Cars
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class Cars {

    private static final String DELIMITER = ",";
    private static final int MIN = 0;
    private static final int MAX = 9;

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        String[] carNameArray = stripStringArray(splitByDelimiter(carNames, DELIMITER));
        validateDuplicatedName(carNameArray);
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }

    private void validateDuplicatedName(String[] carNames) {
        long distinctSize = Arrays.stream(carNames)
                .distinct().count();
        if (distinctSize != carNames.length) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATED_NAME);
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.goOrStop(RandomGenerator.generateNumber(MIN, MAX + 1));
        }
    }
}
