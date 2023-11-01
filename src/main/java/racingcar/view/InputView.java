package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;


public class InputView {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public String[] readCarName() {
        String[] carNames = Console.readLine().split(",");
        return parseToNames(carNames);
    }

    public int readProgressCount() {
        String input = Console.readLine();
        return parseToInt(input);
    }

    private String[] parseToNames(String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .peek(carName -> {
                    if (carName.length() == 0 || carName.length() > MAX_CAR_NAME_LENGTH) {
                        throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
                    }
                })
                .toArray(String[]::new);
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 값을 입력해주세요.");
        }
    }

}
