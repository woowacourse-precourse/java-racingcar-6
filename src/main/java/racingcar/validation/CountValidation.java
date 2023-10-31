package racingcar.validation;

import racingcar.property.ErrorProperty;

public class CountValidation extends InputValidation{

    public static void verifyForRaceCountIsNumericValue(String targetScore){
        if (!targetScore.matches("\\d")){
            throw new IllegalArgumentException(ErrorProperty.SCORE_VALUE_IS_NOT_NUMERIC);
        }
    }

    public static void verifyForRaceCountIsOverStandard(String targetScore){
        long convertedScore = Long.parseLong(targetScore);
        if (convertedScore>Integer.MAX_VALUE){
            throw new IllegalArgumentException(ErrorProperty.SCORE_VALUE_IS_OVER_STANDARD);
        }
    }
}
