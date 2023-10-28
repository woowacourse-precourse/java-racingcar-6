package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(
                new RacingCarInputView(),
                new RacingCarOutputView(),
                new RacingCarInputValidator(),
                new RacingCarService(),
                new RacingCarAssemblyService(),
                new RandomCarEngine()
        );
        racingController.run();
    }
}
