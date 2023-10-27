package racingcar;

public class Application {
    public static void main(String[] args) {
        final OutputView outputView = new OutputView();

        final RacingcarController racingcarController = new RacingcarController(outputView);
        racingcarController.play();
    }
}
