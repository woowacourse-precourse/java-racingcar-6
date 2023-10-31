package racingcar.manager.view;

import java.util.regex.Pattern;

public class UserViewValidation {
    public boolean isDigit(String inputCount){
        for(int i=0;i<inputCount.length();i++){
            char validNum = inputCount.charAt(i);

            if(!Character.isDigit(validNum)){
                return false;
            }
        }
        return true;
    }
}
