package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;
import racingcar.dto.input.InputDTO;

/**
 * 사용자로부터 입력을 받는 뷰 클래스
 */
public class InputView {

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private InputView() {
        throw new AssertionError();
    }

    // 사용자로부터 경주에 필요한 정보를 입력받음
    public static InputDTO readUserInput() {
        Names names = readCarNames();
        TrialCount trialCount = readTrialCount();

        return InputDTO.of(trialCount, names);
    }

    // 차량 이름을 입력받음
    private static Names readCarNames() {
        System.out.println(CAR_NAME_MESSAGE);
        String input = Console.readLine();

        return Names.of(input.split(","));
    }

    // 시도 횟수를 입력받음
    private static TrialCount readTrialCount() {
        System.out.println(TRIAL_COUNT_MESSAGE);
        String count = Console.readLine();

        return TrialCount.of(count);
    }
}
