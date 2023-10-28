package racingcar.model;

import java.util.ArrayList;
import racingcar.Constants;
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
        boolean invalidNameFound = carNames.stream()
                .anyMatch(name -> name.length() > Constants.valid_Length);
        if (invalidNameFound) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private void isCorrectFormat(){
        if (!Constants.namesStringPattern.matcher(NAMES_STRING).matches()) {
            throw new IllegalArgumentException("이름 형식이 잘못 되었습니다");
        }
    }

    private void isNotDuplicate(){
        if(carNames.size() != carNames.stream().distinct().count()){
            throw new IllegalArgumentException("중복 입력은 안됩니다");
        }
    }
}
