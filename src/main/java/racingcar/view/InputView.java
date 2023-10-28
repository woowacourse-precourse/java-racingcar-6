package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.input.InputDTO;

public class InputView {

    public static InputDTO readUserInput() {
        String[] names = readCarNames();
        int trialCount = readTrialCount();

        return new InputDTO(names, trialCount);
    }

    private static String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    private static int readTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private InputView() {
        throw new AssertionError();
    }
}
