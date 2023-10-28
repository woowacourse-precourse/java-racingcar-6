package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class RoundView {
    public static void printRoundResults(List<Car> cars) {

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + generatePositionString(car.getPosition()));
        }
        System.out.println();
    }

    private static String generatePositionString(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
