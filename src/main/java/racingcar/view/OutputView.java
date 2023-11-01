package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public static void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : ");
        String result = String.join(", ", winner);
        System.out.println(result);
    }

    public static void printRaceResult() {
        System.out.println("\n실행 결과");
    }

    public static void printMoveForward(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int count = 1; count <= car.getMoveForwardCount(); count++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
