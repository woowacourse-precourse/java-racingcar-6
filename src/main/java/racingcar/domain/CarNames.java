package racingcar.domain;

import java.util.List;

public class CarNames {
    private List<String> nameList;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private CarNames(String input){
    }

    public static CarNames from(String input){
        return new CarNames(input);
    }

    private void validateLength(){

    }

    private void validateDuplicate(){

    }

    private void validateEmpty(){

    }
}
