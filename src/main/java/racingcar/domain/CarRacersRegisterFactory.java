package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class CarRacersRegisterFactory {

    public static CarRacers of(List<String> racerNames) {
        validateDuplicates(racerNames);
        List<Car> races = racerNames.stream()
                .map((name) -> new Car(name, new CarMovementController()))
                .toList();
        return new CarRacers(races);
    }

    private static void validateDuplicates(List<String> racerNames) {
        final List<String> duplicateNames = filterDuplicates(racerNames);
        if (!duplicateNames.isEmpty()) {
            throw new IllegalArgumentException(String.format("Duplicate racer names: %s", duplicateNames));
        }
    }

    private static List<String> filterDuplicates(List<String> racerNames) {
        return racerNames.stream()
                .filter(name -> Collections.frequency(racerNames, name) > 1)
                .distinct()
                .toList();
    }
}
