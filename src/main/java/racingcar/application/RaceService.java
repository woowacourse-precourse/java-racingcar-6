package racingcar.application;

import static racingcar.global.constants.SymbolType.DELIMITER;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;

public class RaceService {
    public Cars generateCars(String rawNames) {
        return Cars.of(parseStringToList(rawNames))
    }

    private static List<String> parseStringToList(String names) {
        return Arrays.stream(splitNames(names))
                .map(String::new)
                .toList();
    }

    private static String[] splitNames(String names) {
        return names.split(DELIMITER.getSymbol());
    }
}
