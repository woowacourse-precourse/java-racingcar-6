package racingcar;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Validators {
    public void isCarNameOverFive(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    public void isListElementOverFive(ArrayList<String> carList) {
        for (String car : carList) {
            isCarNameOverFive(car);
        }
    }

    public boolean isInteger(String inputString) {
        Pattern pattern = Pattern.compile("^\\d+$");
        boolean result = pattern.matcher(inputString).matches();

        if (!result) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
        return result;
    }
}



