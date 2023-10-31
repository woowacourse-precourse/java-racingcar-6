package racingcar.validate.impls;

import racingcar.validate.Validator;

public class NumberOfParticipantValidator implements Validator {

    @Override
    public void validate(Object obj) {
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
