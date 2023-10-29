package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.validation.ValidateAttempts;
import racingcar.model.validation.ValidateCars;

public class View {
    public static String[] askForCarNames() {
        return getCarNames();
    }

    public static int askForAttempts() {
        return getAttempts();
    }

    public static void displayResult() {
        System.out.println("\n실행결과");
    }

    public static void displayRoundResult(String result) {
        System.out.println(result);
    }

    public static void displayWinners(String winners) {
        System.out.printf("최종 우승자 : %s\n", winners);
    }

    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String[] names = input.split(",");
        ValidateCars.isValid(names);
        return names;
    }

    private static int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        ValidateAttempts.isValid(input);
        int attempts = Integer.parseInt(input);
        return attempts;
    }

}
