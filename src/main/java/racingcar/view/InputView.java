package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;
import racingcar.dto.input.InputDTO;

public class InputView {

    public static InputDTO readUserInput() {
        Names names = readCarNames();
        TrialCount trialCount = readTrialCount();

        return new InputDTO(names, trialCount);
    }

    private static Names readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return new Names(Console.readLine().split(","));
    }

    private static TrialCount readTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return new TrialCount(Integer.parseInt(Console.readLine()));
    }

    private InputView() {
        throw new AssertionError();
    }
}
