package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.GameManager;

public class OutputView {

    public static void printRaceResultHeader() {
        System.out.println("실행 결과");
    }

    public static void printCarProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            printCarPosition(car.getCarCurrentPosition());
        }
        System.out.println();
    }

    public static void printCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(GameManager gameManager) {
        List<String> winners = gameManager.getWinners();
        System.out.print("최종 우승자: ");

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if ( i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
