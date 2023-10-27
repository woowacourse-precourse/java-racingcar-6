package racingcar;

public class RacingcarController {

    private final OutputView outputView;

    public RacingcarController(final OutputView outputView) {
        this.outputView = outputView;
    }

    public void play() {
        outputView.printStartMessage();
    }
}
