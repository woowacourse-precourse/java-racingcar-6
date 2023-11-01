package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public class TypeConverter {
    private static final int INIT_POSITION = 0;

    private TypeConverter() {
        throw new IllegalArgumentException();
    }

    public static List<Car> convertStringArrayToCarList(String[] carNames) {
        return Arrays.stream(carNames)
                .map(name -> new Car(name, INIT_POSITION))
                .toList();
    }

    public static int convertStringToInt(String round) {
        return Integer.parseInt(round);
    }
}
