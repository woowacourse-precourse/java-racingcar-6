package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import validation.InputValidation;

public class Input {
    public static List<String> carNames() {
        String input = Console.readLine();
        List<String> names = List.of(input.split(","));
        //검증 코드 추가
        return names;
    }

    public static int gameRound() {
        String input = Console.readLine();
        //검증 코드 추가
        return Integer.parseInt(input);
    }
}
