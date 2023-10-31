package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.RacingMessage;
import racingcar.dto.CarInfo;
import racingcar.dto.RacingStatus;
import racingcar.model.Racing;

public class OutputView {

    private static final String RACING_PROGRESS_FORMAT = "%s : %s";
    private static final String RACING_PROGRESS_BAR = "-";
    private static final String NEW_LINE = "\n";
    private static final String WINNER_NAME_SEPARATOR = ", ";

    public void writeInputCarNameMessage() {
        write(RacingMessage.INPUT_CAR_NAME);
    }

    public void writeInputTryCountMessage() {
        write(RacingMessage.INPUT_TRY_COUNT);
    }

    public void writeTryResultMessage() {
        write(RacingMessage.TRY_RESULT);
    }

    public void writeRacingStatus(RacingStatus racingStatus) {
        write(getRacingStatusMessage(racingStatus));
    }

    public void writeRacingWinner(Racing racing) {
        List<String> winnerNames = racing.getWinningCarNames();
        write(RacingMessage.RACING_WINNER + winnerNames.stream()
            .collect(Collectors.joining(WINNER_NAME_SEPARATOR)));
    }

    private String getRacingStatusMessage(RacingStatus racingStatus) {
        return racingStatus.getCarInfos().stream().map(this::makeCarInfoMessage)
            .collect(Collectors.joining(NEW_LINE)) + NEW_LINE;
    }

    private String makeCarInfoMessage(CarInfo carInfo) {
        return String.format(RACING_PROGRESS_FORMAT, carInfo.getName(),
            RACING_PROGRESS_BAR.repeat(carInfo.getMoveCount()));
    }

    private void write(String message) {
        System.out.println(message);
    }
}
