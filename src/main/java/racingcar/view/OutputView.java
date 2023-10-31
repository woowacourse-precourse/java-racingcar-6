package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatus;
import racingcar.dto.WinnerResult;
import racingcar.message.NoticeMessage;

public class OutputView {

    private static final String POSITION_UNIT = "-";
    private static final String WINNER_NAME_DELIMITER = ", ";

    public static void printRaceStart() {
        System.out.println(NoticeMessage.RACE_START_MESSAGE);
    }

    public static void printTryCount() {
        System.out.println(NoticeMessage.TRY_COUNT_MESSAGE);
    }

    public static void printWinners(WinnerResult winners) {
        System.out.printf(NoticeMessage.FINAL_WINNER_MESSAGE + "%s",
                String.join(WINNER_NAME_DELIMITER, winners.getWinners()));
    }

    public static void printCurrentCarStatus(List<CarStatus> carStatusList) {
        carStatusList.forEach(OutputView::printOneCurrentCarStatus);
        System.out.println();
    }

    private static void printOneCurrentCarStatus(CarStatus carStatus) {
        System.out.printf("%s : %s%n", carStatus.getName(), describeCarPosition(carStatus.getPosition()));
    }

    private static String describeCarPosition(int position) {
        return POSITION_UNIT.repeat(position);
    }

    public static void printResultMessage() {
        System.out.println(NoticeMessage.RESULT_MESSAGE);
    }

    public static void newLine() {
        System.out.println();
    }
}