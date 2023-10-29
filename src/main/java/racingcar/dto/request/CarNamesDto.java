package racingcar.dto.request;

import java.util.Arrays;
import java.util.List;

public class CarNamesDto {
    private static final String DELIMITER = ",";

    private final List<String> names;

    public CarNamesDto(String carNames) {
        this.names = Arrays.asList(carNames.split(DELIMITER));
    }

    public List<String> getNames() {
        return names;
    }
}
