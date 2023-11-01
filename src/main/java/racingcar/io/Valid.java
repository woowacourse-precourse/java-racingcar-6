package racingcar.io;

import java.util.*;

public class Valid {
    public static void nameInput(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백으로 입력 할 수 없습니다.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("입력이 유효하지 않습니다. 자동차 이름은 5자 이하이어야 합니다.");
            }
        }
    }
}
