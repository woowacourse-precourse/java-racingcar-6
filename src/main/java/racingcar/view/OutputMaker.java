package racingcar.view;

import static racingcar.constant.RacingMessage.getRacingProgressMessage;
import static racingcar.constant.RacingMessage.getWinnerMessage;
import static racingcar.constant.RacingSign.NEW_LINE;
import static racingcar.constant.RacingSign.RACING_PROGRESS_BAR;
import static racingcar.constant.RacingSign.WINNER_NAME_SEPARATOR;

import java.util.stream.Collectors;
import racingcar.dto.response.CarInfo;
import racingcar.dto.response.RacingStatus;
import racingcar.dto.response.WinnerNames;

public class OutputMaker {

    public String makeRacingWinnerOutput(WinnerNames winnerNames) {
        return getWinnerMessage(
            String.join(WINNER_NAME_SEPARATOR.toString(), winnerNames.getWinnerNames()));
    }

    public String makeRacingStatusOutput(RacingStatus racingStatus) {
        return racingStatus.getCarInfos().stream().map(this::makeCarInfoOutput)
            .collect(Collectors.joining(NEW_LINE.toString())) + NEW_LINE;
    }

    private String makeCarInfoOutput(CarInfo carInfo) {
        return getRacingProgressMessage(carInfo.getName(),
            RACING_PROGRESS_BAR.toString().repeat(carInfo.getMoveCount()));
    }
}
