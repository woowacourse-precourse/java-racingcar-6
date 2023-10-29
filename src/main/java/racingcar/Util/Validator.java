package racingcar.Util;

import java.util.ArrayList;
import java.util.List;
import racingcar.Constants.ExceptionMessage;

public class Validator {

    public String[] validationCarName(String name){
        name = name.replaceAll(" ", "");
        String[] names = validationNameLength(name.split(","));
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
}
