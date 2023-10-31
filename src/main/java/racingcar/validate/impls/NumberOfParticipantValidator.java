package racingcar.validate.impls;

import racingcar.validate.Validator;

public class NumberOfParticipantValidator implements Validator {

    @Override
    public void validate(Object obj) {
    }


    private boolean isNegativeNumber(String number){
        int convertedNumber = Integer.parseInt(number);
        return convertedNumber < 0;
    }

    private boolean isInvalidInteger(String number){
        try{
            Integer.parseInt(number);
            return false;
        }catch (Exception e){
            return true;
        }
    }
}
