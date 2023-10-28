package racingcar.View;

import java.util.List;
import racingcar.Model.Car.Car;

public class RaceView {
    private static final String ROUND_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ROUND_START_MESSAGE = "실행 결과";
    private static final String DISTANCE_MARK = "-";

    public void print(Car car, int distance) {
        String name = car.getCarName().getName();
        System.out.println(name + " : " + DISTANCE_MARK.repeat(distance));
    }

    public static void processStartMessage() {
        System.out.println(ROUND_COUNT_MESSAGE);
    }

    public static void roundStartMessage() {
        System.out.println(ROUND_START_MESSAGE);
    }

    public void printWinner(List<String> winnerCarName) {
        String winners = String.join(", ", winnerCarName);
        System.out.println("최종 우승자 : " + winners);
    }
}
