package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Name;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String WINNER_NAME_DELIMITER = ", ";

    public void printRoundResult(List<Car> racedCars) {
        for (Car racedCar : racedCars) {
            System.out.println(racedCar);
        }
        System.out.println();
    }

    public void printRaceStartMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printWinners(List<Name> winnerNames) {
        List<String> names = winnerNames.stream().map(Name::toString).toList();
        System.out.print(WINNER_MESSAGE);
        System.out.print(String.join(WINNER_NAME_DELIMITER, names));

    }
}
