package racingcar.utils.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarManagerValidator implements Validator<String> {

    private static final String COMMAS = "," ;
    private static final int SPLIT_LIMIT = -1;

    @Override
    public void validate(final String value) {
        this.validateNotEmpty(value);

        final List<String> carNames =
                Arrays.stream(value.split(COMMAS, SPLIT_LIMIT))
                        .map(String::strip)
                        .toList();
        System.out.println(carNames);
        validateExistCar(carNames);
        validateExistDuplicateCar(carNames);
    }

    private void validateNotEmpty(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateExistCar(final List<String> carNames) {
        for(String name : carNames){
            this.validateNotEmpty(name);
        }
    }

    private void validateExistDuplicateCar(final List<String> carNames) {
        if (carNames.size() != carNames.stream().collect(Collectors.toUnmodifiableSet()).size()) {
            throw new IllegalArgumentException();
        }
    }
}
