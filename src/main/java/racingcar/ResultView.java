package racingcar;

import java.util.List;

public class ResultView {
    public static void printRace(List<Cars> cars) {
        for (Cars car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
