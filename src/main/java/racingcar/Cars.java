package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class Cars {

    private final List<Car> cars = new ArrayList<>();

    private Cars() {
    }

    static Cars create(String input, Roulette roulette) {
        String[] names = input.split(Constant.COMMA.value, -1);
        validateNames(names);

        Cars instance = new Cars();
        instance.cars.addAll(Arrays.stream(names)
                .map(Car::create)
                .toList());

        return instance;
    }

    private static void validateNames(String[] names) {
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
