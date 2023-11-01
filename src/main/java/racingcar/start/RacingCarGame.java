package racingcar.start;

import racingcar.controller.RacingCarController;
import racingcar.view.RacingCarView;

public class RacingCarGame {

	RacingCarController racingCarController = new RacingCarController();
	RacingCarView racingCarView = new RacingCarView();
	public void run() {
		racingCarView.printIntro();
		racingCarController.saveCarName();
		racingCarController.saveTryNumber();
	}

}
