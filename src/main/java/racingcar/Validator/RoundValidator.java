package racingcar.Validator;

public interface RoundValidator {

    void isNotString(String round);

    void isNotRealNumber(String round);

    void isValidRange(String round);
}
