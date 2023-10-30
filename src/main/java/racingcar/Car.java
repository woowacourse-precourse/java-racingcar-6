package racingcar;

import static racingcar.msg.Sentence.ATTEMPT_NUMBER_INPUT;
import static racingcar.msg.Sentence.RACINGCAR_NAME_INPUT;

import java.util.List;

import racingcar.game.CarNameInput;
import racingcar.game.GameResult;
import racingcar.game.MoveCnt;
import racingcar.game.RandomNum;

public class Car {
	private final RandomNum randomNum = new RandomNum();
	private String carNames;
	private String moveNumber;
	private List<Integer> randomNumber;
	private final GameResult gameResult = new GameResult();
	private List<String> finalWinner;

	public void gameStart() {
		System.out.println(RACINGCAR_NAME_INPUT);
		carNames = CarNameInput.getCarNameInput();
		System.out.println(ATTEMPT_NUMBER_INPUT);
		moveNumber = MoveCnt.getMoveInput();
		// System.out.println(EXECUTION_RESULT);
		// randomNumber = randomNum.getRandomNum();
		// gameResult.result(carNames, moveNumber);
		// System.out.println(FINAL_WINNER);

	}
}
