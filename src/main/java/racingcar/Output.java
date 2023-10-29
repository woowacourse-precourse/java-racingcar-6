package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Output {

    public static void viewResultOfRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.currentStatus());
        }
        System.out.println();
    }

    public static void viewResultOfGame(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        List<String> names = new ArrayList<>();
        for (Car winner : winners) {
            names.add(winner.getName());
        }
        String result = String.join(", ", names);
        System.out.println(result);
    }
}
