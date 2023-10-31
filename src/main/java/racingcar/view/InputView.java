package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND = "시도할 회수는 몇회인가요?";
    private static final String ERROR_MESSAGE_INPUT_ROUND_NOT_IN_SCOPE = "올바른 숫자를 입력해 주세요";
    private static final int MINIMUN_ROUND = 1;
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String getCarName() {
        System.out.println(INPUT_CAR_NAME);
        return SCANNER.nextLine();
    }

    public static int getRound() {
        System.out.println(INPUT_ROUND);
        final String inputRound = SCANNER.nextLine();
        checkInputRound(inputRound);
        return stringToInt(inputRound);
    }

    private static void checkInputRound(final String inputRound) {
        if (notCollectInputRound(inputRound)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_ROUND_NOT_IN_SCOPE);
        }
    }

    private static boolean notCollectInputRound(final String inputRound) {
        return !isDigit(inputRound) || isInScope(inputRound);
    }

    private static boolean isDigit(final String inputRound) {
        return inputRound.chars().allMatch(Character::isDigit);
    }

    private static boolean isInScope(final String inputRound) {
        return stringToInt(inputRound) < MINIMUN_ROUND;
    }

    private static int stringToInt(final String inputRound) {
        return Integer.parseInt(inputRound);
    }


}
