package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

public class InputView {
    public static String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputs = splitByComma(Console.readLine());
        return Validator.isValidCarName(inputs);
    }

    public static int inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Validator.isValidAttemptCount(Console.readLine());
        return Integer.parseInt(input);
    }

    public static String[] splitByComma(String input) {
        Validator.isValidInput(input);
        return input.split(",");
    }
}
