package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<String> names) {
        validateDuplicate(names);
        this.cars = names.stream()
                .map(Car::withName)
                .toList();
    }

    private void validateDuplicate(final List<String> names) {
        final Set<String> uniqueNames = new HashSet<>(names);

        if (names.size() != uniqueNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static Cars fromNames(final List<String> names) {
        return new Cars(names);
    }
}
