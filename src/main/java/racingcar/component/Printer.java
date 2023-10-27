package racingcar.component;

import java.util.List;

public class Printer {
    private Printer() {}

    private static Printer printer;

    public static Printer getPrinter() {
        if (printer == null) {
            printer = new Printer();
        }
        return printer;
    }

    public void printCurrent(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getProgress());
        }
        System.out.println();
    }
}
