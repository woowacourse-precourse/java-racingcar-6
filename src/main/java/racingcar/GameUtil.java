package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class GameUtil {

    public static Cars inputToCars(String input) {
        String[] carNames = input.split(",");
        validateInputSize(carNames);

        List<Car> cars = new ArrayList<>();
        IntStream.range(0, carNames.length).forEach(i -> {
            cars.add(i, new Car(carNames[i]));
        });

        return new Cars(cars);
    }

    public static void validateInputSize(String[] carNames) {
        Arrays.stream(carNames).forEach(carName -> {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("잘못된 값 입니다.");
            }
        });
    }

}
