package racingcar.domain;

import java.util.List;

public class ExceptionCase {

    public void carNameLength(String input) {
        String[] racers = input.split(",");
        for(String str: racers) {
            if (str.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void nullStringInput(String input) {
        if (input == null || input == "") {
            throw new IllegalArgumentException();
        }
    }
    public void isNumberCorrect(int input) {
        if (input < 0 || input > 9) {
            throw new IllegalArgumentException();
        }
    }

    public void hasAtLeastTwoInputs(String[] racers) {
        if(racers.length < 2) {
            throw new IllegalArgumentException("두 대 이상을 입력해야 경기가 시작합니다.");
        }
    }

}

