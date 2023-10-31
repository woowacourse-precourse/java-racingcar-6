package racingcar.view;

import java.util.List;
import racingcar.model.Cars;

public class OutputView {

    public static void printMessage() {
        System.out.println("실행 결과");
    }

    public static void printPlayResult(List<Cars> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + " : ");
            int distance = car.getDistance();
            System.out.println("-".repeat(distance));
        });
        System.out.println();
    }

    public static void printWinner(List<String> result) {
        String winner = String.join(",", result);

        System.out.println("최종 우승자 : " + winner);
    }
}
