package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class Cars {

    private final List<Car> cars = new ArrayList<>();
    private final Roulette roulette;

    Cars(Roulette roulette, String inputNames) {
        this.roulette = roulette;

        String[] names = inputNames.split(Constant.COMMA.value, -1);
        validateNames(names);

        cars.addAll(Arrays.stream(names)
                .map(Car::new)
                .toList());
    }

    private void validateNames(String[] names) {
        var uniqueNameCount = Arrays.stream(names).distinct().count();
        if (names.length < 1 || names.length != uniqueNameCount) throw new IllegalArgumentException();
    }

    enum Constant {
        COMMA(","),
        ;

        String value;

        Constant(String value) {
            this.value = value;
        }
    }

}
