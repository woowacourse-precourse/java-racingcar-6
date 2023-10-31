package racingcar;

import racingcar.constant.OutputMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    private final RacingCarGameMachine racingCarGameMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(RacingCarGameMachine racingCarGameMachine, InputView inputView, OutputView outputView) {
        this.racingCarGameMachine = racingCarGameMachine;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        init();
        executeGame();
        generateResult();
    }

    private void init() {
        outputView.print(OutputMessage.RACING_CAR_NAME_INPUT_REQUEST);
        String nameInput = inputView.readLine();
        outputView.print(OutputMessage.ROUND_COUNT_INPUT_REQUEST);
        int roundCount = inputView.readInt();
        racingCarGameMachine.init(nameInput, roundCount);
    }

    private void executeGame() {
        outputView.print(OutputMessage.EXECUTION_RESULT);

        while (racingCarGameMachine.isGameInProgress()) {
            String roundResult = racingCarGameMachine.getRoundResult();
            outputView.print(roundResult);
        }
    }

    private void generateResult() {
        String gameResult = racingCarGameMachine.getGameResult();
        outputView.print(gameResult);
    }
}
