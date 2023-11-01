package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;

public class OutputView {

    public static String dashDraw(int num) {
        String dashs = "";
        for (int i = 0; i < num; i++) {
            dashs += "-";
        }
        return dashs;
    }

    public static void roundResult(ArrayList<Car> roundResult) {
        for (Car car : roundResult) {
            System.out.println(car.getName() + " : " + dashDraw(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(String[] winners) {
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
