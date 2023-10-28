package racingcar.view;

import racingcar.model.Car;

public class OutputView {

    public static void printGameResult(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int i = 0; i < car.getForwardCount(); i++) {
            System.out.print("-");
        }
    }

    public static void printBeforeResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printLine() {
        System.out.println();
    }
}
