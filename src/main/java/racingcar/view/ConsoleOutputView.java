package racingcar.view;

import java.util.List;
import racingcar.controller.dto.GameResultResponse;
import racingcar.model.Position;
import racingcar.model.Vehicle;

public class ConsoleOutputView implements OutputView {

    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_ATTEMPTS_NUMBER_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String GAME_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String COMMA = ",";
    private static final String COLON = " : ";
    private static final String HYPHEN = "-";

    @Override
    public void printCarNameRequestMessage() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
    }

    @Override
    public void printGameAttemptsNumberRequestMessage() {
        System.out.println(GAME_ATTEMPTS_NUMBER_REQUEST_MESSAGE);
    }

    @Override
    public void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    @Override
    public void printGameResult(final GameResultResponse gameResultResponse) {
        gameResultResponse.getMap().forEach((vehicle, position) -> {
            System.out.println(makeResult(vehicle, position));
        });
    }

    private String makeResult(final Vehicle vehicle, final Position position) {
        return vehicle.getName() + COLON + HYPHEN.repeat(position.getPositionIndex());
    }

    @Override
    public void printWinner(final List<String> winners) {
        String result = String.join(COMMA, winners);
        System.out.println(GAME_WINNER_MESSAGE + result);
    }
}
