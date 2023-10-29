package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.validation.ValidateAttempts;
import racingcar.utils.validation.ValidateCars;

public class InputView {
    public static String[] askForCarNames() {
        return getCarNames();
    }

    public static int askForAttempts() {
        return getAttempts();
    }

    // 사용자에게 자동차 이름 입력받음
    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String[] names = input.split(",");
        ValidateCars.isValid(names);
        return names;
    }

    // 사용자에게 시도 횟수를 입력받음
    private static int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        ValidateAttempts.isValid(input);
        int attempts = Integer.parseInt(input);
        return attempts;
    }

}
