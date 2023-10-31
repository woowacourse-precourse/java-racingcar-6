package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class OutputView {

    public static final String PRINT_FINAL_RESULT = "최종 우승자 : ";
    public static final String EACH_RESULT_MESSAGE = "\n실행 결과";

    public void printFinalResult(List<String> winners) {
        System.out.print(PRINT_FINAL_RESULT);
        String winner = String.join(",",winners);
        System.out.print(winner);
    }

    public void printEachResult(Car car, int randomNumber) {
        System.out.print(car.getName() + " : ");
        printEachRandomResult(randomNumber);
        System.out.println();

    }

    public void printEachRandomResult(int randomNumber) {
        for (int i = 0; i < randomNumber; i++) {
            System.out.print("-");
        }
    }
    public void printEachResultMessage(int tryCount) {
        if (tryCount == 0) {
            System.out.println(EACH_RESULT_MESSAGE);
        }
    }
}
