package racingcar.view;

import java.util.StringJoiner;
import racingcar.domain.CarGroup;

public class OutputView {
    private static final String PROGRESS_SIGN = "-";
    private static final String PROGRESS_SEPARATOR = " : ";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";


    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printProgress(CarGroup carGroup) {
        carGroup.getCars().forEach(car -> {
            String carNickname = car.getNickname();
            int carPosition = car.getPosition();
            String progress = PROGRESS_SIGN.repeat(carPosition);
            System.out.println(carNickname + PROGRESS_SEPARATOR + progress);
        });
        printBlankLine();
    }


    public static void printWinners(StringJoiner winnerList) {
        System.out.println(WINNER_MESSAGE + winnerList);
    }

    private static void printBlankLine() {
        System.out.println();
    }
}
