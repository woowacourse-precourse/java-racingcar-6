package racingcar.Util;

import java.util.ArrayList;
import java.util.List;
import racingcar.Constants.ExceptionMessage;

public class Validator {

    public String[] validationCarName(String name){
        name = name.replaceAll(" ", "");
        String[] names = validationNameLength(name.split(",", -1));
        validationNameDuplicate(names);
        return names;
    }

    private String[] validationNameLength(String[] name){
        for (String s : name) {
            checkNameLength(s);
        }
        return name;
    }

    private void checkNameLength(String carName){
        if(carName.isEmpty() || 5 < carName.length()){
            ExceptionMessage.OUT_OF_LENGTH.throwexception();
        }
    }

    private void validationNameDuplicate(String[] names){
        List<String> checkduplicate = new ArrayList<>();
        for (String name : names) {
            checkDuplicate(checkduplicate, name);
            checkduplicate.add(name);
        }
    }
    private void checkDuplicate(List<String> checkduplicate, String name){
        if(checkduplicate.contains(name)){
            ExceptionMessage.DUPLICATE_NAME.throwexception();
        }
    }

    public int validationTrialNumber(String trialNumber){
        trialNumber = trialNumber.replaceAll(" ", "");
        validationTrialEmpty(trialNumber);
        validationTrialType(trialNumber);
        validationTrialNumberZero(trialNumber);
        return validationTrialNumberOverflow(trialNumber);
    }

    private void validationTrialEmpty(String trialNumber){
        if(trialNumber.isEmpty()){
            ExceptionMessage.NONE_INPUT.throwexception();
        }
    }

    private void validationTrialType(String trialNumber){
        if(trialNumber.matches(".*\\D.*")){
            ExceptionMessage.NUMBER_ONLY.throwexception();
        }
    }

    private int validationTrialNumberOverflow(String trialNumber){
        try {
            Integer.parseInt(trialNumber);
        }catch (NumberFormatException numberFormatException){
            ExceptionMessage.NUMBER_OVERFLOW.throwexception();
        }
        return Integer.parseInt(trialNumber);
    }

    private void validationTrialNumberZero(String traialNumber){
        if(Integer.parseInt(traialNumber) < 1){
            ExceptionMessage.NUMBER_ZERO.throwexception();
        }
    }
}
