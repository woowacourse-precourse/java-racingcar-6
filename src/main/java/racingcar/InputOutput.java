package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputOutput {

    private static final String UNIT_MOVE_BLOCK = Constant.UNIT_MOVE_BLOCK;

    static String getCarNames() {
        System.out.println(Constant.ASK_TRYCOUNT_MESSAGE);
        String cars = Console.readLine();
        return cars;
    }

    static Integer getTryCount() {
        System.out.println(Constant.ASK_CARS_NAME_MESSAGE);
        String tryCountString = Console.readLine();
        Integer tryCount = Integer.parseInt(tryCountString);
        return tryCount;
    }

    static void printEmptyLine() {
        System.out.println();
    }

    static void printResultMessage() {
        System.out.println(Constant.MOVECOUNT_RESULT_MESSAGE);
    }

    static void printRoundResult(String name, int moveCount) {
        System.out.printf("%s : %s\n", name, UNIT_MOVE_BLOCK.repeat(moveCount));
    }

    static void printWinner(List<String> names) {
        System.out.print(Constant.PRINT_WINNER_MESSAGE);
        String namesWithComma = String.join(",", names);
        System.out.println(namesWithComma);
    }
}
