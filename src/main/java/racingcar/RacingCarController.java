package racingcar;

public class RacingCarController {

    private final OutputView outputView;
    private final InputView inputView;

    public RacingCarController(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play() {
        outputView.printStartMessage();
        inputView.readRacingCarName();
        outputView.printRepeatNumberMessage();
        inputView.readRepeatCount();
    }
}
