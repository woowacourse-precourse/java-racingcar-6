package view;

import model.Car;
import model.Cars;

public class ProgressView {
    private static final String PROGRESS_RESULT_MESSAGE = "실행 결과";

    public static void printProgressResultMessage() {
        System.out.println(PROGRESS_RESULT_MESSAGE);
    }

    public static void printProgress(Cars cars) {
        for (Car car : cars) {
            System.out.print(car.getName());
            System.out.print(" : ");
            System.out.print(car.getPosition());
            System.out.println();
        }
    }
}
