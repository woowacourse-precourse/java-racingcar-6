package view;

import model.Car;

public class OutputView {

    public static void printRacingResult(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }


    public void printWinner() {
    }
}
