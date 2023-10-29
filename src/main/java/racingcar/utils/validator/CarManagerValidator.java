package racingcar.utils.validator;

import java.util.List;
import java.util.stream.Collectors;

public class CarManagerValidator implements Validator<List<String>> {

    private final CarCommonValidator commonValidator = new CarCommonValidator();

    @Override
    public void validate(final List<String> value) {
        validateExistCar(value);
        validateExistDuplicateCar(value);
    }


    private void validateExistCar(final List<String> carNames) {
        for(String name : carNames){
            this.commonValidator.validate(name);
        }
    }

    private void validateExistDuplicateCar(final List<String> carNames) {
        if (carNames.size() != carNames.stream().collect(Collectors.toUnmodifiableSet()).size()) {
            throw new IllegalArgumentException();
        }
    }

    public CarCommonValidator getCommonValidator() {
        return commonValidator;
    }
}
