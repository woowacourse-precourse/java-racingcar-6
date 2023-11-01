package racingcar.game;

import static racingcar.msg.Sentence.INPUT_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class MoveCnt {

	public static int getMoveInput() {
		try {
			int input = Integer.parseInt(Console.readLine());
			return input;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INPUT_NUMBER);
		}
	}

}
