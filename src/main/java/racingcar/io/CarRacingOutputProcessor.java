package racingcar.io;

import static racingcar.constant.CarRacingConstant.CAR_POSITION_MARKER;
import static racingcar.constant.CarRacingConstant.WINNER_INFO_DELIMITER;
import static racingcar.constant.CarRacingMessage.CAR_POSITION_OUTPUT_MESSAGE;
import static racingcar.constant.CarRacingMessage.WINNERS_INFO_MESSAGE;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.Car;

public class CarRacingOutputProcessor {

    public void printCarPosition(String carName, int position) {
        StringBuilder positionText = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionText.append(CAR_POSITION_MARKER);
        }

        println(String.format(CAR_POSITION_OUTPUT_MESSAGE, carName, positionText));
    }

    public void printWinners(List<Car> winners) {
        StringJoiner winnerNameJoiner = new StringJoiner(WINNER_INFO_DELIMITER);
        for (Car winner : winners) {
            winnerNameJoiner.add(winner.getName());
        }

        println(String.format(WINNERS_INFO_MESSAGE, winnerNameJoiner));
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void printEnter() {
        System.out.println();
    }
}
