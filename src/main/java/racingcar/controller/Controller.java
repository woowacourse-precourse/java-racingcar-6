package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.InputCarName;
import racingcar.view.InputView;

public class Controller {
	public void run() {
		InputView.askInputCarName();
		String input = Console.readLine();
		InputCarName inputCarName = new InputCarName(input);
	}
}
