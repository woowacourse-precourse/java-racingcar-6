package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private OutputView() {
    }

    public static void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void requestRound() {
        System.out.println("시도할 회수는 몇회인가요?");
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

    public static void displayWinner(List<String> winners) {
        printNewLine();
        String winnersStr = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s", winnersStr);
    }
}
