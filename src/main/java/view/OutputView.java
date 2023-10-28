package view;

import domain.Car;

import java.util.List;

public class OutputView {
    public static void printException(String message) {
        System.out.println(message);
    }

    public static void printPlayResult() {
        System.out.println("실행 결과");
    }

    public static void printState(List<Car> carList) {
        for (Car car : carList) {
            printCarState(car);
        }
    }

    private static void printCarState(Car car) {
        System.out.println(car.getCar_name() + " : ");
        printDistance(car);
        System.out.println();
    }

    private static void printDistance(Car car) {
        for(int i = 0; i < car.getLocation(); i++) {
            System.out.print("-");
        }
    }
}
