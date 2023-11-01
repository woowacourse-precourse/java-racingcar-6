package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.UserCarNameDto;

public class RacingCarInputView {
    private static final String DELIMITER = ",";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNTS_MESSAGE = "시도할 횟수는 몇회인가요?";

    public UserCarNameDto inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String names = Console.readLine();
        List<String> carNames = Arrays.stream(names.split(DELIMITER))
                .toList();
        return new UserCarNameDto(carNames);
    }

    public String inputAttemptCounts() {
        System.out.println(INPUT_ATTEMPT_COUNTS_MESSAGE);
        return Console.readLine();
    }
}
