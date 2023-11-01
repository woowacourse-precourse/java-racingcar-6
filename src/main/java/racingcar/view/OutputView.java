package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void printResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printRaceStatus(List<Car> cars) {
        StringBuilder status = new StringBuilder();
        for (Car car : cars) {
            createStatus(status, car);
        }
        System.out.println(status);
    }

    public static void printWinner(List<String> winners) {
        StringBuilder winnerBuilder = new StringBuilder();
        winnerBuilder.append("최종 우승자 : ");
        for (String name : winners) {
            createRaceResult(winnerBuilder, name);
        }
        trimLastComma(winnerBuilder);
        System.out.println(winnerBuilder);
    }

    private static void createStatus(StringBuilder status, Car car) {
        status.append(car.name)
                .append(" : ")
                .append("-".repeat(car.location))
                .append('\n');
    }

    private static void createRaceResult(StringBuilder winnerBuilder, String name) {
        winnerBuilder.append(name).append(", ");
    }

    private static void trimLastComma(StringBuilder winnerBuilder) {
        winnerBuilder.setLength(winnerBuilder.length() - 2);
    }
}
