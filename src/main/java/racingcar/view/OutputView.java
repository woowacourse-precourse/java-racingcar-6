package racingcar.view;

import java.util.List;
import racingcar.dto.CarResultResponse;

public class OutputView {

    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_GAME_PROGRESS_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String GAME_PROCESS_MESSAGE = "\n실행 결과";
    private static final String GAME_WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printInputGameProgressCountMessage() {
        System.out.println(INPUT_GAME_PROGRESS_COUNT_MESSAGE);
    }

    public void printGameProcessMessage() {
        System.out.println(GAME_PROCESS_MESSAGE);
    }

    public void printGameProcessResult(List<CarResultResponse> carResultResponses) {
        StringBuilder sb = new StringBuilder();

        for (CarResultResponse carResultResponse : carResultResponses) {
            sb.append(carResultResponse).append("\n");
        }

        System.out.println(sb);
    }

    public void printGameWinners(List<String> winners) {
        System.out.printf(GAME_WINNER_MESSAGE_FORMAT, String.join(",", winners));
    }
}
