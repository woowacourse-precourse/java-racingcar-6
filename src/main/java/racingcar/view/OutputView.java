package racingcar.view;

import racingcar.dto.RacingResult;
import racingcar.dto.Winners;

import java.util.List;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printRoundHeader() {
        System.out.println("실행 결과");
    }

    public void printRacingResult(List<RacingResult> results) {
        results.forEach(result -> {
            String name = result.carName();
            String position = createResultDisplay(result);
            System.out.printf(Constants.OUTPUT_RESULT_FORMAT.message, name, position);
        });
        System.out.println();
    }

    private static String createResultDisplay(RacingResult result) {
        return Constants.OUTPUT_LINES.message.repeat(result.position());
    }

    public void printWinner(Winners winners) {
        String winnerNames = String.join(", ", winners.names());
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private enum Constants {
        OUTPUT_RESULT_MESSAGE("실행 결과"),
        OUTPUT_RESULT_FORMAT("%s : %s%n"),
        OUTPUT_LINES("-"),
        OUTPUT_WINNER("%s가 최종 우승했습니다.");

        private final String message;

        Constants(String message) {
            this.message = message;
        }
    }

}
