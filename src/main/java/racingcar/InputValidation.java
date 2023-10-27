package racingcar;

public class InputValidation {

    public Integer tryInputNumberValidate(String tryInput){
        if(!tryInput.matches("(\\d)+")){
            throw new IllegalArgumentException();
        }
        return Integer.valueOf(tryInput);
    }
}
