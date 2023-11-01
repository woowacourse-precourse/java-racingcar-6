package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.view.CommonMessage.ERROR_MESSAGE_PREFIX;

public class InputView {

    private static final String INPUT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_COUNT = "시도할 회수는 몇회인가요?";

    public static String inputCars() {
        System.out.println(INPUT_CARS);
        return Console.readLine();
    }

    public static int inputTrialCount() {
        System.out.println(INPUT_TRIAL_COUNT);
        String input = Console.readLine();
        validateIsNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateIsNumber(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "시도 횟수는 숫자여야 한다.");
        }
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}