package racingcar;

public class Application {
	public static void main(String[] args) {
		RacingController racingController = new RacingController(new RacingGame(), new RandomNumberGeneratorImpl());
		racingController.runGame();
	}
}
