package racingcar.view;

import static racingcar.constant.RacingMessage.*;
import static racingcar.constant.RacingSign.NEW_LINE;
import static racingcar.constant.RacingSign.RACING_PROGRESS_BAR;
import static racingcar.constant.RacingSign.WINNER_NAME_SEPARATOR;

import java.util.stream.Collectors;
import racingcar.dto.response.CarInfo;
import racingcar.dto.response.RacingStatus;
import racingcar.dto.response.WinnerNames;
import racingcar.model.Racing;

public class OutputView {

    public void writeInputCarNameMessage() {
        write(getInputCarNameMessage());
    }

    public void writeInputTryCountMessage() {
        write(getInputTryCountMessage());
    }

    public void writeTryResultMessage() {
        write(getTryResultMessage());
    }

    public void writeRacingStatus(RacingStatus racingStatus) {
        write(getRacingStatusMessage(racingStatus));
    }

    public void writeRacingWinner(Racing racing) {
        WinnerNames winnerNames = racing.getWinnerNames();
        write(getWinnerMessage(
            String.join(WINNER_NAME_SEPARATOR.toString(), winnerNames.getWinnerNames())));
    }

    private String getRacingStatusMessage(RacingStatus racingStatus) {
        return racingStatus.getCarInfos().stream().map(this::makeCarInfoMessage)
            .collect(Collectors.joining(NEW_LINE.toString())) + NEW_LINE;
    }

    private String makeCarInfoMessage(CarInfo carInfo) {
        return getRacingProgressMessage(carInfo.getName(),
            RACING_PROGRESS_BAR.toString().repeat(carInfo.getMoveCount()));
    }

    private void write(String message) {
        System.out.println(message);
    }
}
