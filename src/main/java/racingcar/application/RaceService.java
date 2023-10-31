package racingcar.application;

import static racingcar.global.constants.NumberType.*;
import static racingcar.global.constants.SymbolType.DELIMITER;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;

public class RaceService {
    public Cars generateCars(String rawNames) {
        return Cars.of(parseStringToList(rawNames));
    }

    public Integer generateCount(String countInput) {
        Integer count = parseStringToInteger(countInput);
        return count;
    }

    private Integer parseStringToInteger(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식으로 입력해주세요");
        }
    }

    private List<String> parseStringToList(String names) {
        return Arrays.stream(splitNames(names))
                .map(String::new)
                .toList();
    }

    private String[] splitNames(String names) {
        return names.split(DELIMITER.getSymbol());
    }
}
