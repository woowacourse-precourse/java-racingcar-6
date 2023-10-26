package racingcar.View;

import java.util.List;
import racingcar.Model.Car;

public class OutputView {

    public static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName()+" : ");
            printPosition(car.getPosition());
        }
    }

    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE +String.join(", ",winners));
    }
}
