package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.InputCarName;
import racingcar.domain.TryNumber;
import racingcar.view.InputView;

public class Controller {

	public void run() {
		setCarName();
		setTryNumber();
	}

	private void setCarName() {
		InputView.askInputCarName();
		InputCarName inputCarName = new InputCarName(Console.readLine());
	}

	private void setTryNumber() {
		InputView.askTryNumber();
		TryNumber tryNumber = new TryNumber(Console.readLine());
	}
}
