package racingcar.view;

import java.util.stream.Collectors;
import racingcar.dto.response.CarInfo;
import racingcar.dto.response.RacingStatus;
import racingcar.dto.response.WinnerNames;
import racingcar.model.Racing;

public class OutputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String TRY_RESULT = "실행 결과";
    private static final String RACING_WINNER = "최종 우승자 : %s";
    private static final String RACING_PROGRESS_FORMAT = "%s : %s";
    private static final String RACING_PROGRESS_BAR = "-";
    private static final String NEW_LINE = "\n";
    private static final String WINNER_NAME_SEPARATOR = ", ";


    public void writeInputCarNameMessage() {
        write(INPUT_CAR_NAME);
    }

    public void writeInputTryCountMessage() {
        write(INPUT_TRY_COUNT);
    }

    public void writeTryResultMessage() {
        write(TRY_RESULT);
    }

    public void writeRacingStatus(RacingStatus racingStatus) {
        write(getRacingStatusMessage(racingStatus));
    }

    public void writeRacingWinner(Racing racing) {
        WinnerNames winnerNames = racing.getWinnerNames();
        write(String.format(RACING_WINNER,
            String.join(WINNER_NAME_SEPARATOR, winnerNames.getWinnerNames())));
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
