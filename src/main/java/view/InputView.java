package view;

import static validate.Validator.validateEmpty;
import static validate.Validator.validateNumericInput;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String COMMA = ",";
    private static final String NAMES_FROM_USER_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPTS_FROM_USER_INPUT = "시도할 회수는 몇회인가요?";

    private InputView() {
    }

    public static String[] getCarsNameFromUserInput() {
        System.out.println(NAMES_FROM_USER_INPUT);
        String input = Console.readLine();
        validateEmpty(input);
        return input.split(COMMA);
    }

    public static int getAttemptsFromUserInput() {
        System.out.println(ATTEMPTS_FROM_USER_INPUT);
        String input = Console.readLine();
        validateEmpty(input);
        validateNumericInput(input);
        System.out.println();
        return Integer.parseInt(input);
    }
}
