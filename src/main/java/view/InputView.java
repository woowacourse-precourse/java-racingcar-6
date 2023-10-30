package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String COMMA = ",";
    private static final String NAMES_FROM_USER_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private InputView() {
    }

    public static List<String> getCarsNameFromUserInput() {
        System.out.println(NAMES_FROM_USER_INPUT);
        String names = Console.readLine();
        return Arrays.asList(names.split(COMMA));
    }
}
