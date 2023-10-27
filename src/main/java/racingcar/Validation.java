package racingcar;

public class Validation {

    private void carNamelengthValidate(String carName){
        if(carName.length() > 5){
            throw new IllegalArgumentException();
        }
    }

    private void tryInputNumberValidate(String tryInput){
        if(tryInput.matches("(\\d)+")){
            throw new IllegalArgumentException();
        }
    }
}
