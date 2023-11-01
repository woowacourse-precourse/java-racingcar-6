package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputView {

    public static Set<String> getCarNames() {
        OutputView.requestCarNames();
        return isValidCarName(Console.readLine());
    }

    public static int getRound() {
        OutputView.requestRound();
        return isValidRound(Console.readLine());
    }

    private static Set<String> isValidCarName(String input) {
        String[] carNameArray = input.split(",");
        Set<String> carNames = new HashSet<>();

        for (String carName : carNameArray) {
            carName = carName.trim();

            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다.");
            }

            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로만 입력 가능합니다.");
            }

            if (!carNames.add(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
            }
        }

        return carNames;
    }

    private static int isValidRound(String input) {
        int round;

        try {
            round = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        if (round < 1) {
            throw new IllegalArgumentException("최소 시도 횟수는 1회 이상입니다.");
        }

        return round;
    }
}
