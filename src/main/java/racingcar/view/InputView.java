package racingcar.view;

import static racingcar.util.NameSplitter.split;
import static racingcar.util.Validator.validateInteger;
import static racingcar.util.Validator.validateNotEmpty;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_GAME_COUNT = "시도할 횟수는 몇 회인가요?";

    public String[] askCarNames() {
        System.out.println(ASK_CAR_NAMES);
        String carNames = Console.readLine();
        validateNotEmpty(carNames);
        return split(carNames);
    }

    public int askGameCount() {
        System.out.println(ASK_GAME_COUNT);
        String gameCount = Console.readLine();
        validateNotEmpty(gameCount);
        validateInteger(gameCount);
        return Integer.parseInt(gameCount);
    }
}
