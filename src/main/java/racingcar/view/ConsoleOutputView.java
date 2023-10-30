package racingcar.view;

import racingcar.domain.CarStatus;
import racingcar.domain.RaceStatus;
import racingcar.domain.RacingGameStatus;
import racingcar.domain.WinnerNames;

public class ConsoleOutputView implements OutputView {

    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.";
    private static final String SEPARATED_BY = "(이름은 %s(%s) 기준으로 구분)";
    private static final String REQUEST_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String DRIVE_COUNT_DESCRIPTION_TEXT = "-";
    private static final String CAR_STATUS_MESSAGE = "%s : %s";
    private static final String WINNERS = "최종 우승자 : %s";

    @Override
    public void requestCarNames(String delimiterDescription, String delimiter) {
        String separateMessage = createSeparateMessage(delimiterDescription, delimiter);
        System.out.println(REQUEST_CAR_NAMES + separateMessage);
    }

    private String createSeparateMessage(String delimiterDescription, String delimiter) {
        return String.format(SEPARATED_BY, delimiterDescription, delimiter);
    }

    @Override
    public void requestTryCount() {
        System.out.println(REQUEST_TRY_COUNT);
    }

    @Override
    public void printRacingGameStatus(RacingGameStatus racingGameStatus) {
        printResultMessage();
        racingGameStatus.getRaceStatuses()
                .forEach(this::printRaceStatus);
    }

    private void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    private void printRaceStatus(RaceStatus raceStatus) {
        raceStatus.getCarStatuses()
                .forEach(this::printCarStatus);
        System.out.println();
    }

    private void printCarStatus(CarStatus carStatus) {
        String driveCountText = DRIVE_COUNT_DESCRIPTION_TEXT.repeat(carStatus.getDriveCount());
        String carStatusMessage = String.format(CAR_STATUS_MESSAGE, carStatus.getName(), driveCountText);
        System.out.println(carStatusMessage);
    }

    @Override
    public void printWinnerNames(WinnerNames winnerNames) {
        String winnerNamesText = String.join(", ", winnerNames.getWinnerNames());
        String winnersMessage = String.format(WINNERS, winnerNamesText);
        System.out.println(winnersMessage);
    }
}
