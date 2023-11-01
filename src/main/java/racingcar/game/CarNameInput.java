package racingcar.game;

import static racingcar.msg.Sentence.INPUT_blank;

import camp.nextstep.edu.missionutils.Console;
import racingcar.verfication.Validator;

public class CarNameInput {

	public static String getCarNameInput() {

		try {
			String carNameInput = Console.readLine();
			Validator.outOfCarName(carNameInput);
			return carNameInput;
		} catch (StringIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(INPUT_blank);
		}

	}

}
