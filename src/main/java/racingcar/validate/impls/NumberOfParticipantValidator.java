package racingcar.validate.impls;

import racingcar.validate.Validator;

public class NumberOfParticipantValidator implements Validator {

    @Override
    public void validate(Object obj) {
        String numberOfParticipants = (String) obj;
        if (isInvalidNumber(numberOfParticipants)){
            throw new IllegalArgumentException("0 이상의 정수만 입력해주세요.");
        }
    }

    private boolean isInvalidNumber(String number){
        return isInvalidInteger(number) || isNegativeNumber(number);
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
