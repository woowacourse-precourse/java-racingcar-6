package racingcar.view;

import static racingcar.view.RacingCarConsole.*;
import static racingcar.view.RacingCarConstants.*;

import java.util.List;
import racingcar.model.RacingCar;

public class OutputView {
    public void printResultHeader() {
        print(RESULT_HEADER);
    }

    public void printCars(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            String carStatus = formatCarStatus(racingCar);
            print(carStatus);
        }
        print(NEW_LINE);
    }

    private String formatCarStatus(RacingCar racingCar) {
        return new StringBuilder()
                .append(racingCar.getName())
                .append(CAR_NAME_POSITION_SEPARATOR)
                .append(getProgressIndicator(racingCar))
                .append(NEW_LINE)
                .toString();
    }

    public String getProgressIndicator(RacingCar racingCar) {
        StringBuilder progressIndicator = new StringBuilder();
        for (int i = 0; i < racingCar.getPosition(); i++) {
            progressIndicator.append(CAR_PROGRESS_INDICATOR);
        }
        return progressIndicator.toString();
    }

    public void printWinners(List<RacingCar> winners) {
        String winnerNames = formatWinnerNames(winners);
        print(winnerNames);
    }

    private String formatWinnerNames(List<RacingCar> winners) {
        StringBuilder builder = new StringBuilder(WINNER_PREFIX);
        for (int i = 0; i < winners.size(); i++) {
            builder.append(winners.get(i).getName());
            if (i != winners.size() - 1) builder.append(NAME_SEPARATOR);
        }
        return builder.append(NEW_LINE).toString();
    }
}
