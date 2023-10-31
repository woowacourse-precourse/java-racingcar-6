package racingcar.model;

import racingcar.Validator;

public record RaceNumber(
        int count
) {
    public static RaceNumber of(String input){
        Validator.validateNumber(input);
        return new RaceNumber(Integer.parseInt(input));
    }
}
