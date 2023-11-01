package racingcar.domain;

public class InputValidator {
    public void validateLength(String carName){
        if(carName.length()>5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public int convertToValidInteger(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("플레이 횟수는 정수가 입력되어야 합니다.", e);
        }
    }

}
