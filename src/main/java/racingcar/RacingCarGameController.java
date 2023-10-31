package racingcar;

import racingcar.constant.OutputMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    private RacingCarGameMachine racingCarGameMachine;
    private InputView inputView;
    private OutputView outputView;
    private TimeSleepStrategy timeSleepStrategy;

    private RacingCarGameController(Builder builder) {
        this.racingCarGameMachine = builder.racingCarGameMachine;
        this.inputView = builder.inputView;
        this.outputView = builder.outputView;
        this.timeSleepStrategy = builder.timeSleepStrategy;
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

    public static class Builder {
        private RacingCarGameMachine racingCarGameMachine;
        private InputView inputView;
        private OutputView outputView;
        private TimeSleepStrategy timeSleepStrategy;

        public Builder() {
        }

        public Builder racingCarGameMachine(RacingCarGameMachine racingCarGameMachine) {
            this.racingCarGameMachine = racingCarGameMachine;
            return this;
        }

        public Builder inputView(InputView inputView) {
            this.inputView = inputView;
            return this;
        }

        public Builder outputView(OutputView outputView) {
            this.outputView = outputView;
            return this;
        }

        public Builder timeSleepStrategy(TimeSleepStrategy timeSleepStrategy) {
            this.timeSleepStrategy = timeSleepStrategy;
            return this;
        }

        public RacingCarGameController build() {
            return new RacingCarGameController(this);
        }
    }
}
