package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {
    private final static String WINNER_MESSAGE = "최종 우승자 : ";
    private final static String DELIMITER = ", ";

    public void showWinners(List<Car> winners) {
        StringBuilder raceResult = new StringBuilder();
        raceResult.append(WINNER_MESSAGE);

        String winnerNames = winners.stream()
                .map(winner -> winner.getName())
                .collect(Collectors.joining(DELIMITER));

        raceResult.append(winnerNames);

        System.out.print(raceResult);
    }
}
