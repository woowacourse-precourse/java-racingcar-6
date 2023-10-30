package racingcar.utils.validator;

public class GetTrialNumberValidator {


    public static final String NUMBER_RANGE_ERROR_MESSAGE = "1부터 100까지의 숫자만 입력해주세요";

    public static void validateNumberRange(int trialNumber) {
        if (trialNumber < 1 || trialNumber > 100) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

}
