package racingcar.dto.request;

import static racingcar.constants.ErrorMessage.LENGTH_LIMIT;

import java.util.Arrays;
import java.util.List;

public class CarNamesDto {
    private static final String DELIMITER = ",";
    private static final int NAME_SIZE = 5;

    private final List<String> names;

    public CarNamesDto(String carNames) {
        this.names = Arrays.asList(carNames.split(DELIMITER));
        validateNameLength(names);
    }

    private void validateNameLength(final List<String> names) {
        for(String name: names) {
            if(name.length() > NAME_SIZE || name.length() == 0) {
                throw new IllegalArgumentException(LENGTH_LIMIT + NAME_SIZE);
            }
        }
    }

    public List<String> getNames() {
        return names;
    }
}
