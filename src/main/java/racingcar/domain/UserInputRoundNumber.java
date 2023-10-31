package racingcar.domain;

import racingcar.exception.UserRoundNumberInputException;

public class UserInputRoundNumber {

    public int createRoundNumber(String userInput){
        UserRoundNumberInputException.isZeroMinus(userInput);
        UserRoundNumberInputException.isNumber(userInput);
        UserRoundNumberInputException.isBlank(userInput);
        int roundNum = stringToInt(userInput);
        return roundNum;
    }
    private static int stringToInt(String userInput){
        return Integer.parseInt(userInput);
    }
}
