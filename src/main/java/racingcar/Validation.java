package racingcar;

public class Validation {
    static final int CAR_NAME_LENGTH = 5;
    static final String NAME_LENGTH_ERROR_MESSAGE = "[System] 자동차 이름은 5자 이하만 가능합니다.";
    static final String ONLY_NUMBER_ERROR_MESSAGE = "[System] 숫자만 입력 가능합니다.";
    void carNameValidation(String name){
        if(name.length() > CAR_NAME_LENGTH){
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    void roundValidation(String roundString){
        try{
            Integer.parseInt(roundString);
        } catch (IllegalArgumentException e){
            System.out.println(ONLY_NUMBER_ERROR_MESSAGE);
        }
    }
}
