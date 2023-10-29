package racingcar;

public class InputValidator {

    public void validateLength(String data, int limitLength){
        if(data.length() >= limitLength){
            throw new IllegalArgumentException();
        }
    }
}
