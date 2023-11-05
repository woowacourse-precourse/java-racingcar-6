package racingcar.execution;

import racingcar.data.attempt.Attempt;

public class GameExecution {
    private final GameInput gameInput;
    private final GameOutput gameOutput;
    private static final String REQUEST_RACING_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ATTEMPT_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public GameExecution() {
        this.gameInput = new ConsoleInput();
        this.gameOutput = new ConsoleOutput();
    }

    public String fetchRacingCarName() {
        gameOutput.print(REQUEST_RACING_CAR_NAME_MESSAGE);
        return gameInput.scan();
    }

    public String fetchAttemptNumber() {
        gameOutput.print(REQUEST_ATTEMPT_NUMBER_MESSAGE);
        return gameInput.scan();
    }

    public void printAttemptResultMessage() {
        gameOutput.print(ATTEMPT_RESULT_MESSAGE);
    }

    public void printAttemptResult(Attempt attempt) {
        gameOutput.print(attempt);
    }

    public void printGameResult(String result) {
        gameOutput.print(FINAL_WINNER_MESSAGE + result);
    }
}
