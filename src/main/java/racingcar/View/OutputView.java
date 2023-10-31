package racingcar.View;

import java.util.List;
import racingcar.Model.Car;

public class OutputView {

    public static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName()+" : ");
            printPosition(car.getPosition());
        }
        System.out.println();
    }

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE +String.join(", ",winners));
    }
}
