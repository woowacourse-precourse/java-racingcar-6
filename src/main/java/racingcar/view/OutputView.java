package racingcar.view;

import java.util.List;
import racingcar.model.dto.CarProgressResponse;

public class OutputView {
    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_TIME_PROMPT = "시도할 회수는 몇회인가요?";
    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNER_TEMPLATE = "최종 우승자 : %s";
    private static final String CAR_PROGRESS_SEPARATOR = " : ";
    private static final String CAR_POSITION_SYMBOL = "-";

    private void printLine(String message) {
        System.out.println(message);
    }

    public void printGameStartConsole() {
        printLine(CAR_NAME_PROMPT);
    }

    public void printRaceTimeInfoConsole() {
        printLine(RACE_TIME_PROMPT);
    }

    public void printResultConsole(List<CarProgressResponse> carProgressResponses) {
        printLine(RESULT_HEADER);
        carProgressResponses.forEach(response -> printLine(formatCarProgress(response)));
    }

    private String formatCarProgress(CarProgressResponse response) {
        return response.name() + CAR_PROGRESS_SEPARATOR + CAR_POSITION_SYMBOL.repeat(response.result());
    }

    public void printWinnerConsole(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        printLine(String.format(WINNER_TEMPLATE, winnerNames));
    }
}
