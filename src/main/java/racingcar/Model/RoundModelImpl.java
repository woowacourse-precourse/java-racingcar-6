package racingcar.Model;

import racingcar.Factory.Factory;
import racingcar.Validator.RoundValidator;

public class RoundModelImpl implements RoundModel {
    Factory factory = new Factory();
    private final RoundValidator roundValidator = factory.getRoundValidator();

    public Integer preProcessing(String round) {
        roundValidator.isNotRealNumber(round);
        roundValidator.isNotString(round);
        roundValidator.isValidRange(round);
        return Integer.parseInt(round);
    }

}
