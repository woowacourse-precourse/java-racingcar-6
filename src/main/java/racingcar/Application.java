package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.util.Validator;

public class Application {
	public static void main(String[] args) {
		GameController controller = new GameController(
				new GameService(),
				new Validator()
		);

		controller.start();
	}
}