package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Constants;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Utils {
    public static List<String> toList(String carNames) {
        return Arrays.asList(carNames.split(Constants.DIVIDE_BY_COMMA, -1));
    }

    public static String convertDistanceToSymbol(int distance) {
        StringBuilder result = new StringBuilder();
        IntStream.range(0, distance).forEach(i -> result.append(Constants.DISTANCE_CHARACTER));
        return result.toString();
    }

    public static int toInt(String roundNumber) {
        return Integer.parseInt(roundNumber);
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUM, Constants.MAX_RANDOM_NUM);
    }

    public static int getMaxDistance(List<Car> cars) {
        return cars.stream().mapToInt(Car::getDistance).max().orElse(0);
    }
}
