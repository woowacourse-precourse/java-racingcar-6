package racingcar.util;

public class validator {

    private void validateCarLength(String carName){
        if(carName.length()>5)
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
    }

    private void validateIsNumber(String input){
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c))
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

}
