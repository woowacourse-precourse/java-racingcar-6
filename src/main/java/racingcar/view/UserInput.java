package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {

    public static int userInputToInt(String input) {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }


    public static List<String> userInputToStringList(String input) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
