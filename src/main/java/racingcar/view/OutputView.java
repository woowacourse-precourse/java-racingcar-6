package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public void printResultComment() {
        System.out.println("\n실행 결과");
    }

    public void printRacing(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public void printWinners(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();

        for (Car winner : winners) {
            if (!winnerNames.isEmpty()) {
                winnerNames.append(", ");
            }
            winnerNames.append(winner.getName());
        }
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
