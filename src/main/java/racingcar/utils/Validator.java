package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final String CAR_NAMES_ERROR_MESSAGE = "[ERROR] 입력한 '자동차 이름'이 잘못된 형식입니다";
    private static final String TURNS_ERROR_MESSAGE = "[ERROR] 입력한 '시도할 횟수'가 잘못된 형식입니다";

    public Validator(){

    }

    public void validateCarNames(String userInputCarNames){
        if(isNullOrEmpty(userInputCarNames)){
            throw new IllegalArgumentException(CAR_NAMES_ERROR_MESSAGE);
        }

        if(!isCorrectCarNames(userInputCarNames)){
            throw new IllegalArgumentException(CAR_NAMES_ERROR_MESSAGE);
        }
    }

    public void validateTurns(String userInputTurns){
        if(isNullOrEmpty(userInputTurns)){
            throw new IllegalArgumentException(TURNS_ERROR_MESSAGE);
        }

        if(!isNumber(userInputTurns)){
            throw new IllegalArgumentException(TURNS_ERROR_MESSAGE);
        }
    }

    private boolean isNullOrEmpty(String input) {
        return input == null;
    }

    private boolean isCorrectCarNames(String carNames) {
        String[] carNamesArray = carNames.split(",");

        boolean answer = true;

        for (String eachCarName : carNamesArray){
            if (eachCarName.length() > 5 || eachCarName.isEmpty()){
                answer = false;
                break;
            }
        }

        return answer;
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
