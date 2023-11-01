package racingcar.io;

import static racingcar.constant.CarRacingConstant.CAR_POSITION_MARKER;
import static racingcar.constant.CarRacingConstant.WINNER_INFO_DELIMITER;
import static racingcar.constant.CarRacingMessage.CAR_POSITION_OUTPUT_MESSAGE;
import static racingcar.constant.CarRacingMessage.WINNERS_INFO_MESSAGE;

import java.util.List;
import java.util.StringJoiner;

public class CarRacingOutputView {

    public void printCarPosition(String carName, int position) {
        StringBuilder positionText = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionText.append(CAR_POSITION_MARKER);
        }

        printMessage(String.format(CAR_POSITION_OUTPUT_MESSAGE, carName, positionText));
    }

    public void printWinners(List<String> winnerNames) {
        StringJoiner winnerNameJoiner = new StringJoiner(WINNER_INFO_DELIMITER);
        for (String winnerName : winnerNames) {
            winnerNameJoiner.add(winnerName);
        }

        printMessage(String.format(WINNERS_INFO_MESSAGE, winnerNameJoiner));
    }

    public void printMessage(String text) {
        System.out.println(text);
    }

    public void printEnter() {
        System.out.println();
    }
}
