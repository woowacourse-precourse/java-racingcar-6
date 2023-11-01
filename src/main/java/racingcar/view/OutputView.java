package racingcar.view;

import static racingcar.view.RacingCarConsole.*;
import static racingcar.view.RacingCarConstants.*;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RacingCar;

public class OutputView {
    public void printResultHeader() {
        print(RESULT_HEADER);
    }

    public void printCars(List<RacingCar> racingCars) {
        racingCars.stream()
                .map(this::formatCarStatus)
                .forEach(RacingCarConsole::print);
        print(NEW_LINE);
    }

    private String formatCarStatus(RacingCar racingCar) {
        return racingCar.getName()
                + CAR_NAME_POSITION_SEPARATOR
                + generateProgressIndicator(racingCar)
                + NEW_LINE;
    }

    public String generateProgressIndicator(RacingCar racingCar) {
        return CAR_PROGRESS_INDICATOR.repeat(racingCar.getPosition());
    }

    public void printWinners(List<RacingCar> winners) {
        print(formatWinnerNames(winners));
    }

    private String formatWinnerNames(List<RacingCar> winners) {
        String joinedNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(NAME_SEPARATOR));
        return WINNER_PREFIX + joinedNames + NEW_LINE;
    }
}
