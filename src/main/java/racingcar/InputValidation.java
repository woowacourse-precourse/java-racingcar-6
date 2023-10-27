package racingcar;

public class InputValidation {

    private void tryInputNumberValidate(String tryInput){
        if(tryInput.matches("(\\d)+")){
            throw new IllegalArgumentException();
        }
    }
}
