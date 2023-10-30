package racingcar.validation;

import racingcar.property.ErrorProperty;

public class ScoreValidation extends InputValidation{

    public static void verifyForScoreIsNumericValue(String targetScore){
        if (!targetScore.equals("\\d")){
            throw new IllegalArgumentException(ErrorProperty.SCORE_VALUE_IS_NOT_NUMERIC);
        }
    }

    public static void verifyForScoreIsOverStandard(String targetScore){
        long convertedScore = Long.parseLong(targetScore);
        if (convertedScore>Integer.MAX_VALUE){
            throw new IllegalArgumentException(ErrorProperty.SCORE_VALUE_IS_OVER_STANDARD);
        }
    }
}
