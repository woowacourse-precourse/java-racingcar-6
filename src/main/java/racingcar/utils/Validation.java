package racingcar.utils;

import java.util.List;

public class Validation {
    private static final int CARNAME_LENGTH_MAX = 5; // 최대 자동차 이름 길이
    private static final int COUNT_CAR_MIN = 2; // 최소 자동차 수
    public List<String> carNameInputValidation(List<String> racers) {
        for (String str : racers) {
            if (str.length() > CARNAME_LENGTH_MAX) {
                throw new IllegalArgumentException(String.format("자동차 이름은 %d자 이하만 가능합니다.",CARNAME_LENGTH_MAX));
            }
        }
        if (racers.size() < COUNT_CAR_MIN) {
            throw new IllegalArgumentException(String.format("d%개 이상의 이름을 입력해야 경기가 시작합니다.",COUNT_CAR_MIN));
        }
        return racers;

    }

    public String nullStringInput(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
        return input;
    }

    public int isNumberValidation(String input) {
        try {
            int num = Integer.parseInt(input);
            return num;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
