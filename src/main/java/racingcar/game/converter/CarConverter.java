package racingcar.game.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.game.domain.Car;
import racingcar.game.domain.RandomizedCarEngine;
import racingcar.util.StringUtils;

public class CarConverter {
    public static List<Car> inputToListOfCars(String rawInput) {
        var userNames = Arrays.stream(rawInput.split(",", -1)).toList();
        boolean isAllNamesValid = userNames.stream()
                .allMatch(name -> StringUtils.validUnicodeLengthOf(name) <= 5);
        if (!isAllNamesValid) {
            throw new CarNameFormatException();
        }
        return userNames.stream()
                .map(name -> new Car(name, new RandomizedCarEngine()))
                .collect(Collectors.toList());
    }

    public static int inputToTryCount(String rawInput) {
        int n = Integer.parseInt(rawInput);
        if (n < 0) {
            throw new NumberFormatException();
        }
        return n;
    }

    private static class CarNameFormatException extends IllegalArgumentException {
    }
}
