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
            String str = new StringBuilder()
                    .append(racingCar.getName())
                    .append(" : ")
                    .append(printProgressIndicator(racingCar))
                    .append("\n")
                    .toString();

            print(str);
        }
        print("\n");
    }

    public StringBuilder printProgressIndicator(RacingCar racingCar) {
        StringBuilder progressIndicator = new StringBuilder();
        for (int i = 0; i < racingCar.getPosition(); i++) {
            progressIndicator.append(CAR_PROGRESS_INDICATOR);
        }
        return progressIndicator;
    }

    public void printWinners(List<RacingCar> winners) {
        StringBuilder builder = new StringBuilder()
                .append(WINNER_PREFIX);
        for (int i = 0; i < winners.size(); i++) {
            builder.append(winners.get(i).getName());
            if (i != winners.size() - 1) builder.append(", ");
        }
        builder.append("\n");
        print(builder.toString());
    }


}
