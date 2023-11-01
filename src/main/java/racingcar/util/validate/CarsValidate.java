package racingcar.util.validate;

public sealed interface CarsValidate permits CarsValidateImpl {
    boolean validateDuplicatedName(String[] input);
}

