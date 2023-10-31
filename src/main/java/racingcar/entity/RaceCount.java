package racingcar.entity;

import racingcar.property.ValidateType;

import static racingcar.validation.ValidateForm.validateForValidateType;

public record RaceCount(int inputRaceCount) {

    public static void validateRaceCount(String inputRaceCount){
        validateForValidateType(ValidateType.COUNT,inputRaceCount);
    }
}
