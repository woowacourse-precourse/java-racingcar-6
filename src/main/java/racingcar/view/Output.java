package racingcar.view;

import java.util.Collections;
import java.util.List;
import racingcar.model.Car;

public class Output {

    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printAttemptNumberMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult() {
        System.out.println("\n실행 결과");
    }

    public static void printRacing() {
        List<String> str = Car.getNames();
        for (int i = 0; i < str.size(); i++) {
            System.out.print(str.get(i) + " : ");
            if (Car.getMoves().size() != 0) {
                for (int j = 0; j < Car.getMoves().get(i); j++) {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    public static void printWinners() {
        List<Integer> winnerMove = Car.getMoves();
        int winner = Collections.max(winnerMove);
        int index = winnerMove.indexOf(winner);
        String name = Car.getNames().get(index);
        System.out.println("최종 우승자 : " + name);
    }
}
