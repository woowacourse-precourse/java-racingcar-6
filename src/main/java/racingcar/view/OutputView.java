package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public void printRacing(List<Car> cars) {
        System.out.print("실행 결과\n");
        for (Car car : cars) {
            printCarPosition(car);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();

        for (Car winner : winners) {
            if (!winnerNames.isEmpty()) {
                winnerNames.append(", ");
            }
            winnerNames.append(winner.getName());
        }
        System.out.print("최종 우승자 : " + winnerNames);
    }
}