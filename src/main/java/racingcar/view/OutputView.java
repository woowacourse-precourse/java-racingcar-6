package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String EXECUTION_RESULTS = "실행 결과";

    public static void exeutionResult() {
        System.out.println();
        System.out.println(EXECUTION_RESULTS);
    }

    public static void resultGame(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static String finalWinnerString(List<Car> winners) {
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            result.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                result.append(", "); // 쉼표로 구분 (마지막 우승자 뒤에는 쉼표를 추가하지 않음)
            }
        }

        return result.toString();
    }

    public static void finalWinner(List<Car> winners) {
        String finalWinner = finalWinnerString(winners);

        System.out.println(finalWinner);
    }
}
