package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RacingCarInputView {

    public static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String DELIMITER = ",";

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String names = Console.readLine();
        return Arrays.stream(names.split(DELIMITER))
                .toList();
    }
}
