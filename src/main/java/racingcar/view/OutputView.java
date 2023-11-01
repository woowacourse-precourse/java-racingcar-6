package racingcar.view;

import racingcar.domain.car.CarDto;
import racingcar.domain.game.GameResultDto;

import java.util.List;

public class OutputView {

    private static final String CAR_STATUS_FORMAT = "\n%s : %s";
    private static final String CAR_POSITION_EXPRESS_CHARACTER = "-";

    private static final String WINNER_DELIMITER = ", ";
    private static final String WINNER_FORMAT = "\n최종 우승자 : %s";

    private OutputView() {

    }

    public static void printResult(GameResultDto result) {
        printLogs(result.logs());
        printWinners(result.winners());
    }

    public static void printLogs(List<List<CarDto>> logs) {
        logs.forEach(log -> {
            StringBuilder roundResult = new StringBuilder();
            log.forEach(carDto -> {
                String position = CAR_POSITION_EXPRESS_CHARACTER.repeat(carDto.position());
                String result = String.format(CAR_STATUS_FORMAT, carDto.name(), position);
                roundResult.append(result);
            });
            System.out.println(roundResult);
        });
    }

    public static void printWinners(List<String> winners) {
        String winner = String.join(WINNER_DELIMITER, winners);
        System.out.printf(WINNER_FORMAT, winner);
    }
}
