package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.GameData;
import racingcar.domain.Judgement;
import racingcar.domain.NumberGenerator;
import racingcar.view.Input;
import racingcar.view.Printer;

public class GameController {
	private Printer printer = new Printer();
	private Input input = new Input();
	private NumberGenerator ng = new NumberGenerator();
	private GameData data = new GameData();
	private Judgement referee = new Judgement();

	public void playGame() {
		printer.displayMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
		input.getCarName(data);

		printer.displayMessage("시도할 회수는 몇회인가요?\n");
		int gameCount = input.getTrialNumber();

		printer.displayMessage("실행 결과\n");

		// positionList에 0값 추가하기
		data.setInitPositionList(data.getCarList());

		int i = 0;
		while (i < gameCount) {

			ng.createRandomNumber(data);
			referee.goStop(data);
			printer.displayResult(data);
			i++;
		}
		referee.getWinners(data);
		printer.displayWinners(data.getWinnersList());

	}

}