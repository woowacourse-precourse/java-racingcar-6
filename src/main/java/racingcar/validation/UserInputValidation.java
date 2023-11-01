package racingcar.validation;

public class UserInputValidation {

    public void checkCarNameValidation(String carName){
        if(carName.length() >5 ){
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public void checkAttemptNumberValidation(String attemptNumber){
        if (!isInteger(attemptNumber)){
            throw new IllegalArgumentException("정수를 입력하세요.");
        }else if(Integer.parseInt(attemptNumber) <= 0){
            throw new IllegalArgumentException("0보다 큰 값을 입력하세요.");
        }
    }

    private boolean isInteger(String attemptNumber) {
        try {
            Integer.parseInt(attemptNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
