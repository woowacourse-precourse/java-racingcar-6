package racingcar;

import static racingcar.msg.Sentence.ATTEMPT_NUMBER_INPUT;
import static racingcar.msg.Sentence.EXECUTION_RESULT;
import static racingcar.msg.Sentence.RACINGCAR_NAME_INPUT;

import racingcar.game.CarNameInput;
import racingcar.game.GameResult;
import racingcar.game.MoveCnt;

public class Car {
	private String carNames;
	private String[] carNamesArray;
	private int moveNumber;

	public void gameStart() {
		System.out.println(RACINGCAR_NAME_INPUT);
		carNames = CarNameInput.getCarNameInput();
		carNamesArray = carNames.split(",");
		System.out.println(ATTEMPT_NUMBER_INPUT);
		moveNumber = MoveCnt.getMoveInput();
		System.out.println("\n" + EXECUTION_RESULT);
		GameResult.execution_result(carNamesArray, moveNumber);

	}
}
