package racingcar;

public class GetTrialNumberValidator {

    public static void validateNumberRange(int trialNumber) {
        if(trialNumber<1||trialNumber>100){
            throw new IllegalArgumentException();
        }
    }

}
