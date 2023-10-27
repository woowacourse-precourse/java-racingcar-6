package racingcar;

import java.util.ArrayList;

public class OutputView {

    public static String dashDraw(int num) {
        String dashs = "";
        for (int i = 0; i < num; i++) {
            dashs += "-";
        }
        return dashs;
    }

    public static void RoundResult(ArrayList<Car> roundResult) {
        for (Car car : roundResult) {
            System.out.println(car.getName() + " : " + dashDraw(car.getPosition()));
        }
    }
}
