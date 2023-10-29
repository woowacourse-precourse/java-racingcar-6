package main.java.racingcar.view;

import java.util.List;

import main.java.racingcar.model.Car;
public class ProcessView {

    public static void printMovement(List<Car> cars) {
        for (Car car: cars) {
            System.out.print(car.getName() + " : ");
            printHowFar(car);
            System.out.println();
        }
        System.out.println();
    }
    private static void printHowFar(Car car) {
        for (int i = 0; i < car.getPosition() ; i++) {
            System.out.print("-");
        }
    }

}
