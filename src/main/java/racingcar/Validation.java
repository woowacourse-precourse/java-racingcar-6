package racingcar;

public class Validation {

    void carNameValidation(String name){
        if(name.length() > 6){
            throw new IllegalArgumentException();
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
