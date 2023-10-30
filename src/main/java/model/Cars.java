package model;

import util.ErrorMessages;
import util.RandomGenerator;

import java.util.*;

import static util.StringUtils.*;

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
    private static final int CARS_SIZE = 2;

    private final List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public Cars(String carNames) {
        String[] carNameArray = stripStringArray(splitByDelimiter(notSplit(carNames), DELIMITER));

        validateDuplicatedName(carNameArray);

        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }

    private void validateDuplicatedName(String[] carNames) {
        long distinctSize = Arrays.stream(carNames).distinct().count();
        if (distinctSize != carNames.length) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATED_NAME);
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.goOrStop(RandomGenerator.generateNumber(MIN, MAX));
        }
    }

    public Winners getWinners() {
        return new Winners(cars);
    }
}
