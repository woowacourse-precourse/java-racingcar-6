package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserInput {

    public static String[] inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        Validator.blankCheck(input);
        List<String> names = List.of(input.split(","));
        Validator.nameDuplicatenCheck(names);

        return input.split(",");
    }
}
