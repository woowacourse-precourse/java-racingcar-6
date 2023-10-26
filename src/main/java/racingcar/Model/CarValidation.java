package racingcar.Model;

import java.util.ArrayList;
import racingcar.Util;

public class CarValidation {
    private final String NAMES_STRING;
    private final ArrayList<String> carNames;
    public CarValidation(String namesString){
        this.NAMES_STRING = namesString;
        this.carNames = Util.toArray(namesString);
        validate();
    }
    private void validate(){
        isCorrectFormat();
        isNotDuplicate();
        isLengthValid();
    }

    private void isLengthValid(){

    }
    private void isCorrectFormat(){

    }

    private void isNotDuplicate(){

    }
}
