package racingcar.view;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static List<String> InputCarName() {
        String carNames = Console.readLine();
        List<String> car = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            validateName(carName);
            car.add(carName);
        }
        return car;
    }

    private static void validateName(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름을 정확히 입력해주세요.");
        }
    }

    public static int InputPlayCount() {
        String playCount = Console.readLine();
        try {
            int count = Integer.parseInt(playCount);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수로 유효한 숫자를 입력해주세요.");
        }
    }
}
