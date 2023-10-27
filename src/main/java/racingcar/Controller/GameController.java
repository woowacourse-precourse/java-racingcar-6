package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.View.InputView;

public class GameController {
	public int inputAttemptCount() {

		InputView.printAttemptCount();
		String inputAttemptCount = Console.readLine();
		return Integer.parseInt(inputAttemptCount);

	}



}
