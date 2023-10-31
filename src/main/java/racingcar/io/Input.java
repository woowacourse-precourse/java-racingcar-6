package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validation.CarValidate;
import racingcar.validation.InputValidate;

public class Input {
    private final static String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private final static String GAME_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static List<String> carNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = Console.readLine();
        InputValidate.nameFormat(input);

        List<String> names = List.of(input.split(","));
        CarValidate.participantCount(names);
        CarValidate.carNames(names);
        return names;
    }

    public static int gameRound() {
        System.out.println(GAME_ROUND_INPUT_MESSAGE);
        String input = Console.readLine();
        InputValidate.gameRound(input);
        return Integer.parseInt(input);
    }
}
