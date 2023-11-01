package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

public final class InputProvider {
    private static final String RACE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final InputProvider inputProvider = new InputProvider();

    private final Validator validator;

    private InputProvider() {
        validator = new Validator();
    }

    public static InputProvider getInstance() {
        return inputProvider;
    }

    public int receiveRaceCount() {
        System.out.println(RACE_COUNT_INPUT_MESSAGE);
        String raceCount = Console.readLine();
        validator.validateRaceCount(raceCount);

        return Integer.parseInt(raceCount);
    }

    public String receiveCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String names = Console.readLine();
        validator.validateNames(names);

        return names;
    }
}
