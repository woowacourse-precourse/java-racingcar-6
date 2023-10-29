package console;

import java.util.List;
import racingcar.Car;

public class Printer {

    public static void printWinners(List<Car> winners) {
        if (winners.isEmpty()) {
            System.out.println("우승자가 없습니다.");
        }
        System.out.print("최종 우승자 : ");
        for( int i = 0; i < winners.size() ; i++ ) {
            System.out.print(winners.get(i));
            if (i != winners.size() - 1) {
                System.out.print(",");
            }
        }
    }

    public static void printCarInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printTryInputMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void printResultMessage() {
        System.out.println("실행결과");
    }

    public static void printNewLine() {
        System.out.println();
    }
}