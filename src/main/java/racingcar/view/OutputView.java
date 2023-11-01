package racingcar.view;

import java.util.List;
import racingcar.model.Cars;

public class OutputView {
    public static void printGameStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printOneGameResult(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getDistance()));
        });
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winner = String.join(",", winners);
        System.out.println("최종 우승자 : " + winner);
    }
}
