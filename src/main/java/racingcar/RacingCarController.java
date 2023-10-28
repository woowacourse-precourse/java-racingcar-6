package racingcar;

public class RacingCarController {

    private final OutputView outputView;
    private final InputView inputView;
    private final RacingCarService racingCarService;

    public RacingCarController(final OutputView outputView, final InputView inputView, final RacingCarService racingCarService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.racingCarService = racingCarService;
    }

    public void play() {
        outputView.printStartMessage();
        String input = inputView.readRacingCarName();
        racingCarService.saveCarName(input);
        outputView.printRepeatNumberMessage();
        inputView.readRepeatCount();

    }
}
