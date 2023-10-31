package racingcar.view;


import static racingcar.view.constants.IOType.*;

public class ConsoleOutput {

    public static void requestAttemptsCountPrint() {
        System.out.println(REQUEST_ATTEMPTS_COUNT_SENTENCE);
    }

    public static void executionResultPrint(int attemptsCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < attemptsCount; i++) {

        }
    }

    public static void winnersPrint() {
        System.out.print("최종 우승자 : ");
    }
}
