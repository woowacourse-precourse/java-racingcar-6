package racingcar.domain;

import java.util.List;

public class ExceptionCase {

    public String[] nameInputValidation(String[] racers) {
        for(String str: racers) {
            if (str.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        if(racers.length < 2) {
            throw new IllegalArgumentException("두 대 이상을 입력해야 경기가 시작합니다.");
        }
        return racers;

    }
    public String nullStringInput(String input) {
        if (input == null || input == "") {
            throw new IllegalArgumentException("입력해주세요.");
        }
        return input;
    }

}

