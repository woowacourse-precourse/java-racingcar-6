package racingcar.validation;

import racingcar.property.ErrorProperty;

public class ScoreValidation extends InputValidation{

    public static void verifyForScoreIsNumericValue(String racerName){
        if (!racerName.equals("\\d")){
            throw new IllegalArgumentException(ErrorProperty.SCORE_VALUE_IS_NOT_NUMERIC);
        }
    }

}
