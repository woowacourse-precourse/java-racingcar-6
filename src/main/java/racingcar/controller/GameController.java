package racingcar.controller;

import racingcar.view.Input;
import racingcar.view.Printer;

public class GameController {
	private Printer printer = new Printer();
	private Input input = new Input();
	
	public void playGame() {
		printer.displayMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
		input.getCarName();
		printer.displayMessage("시도할 회수는 몇회인가요?\n");
		input.getTrialNumber();
	}
}
