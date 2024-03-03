package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
    private static final String WIN_MESSAGE = "최종 우승자 : ";

    public static void printRoundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.printf("%s : %s\n", car.getName(), car.getStatus());
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder winnerName = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            winnerName.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                winnerName.append(", ");
            }
        }
        System.out.printf(WIN_MESSAGE + "%s", winnerName);
    }
}
