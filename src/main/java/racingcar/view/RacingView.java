package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.RacingMessage;
import racingcar.dto.CarInfo;
import racingcar.dto.RacingStatus;
import racingcar.model.Racing;
import racingcar.validator.InputValidator;

public class RacingView {

    private static final String CAR_NAME_SEPARATOR = ",";
    private static final String RACING_PROGRESS_FORMAT = "%s : %s";
    private static final String RACING_PROGRESS_BAR = "-";
    private static final String NEW_LINE = "\n";
    private static final String WINNER_NAME_SEPARATOR = ", ";

    public List<String> inputCarNames() {
        System.out.println(RacingMessage.INPUT_CAR_NAME);
        return List.of(Console.readLine().split(CAR_NAME_SEPARATOR));
    }

    public Integer inputTryCount() {
        System.out.println(RacingMessage.INPUT_TRY_COUNT);
        String input = Console.readLine();
        InputValidator.validateTryCountInput(input);
        return Integer.parseInt(input);
    }

    public void startPrintTryResult() {
        System.out.println(RacingMessage.TRY_RESULT);
    }

    public void showRacingStatus(RacingStatus racingStatus) {
        System.out.println(getRacingStatusMessage(racingStatus));
    }

    public void showRacingWinner(Racing racing) {
        List<String> winnerNames = racing.getWinningCarNames();
        System.out.println(RacingMessage.RACING_WINNER + winnerNames.stream()
            .collect(Collectors.joining(WINNER_NAME_SEPARATOR)));
    }

    private String getRacingStatusMessage(RacingStatus racingStatus) {
        return racingStatus.getCarInfos().stream().map(this::getCarInfoMessage)
            .collect(Collectors.joining(NEW_LINE)) + NEW_LINE;
    }

    private String getCarInfoMessage(CarInfo carInfo) {
        return String.format(RACING_PROGRESS_FORMAT, carInfo.getName(),
            RACING_PROGRESS_BAR.repeat(carInfo.getMoveCount()));
    }
}
