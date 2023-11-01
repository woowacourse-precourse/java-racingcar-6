package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Verification {
    public boolean isFiveOrLess(String carName) {
        String[] split = carName.split("");
        return split.length <= 5;
    }

    public void duplicate(List<String> cars) {
        Stream<String> stream = Stream.of(cars.toArray(new String[0]));
        Set<String> set = new HashSet<>();
        Set<String> collect = stream.filter(n -> !set.add(n))
                .collect(Collectors.toSet());

        if (collect.size() > 0) {
            throw new IllegalArgumentException();
        }
    }

    public void isPositive(int moveTime) {
        if (moveTime <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
