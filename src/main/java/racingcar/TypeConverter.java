package racingcar;

import java.util.Arrays;
import java.util.List;

public class TypeConverter {
    public static List<Car> convertStringArrayToCarList(String[] carNames) {
        return Arrays.stream(carNames)
                .map(name -> new Car(name, 0))
                .toList();
    }
}
