package racingcar.Model;

import java.util.ArrayList;
import racingcar.Util;

public class CarValidation {
    private final String NAMES_STRING;
    public ArrayList<String> carNames;
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

    private void isLengthValid() {
        carNames.stream()
                .filter(name -> name.length() > 5)
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + name);
                });
    }

    private void isCorrectFormat(){

    }

    private void isNotDuplicate(){
        if(carNames.size() != carNames.stream().distinct().count()){
            throw new IllegalArgumentException("중복 입력은 안됩니다");
        }
    }
}
