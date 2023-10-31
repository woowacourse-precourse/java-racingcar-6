package racingcar.io;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class OutPut {
    public static void resultSingleRound(RacingGame racingGame) {
        List<Car> cars = racingGame.getCars();
        for (Car car : cars) {
            String positionIndicator = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + positionIndicator);
        }
        System.out.println();
    }

    public static void winner(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        for (Car winner : winners) {
            sb.append(winner.getName()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println("최종 우승자 : " + sb);
    }
}
