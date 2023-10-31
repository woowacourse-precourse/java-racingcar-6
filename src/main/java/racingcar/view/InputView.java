package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;
import racingcar.dto.input.InputDTO;

public class InputView {

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private InputView() {
        throw new AssertionError();
    }

    public static InputDTO readUserInput() {
        Names names = readCarNames();
        TrialCount trialCount = readTrialCount();

        return InputDTO.of(trialCount, names);
    }

    private static Names readCarNames() {
        System.out.println(CAR_NAME_MESSAGE);
        String input = Console.readLine();

        return Names.of(input.split(","));
    }

    private static TrialCount readTrialCount() {
        System.out.println(TRIAL_COUNT_MESSAGE);
        String count = Console.readLine();

        return TrialCount.of(count);
    }
}
