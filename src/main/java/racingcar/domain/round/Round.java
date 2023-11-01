package racingcar.domain.round;

import racingcar.error.ErrorMessage;
import racingcar.error.Roud.InvalidNumberFormatException;
import racingcar.error.Roud.InputUnderOneException;

public class Round {


    private static final int LIMIT_INPUT_ROUND_NUMBER = 1;
    private int round;

    public Round(String roundNumber){
        validateRoundNumber(roundNumber);
        validateInputUnderOne(round);
    }

    private void validateInputUnderOne(int round){
        if(round < LIMIT_INPUT_ROUND_NUMBER){
            throw new InputUnderOneException(ErrorMessage.INPUT_UNDER_ONE_EXCEPTION);
        }
    }

    private void validateRoundNumber(String roundNumber){
        try{
            round = Integer.parseInt(roundNumber);
        }catch (Exception e){
            throw new InvalidNumberFormatException(ErrorMessage.INVALID_NUMBER_FORMAT_EXCEPTION);
        }
    }

    public int getRound() {
        return round;
    }
}