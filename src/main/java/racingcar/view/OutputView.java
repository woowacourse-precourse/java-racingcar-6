package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
    private OutputView() {
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void displayCar(Car car) {
        printNewLine();
        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

}
