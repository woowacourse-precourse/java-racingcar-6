package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String MOVE_MESSAGE = "-";

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRace(Car car) {
        System.out.print(car.name + " : " );
        for(int i = 0; i < car.moveCount; i++) {
            System.out.print(MOVE_MESSAGE);
        }
        printNewLine();
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print(WINNER_MESSAGE);
        for (int i = 0; i < winners.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(winners.get(i));
        }

    }
}
