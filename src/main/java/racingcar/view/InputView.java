package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public List<String> askCarNames() {
        System.out.println(QUESTION_CAR_NAMES);
        String inputCarNames = Console.readLine();
        return Arrays.stream(inputCarNames.split(",")).toList();
    }
}
