package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class UserOutput {
    private UserOutput() {
    }

    public static void askForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askForTryCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    public static void showResult() {
        System.out.println("\n실행결과");
    }

    public static void showWinners(List<String> winners) {
        String winnersStr = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s", winnersStr);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void displayCar(Car car) {

        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        printNewLine();
    }

}
