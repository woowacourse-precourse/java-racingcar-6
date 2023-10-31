package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Cars;

public class OutputView {
    public static void gameStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printOneGameResult(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.print(car.getName() + " : ");
            IntStream.range(0, car.getDistance()).forEach(i -> System.out.print("-"));
            System.out.println();
        });
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("최종 우승자 : ");
        String winner = String.join(",", winners);
        stringBuilder.append(winner);
        System.out.println(stringBuilder);
    }
}
