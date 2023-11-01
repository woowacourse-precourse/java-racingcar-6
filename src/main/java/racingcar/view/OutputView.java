package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
    public static void printHead() {
        System.out.println("실행 결과");
    }
    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }
    public static void printException(String message) {
        System.out.println(message);
    }
}
