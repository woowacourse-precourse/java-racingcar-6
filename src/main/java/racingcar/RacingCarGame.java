package racingcar;


import static racingcar.SystemMessage.EXECUTION_RESULT_PREFIX;
import static racingcar.SystemMessage.INPUT_THE_CAR_NAMES;
import static racingcar.SystemMessage.INPUT_THE_NUMBER_OF_ATTEMPTS;
import static racingcar.SystemMessage.OUTPUT_THE_WINNER_PREFIX;

public class RacingCarGame {
    private final Prompt prompt;

    public RacingCarGame(Prompt prompt) {
        this.prompt = prompt;
    }

    public void start() {
        prompt.println(INPUT_THE_CAR_NAMES);
        String participants = prompt.input();
        prompt.println(INPUT_THE_NUMBER_OF_ATTEMPTS);
        String numberOfAttempts = prompt.input();
        int verifiedNumberOfAttempts = 3;
        prompt.printNewLine();
        prompt.println(EXECUTION_RESULT_PREFIX);
        while (verifiedNumberOfAttempts-- > 0) {
            prompt.println(() -> "실행 과정 출력하기");
            prompt.printNewLine();
        }

        prompt.print(OUTPUT_THE_WINNER_PREFIX);
        String winners = "pobi, jun";
        prompt.print(() -> winners);
    }
}
