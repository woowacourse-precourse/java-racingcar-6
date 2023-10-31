package racingcar;

public class Validation {

    public void carNameValidation(String name){
        if(name.length() > 6){
            throw new IllegalArgumentException();
        }
    }
}
