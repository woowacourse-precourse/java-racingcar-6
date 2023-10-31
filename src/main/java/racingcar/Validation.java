package racingcar;

public class Validation {
    static final int CAR_NAME_LENGTH = 5;
    void carNameValidation(String name){
        if(name.length() > CAR_NAME_LENGTH){
            throw new IllegalArgumentException("[System] 자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    int roundValidation(String roundString){
        try{
            return Integer.parseInt(roundString);
        } catch (IllegalArgumentException e){
            System.out.println("[System] 숫자만 입력 가능합니다.");
        }

        return 0;
    }
}
