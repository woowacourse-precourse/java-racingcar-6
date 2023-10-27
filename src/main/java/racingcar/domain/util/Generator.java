package racingcar.domain.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.carcomponent.carmove.CarMoveReader;

public class Generator {
    private static final int SMALLEST_NUMBER_FOR_RANDOM = 0;
    private static final int LARGEST_NUMBER_FOR_RANDOM = 9;
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String ATTEMPT_TIME_NOT_NUMBER_ERROR = "시도 횟수는 숫자를 입력해야 합니다.";


    public static Cars generaterCars(String carNames) {
        return new Cars(generateCars(carNames));
    }

    public static CarMoveReader generateCarMoveReader(String attemptTime) {
        try {
            int times = Integer.parseInt(attemptTime);
            return new CarMoveReader(times);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_TIME_NOT_NUMBER_ERROR);
        }
    }

    public static Supplier<Boolean> randomCarMoveGenerator() {
        return () -> Randoms.pickNumberInRange(SMALLEST_NUMBER_FOR_RANDOM, LARGEST_NUMBER_FOR_RANDOM) >= MINIMUM_NUMBER_TO_MOVE;
    }

    private static List<Car> generateCars(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
