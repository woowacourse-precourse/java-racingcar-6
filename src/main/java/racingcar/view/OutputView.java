package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printMoveForward(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int count = 1; count <= car.getMoveForwardCount(); count++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
