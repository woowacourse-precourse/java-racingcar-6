package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String NAME_PROGRESS_DELIMITER = " : ";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String PROGRESS_BAR = "-";

    public void printRaceStart() {
        System.out.println("\n실행 결과");
    }

    public void printRacePlayers(List<Car> carList) {
        for (Car car : carList) {
            printCarName(car);
            System.out.print(NAME_PROGRESS_DELIMITER);
            printCarProgress(car);
            System.out.println();
        }
        System.out.println();
    }

    private void printCarName(Car car) {
        System.out.print(car.getName());
    }

    private void printCarProgress(Car car) {
        for (int i = 0; i < car.getProgressCount(); i++) {
            System.out.print(PROGRESS_BAR);
        }
    }

    public void printWinner(List<String> winnerList) {
        String winners = String.join(WINNER_NAME_DELIMITER, winnerList);
        System.out.println("최종 우승자 : " + winners);
    }
}
