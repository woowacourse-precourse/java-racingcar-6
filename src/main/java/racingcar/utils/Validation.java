package racingcar.utils;

import java.util.List;

public class Validation {
    public List<String> carNameInputValidation(List<String> racers) {
        for (String str : racers) {
            if (str.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        if (racers.size() < 2) {
            throw new IllegalArgumentException("두 개 이상을 입력해야 경기가 시작합니다.");
        }
        return racers;

    }

    public String nullStringInput(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("입력해주세요.");
        }
        return input;
    }

}
