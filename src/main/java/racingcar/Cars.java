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
        if (names.length < 1) throw new IllegalArgumentException();

        System.out.println("size : " + names.length);
        // TODO : 메소드 분동
        if (names.length != Arrays.stream(names).distinct().count()) throw new IllegalArgumentException();

        Cars instance = new Cars();
        instance.cars.addAll(Arrays.stream(names)
                .map(Car::create)
                .toList());

        return instance;
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
