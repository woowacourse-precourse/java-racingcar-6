package racingcar.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final int CARNAME_LENGTH_MAX = 5; // 최대 자동차 이름 길이
    private static final int COUNT_CAR_MIN = 2; // 최소 자동차 수
    public List<String> carNameValidator(List<String> racers) {
        for (String racer : racers) {
            if (racer.length() > CARNAME_LENGTH_MAX) {
                throw new IllegalArgumentException(String.format("자동차 이름은 %d자 이하만 가능합니다.",CARNAME_LENGTH_MAX));
            }
            if(racer.equals("")) {
                throw new IllegalArgumentException("자동차 이름은 공백이 올 수 없습니다.");
            }
        }
        Set<String> cars = new HashSet<>(racers);
        if(cars.size() != racers.size()) {
            throw new IllegalArgumentException("중복된 이름은 작성할 수 없습니다.");
        }
        if (racers.size() < COUNT_CAR_MIN) {
            throw new IllegalArgumentException(String.format("% d개 이상의 이름을 입력해야 경기가 시작합니다.",COUNT_CAR_MIN));
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
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
