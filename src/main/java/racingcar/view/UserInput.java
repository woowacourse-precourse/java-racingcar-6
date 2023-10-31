package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.CarNameListValidator;
import racingcar.validator.GameCountValidator;
import racingcar.validator.InputCommaValidator;

public class UserInput {
    private static final String ASK_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAMES_DELIMETER = ",";

    public List<String> readCarNames() {
        System.out.println(ASK_CAR_NAMES_MESSAGE);
        String names = Console.readLine();

        new InputCommaValidator().validate(names);
        new CarNameListValidator().validate(names);

        return parseCarNamesToList(names);
    }

    public int readGameCount() {
        System.out.println(ASK_GAME_COUNT_MESSAGE);
        String gameCount = Console.readLine();

        new GameCountValidator().validate(gameCount);

        return Integer.parseInt(gameCount);
    }

    private List<String> parseCarNamesToList(String names) {
        return Arrays.stream(names.split(CAR_NAMES_DELIMETER)).toList();
    }

}