package racingcar;

import java.util.Arrays;
import java.util.List;

public class TypeConverter {
    private static final int INIT_POSITION = 0;

    public static List<Car> convertStringArrayToCarList(String[] carNames) {
        return Arrays.stream(carNames)
                .map(name -> new Car(name, INIT_POSITION))
                .toList();
    }
}
