package racingcar;

public class Application {
    public static void main(String[] args) {
        final OutputView outputView = new OutputView();
        final InputView inputView = new InputView();

        final RacingCarController racingcarController = new RacingCarController(outputView, inputView);
        racingcarController.play();
    }
}
