package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("실행결과");
    }

    public static void printCarStatus(String carName, int position) {
        StringBuilder status = new StringBuilder(carName + " : ");
        for (int i = 0; i < position; i++) {
            status.append("-");
        }
        System.out.println(status.toString());
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            result.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                result.append(", ");
            }
        }
        System.out.println(result.toString());
    }
}
