package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class ConsoleOut {

    public static void requestCarNamePrint() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void requestAttemptsCountPrint() {
        System.out.println("시도할 회수는 몇회인가요?");
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
