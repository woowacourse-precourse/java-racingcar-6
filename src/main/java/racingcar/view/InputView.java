package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InputConvertor;

public class InputView {
    private static final String START_COMMAND = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String NUMBER_OF_TRIES_COMMAND = "시도할 횟수는 몇회인가요?";

    public static String[] startGameCommand() {
        System.out.println(START_COMMAND);
        return InputConvertor.separateInputToNames(Console.readLine());
    }

    public static int getTryCount() {
        System.out.println(NUMBER_OF_TRIES_COMMAND);
        String input = Console.readLine();
        int tryCount = InputConvertor.parseTryCount(input);
        InputConvertor.validateTryCount(tryCount);
        return tryCount;
    }
}
