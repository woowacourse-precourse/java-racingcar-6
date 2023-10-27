package racingcar;

public class InputValidation {

    public void tryInputNumberValidate(String tryInput){
        if(!tryInput.matches("(\\d)+")){
            throw new IllegalArgumentException();
        }
    }
}
