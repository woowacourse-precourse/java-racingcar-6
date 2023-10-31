package view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constants;

public class InputView {
	public static String carInput() {
		System.out.println(Constants.INPUT_START);
		return Console.readLine();
	}

	public static String roundInput() {
		System.out.println(Constants.TRY_NUM_START);
		return Console.readLine();
	}
}
