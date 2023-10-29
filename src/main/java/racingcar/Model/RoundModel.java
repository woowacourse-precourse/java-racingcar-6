package racingcar.Model;

import racingcar.Validator.RoundValidator;

public class RoundModel {
    private final RoundValidator roundValidator = new RoundValidator();

    public Integer preProcessing(String round) {
        roundValidator.isNotString(round);
        roundValidator.isNotRealNumber(round);
        roundValidator.isValidRange(round);
        return Integer.parseInt(round);
    }

}
