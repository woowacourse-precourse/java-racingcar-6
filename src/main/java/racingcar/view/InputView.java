package racingcar.view;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public List<String> InputCarName() {
        String carNames = Console.readLine();
        List<String> car = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            validateName(carName);
            car.add(carName);
        }
        return car;
    }

    private void validateName(String name) {
        if (name == null | name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름을 정확히 입력해주세요.");
        }
    }

    public int InputPlayCount() {
        String playCount = Console.readLine();
        return Integer.parseInt(playCount);
    }
}
