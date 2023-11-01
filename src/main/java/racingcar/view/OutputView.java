package racingcar.view;

import static racingcar.model.Car.carsNum;
import static racingcar.model.CarForward.forwardCount;
import static racingcar.view.InputView.cars;

import java.util.List;

public class OutputView {
    public static void printCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public static void printGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printGameResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printForwardResult() {
        for (int i = 0; i < carsNum; i++) {
            System.out.print(cars[i] + " : ");
            System.out.println(forwardCount[i]);
        }
        System.out.println();
    }

    public static void printWinners() {
        System.out.print("최종 우승자 : ");
    }
}
