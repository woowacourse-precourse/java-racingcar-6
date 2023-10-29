package racingcar.domain.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void outputRaceProgress(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n").append("실행 결과").append("\n");
        for (Car car : cars) {
            sb.append(car.getName()).append(" : ").append("-".repeat(car.getPosition())).append("\n");
        }

        System.out.println(sb);
    }

    public static void outputWinner(List<String> cars) {
        System.out.print("최종 우승자 : ");

        String winners = String.join(", ", cars);
        System.out.println(winners);
    }
}
