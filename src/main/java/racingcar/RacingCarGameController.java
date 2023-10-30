package racingcar;

public class RacingCarGameController {
    private final RacingCarGameMachine racingCarGameMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(RacingCarGameMachine racingCarGameMachine, InputView inputView, OutputView outputView) {
        this.racingCarGameMachine = racingCarGameMachine;
        this.inputView = inputView;
        this.outputView = outputView;
    }
}
