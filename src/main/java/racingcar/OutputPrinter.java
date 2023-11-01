package racingcar;

import java.util.List;

public class OutputPrinter {
    static String lineSeparator = System.lineSeparator();
    private static final String RACING_CARS_INPUT_REQUEST_MESSAGE= "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_NUM_INPUT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String FINAL_WINNER_PRINT_MESSAGE = "최종 우승자 : ";
    private static final String MOVE_RESULT_PRINT_MESSAGE = lineSeparator + "실행 결과";

    static void printRacingCarsInputRequestMessage() {
        System.out.println(RACING_CARS_INPUT_REQUEST_MESSAGE);
    }

    static void printMoveNumInputRequestMessage() {
        System.out.println(MOVE_NUM_INPUT_REQUEST_MESSAGE);
    }

    static void printFinalWinnerPrintMessage() {
        System.out.print(FINAL_WINNER_PRINT_MESSAGE);
    }

    static void printMoveResultPrintMessage() {
        System.out.println(MOVE_RESULT_PRINT_MESSAGE);
    }

    static void printWinner(List<String> winnerNames) {
        OutputPrinter.printFinalWinnerPrintMessage();
        for (String currentName: winnerNames) {
            System.out.print(currentName);
            if (!currentName.equals(winnerNames.get(winnerNames.size() - 1))) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
