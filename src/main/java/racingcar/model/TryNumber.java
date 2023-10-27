package racingcar.model;

public class TryNumber {

    public void isNoDigits(String tryNumber) throws IllegalArgumentException{
        if(!tryNumber.matches("[1-9]+")){
            throw new IllegalArgumentException("시도할 회수는 1보다 큰 자연수여야 합니다.");
        }

    }

}
