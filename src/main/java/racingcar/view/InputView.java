package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static final String INPUT_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";
    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String NOT_NUMERIC = "숫자를 입력해주세요";
    public static final String NAME_SEPARATOR = ",";

    public int getAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT);
        return parseInt(readLine());
    }

    public List<String> getNames() {
        System.out.println(INPUT_CAR_NAMES);
        return List.of(readLine().split(NAME_SEPARATOR));
    }

    private String readLine() {
        return Console.readLine();
    }

    private int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC);
        }
    }
}
