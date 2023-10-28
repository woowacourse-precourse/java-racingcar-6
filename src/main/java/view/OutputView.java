package view;

import model.Car;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName());
            System.out.print(" : ");
            System.out.print(car.getPosition());
            System.out.println();
        }
    }
}
