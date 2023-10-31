package racingcar;

import java.util.Arrays;

public class InputValidator {

    char temp;

    public void checkString(String[] input) {
        checkStringLength(input);
        checkDuplicateString(input);

    }

    public void checkNumber(String number){
        isNumberZero(number);
        isNumberDigit(number);
    }

    public void checkStringLength(String[] input){
        for (String str : input) {
            if (str.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자리 이하로 만들어야 합니다");
            }
        }
    }

    public void checkDuplicateString(String[] input){
        if(Arrays.stream(input).distinct().count() != input.length){
            throw new IllegalArgumentException("자동차 이름이 중복됩니다.");
        }
    }

    public void isNumberZero(String number){
        if(number.equals("0")){
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
        }
    }

    public void isNumberDigit(String number){
        for(int i = 0; i<number.length(); i++){
            temp = number.charAt(i);
            if (!Character.isDigit(temp)){
                throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
            }
        }
    }
}
