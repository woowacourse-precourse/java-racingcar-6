package racingcar.utils.validator;

import static java.lang.Integer.*;
import static racingcar.model.car.CarSplitConstants.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarManagerValidator extends CarCommonValidator{


    @Override
    public void validate(final String name) {
        super.validate(name);

        final List<String> carNames = this.convertStringToList(name);
        validateExistCar(carNames);
        validateExistDuplicateCar(carNames);
    }


    private void validateExistCar(final List<String> carNames) {
        for(String name : carNames){
            super.validate(name);
        }
    }

    private void validateExistDuplicateCar(final List<String> carNames) {
        if (carNames.size() != carNames.stream().collect(Collectors.toUnmodifiableSet()).size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> convertStringToList(String carNamesString) {
        return Arrays.stream(carNamesString.split(COMMAS.getConstants(), parseInt(SPLIT_LIMIT.getConstants())))
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
