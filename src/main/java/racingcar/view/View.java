package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Constants;

public class View {
    public static String[] getCarNames() {
        System.out.println(Constants.CAR_NAME_PROMPT);
        return Console.readLine().split(",");
    }

    public static int getRounds() {
        System.out.println(Constants.ROUND_COUNT_PROMPT);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.INVALID_INPUT_MSG);
        }
    }

    public static void displayExecutionResult() {
        System.out.println(Constants.EXECUTION_RESULT);
    }

    public static void displayLabTimeNotice(int labNumber) {
        System.out.printf(Constants.LAB_MSG + "%d\n", labNumber);
    }

    public static void displayCarPosition(String carName, int position) {
        System.out.println(carName + " : " + "-".repeat(position));
    }

    public static void displayWinners(String winners) {
        System.out.println(Constants.WINNERS_MSG + winners);
    }
}

