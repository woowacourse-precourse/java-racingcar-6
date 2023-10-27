package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Cars {

    private final List<Car> cars = new ArrayList<>();
    private static final String DELIMITER = ",";

    Cars(String input) {
        String[] names = input.split(DELIMITER);
        if(names.length < 1) throw new IllegalArgumentException();

        // TODO : 메소드 분리
        if(names.length != Arrays.stream(names).distinct().count()) throw new IllegalArgumentException();

        cars.addAll(Arrays.stream(names)
                .map(Car::new)
                .toList());
    }


}
