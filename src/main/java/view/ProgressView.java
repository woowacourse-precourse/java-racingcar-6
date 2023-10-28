package view;

import model.Car;
import model.Cars;

public class ProgressView {
    private static final String PROGRESS_RESULT_MESSAGE = "실행 결과";
    private static final char DISTANCE_CHARACTER  = '-';

    public static void printProgressResultMessage() {
        System.out.println(PROGRESS_RESULT_MESSAGE);
    }

    public static void printProgress(Cars cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print(DISTANCE_CHARACTER);
            }
            System.out.println();
        }
        System.out.println();
    }
}
