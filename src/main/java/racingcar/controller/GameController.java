package racingcar.controller;

import racingcar.view.Input;
import racingcar.view.Printer;

public class GameController {
	private Printer printer;
	private Input input;
	
	public void playGame() {
		printer.displayMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		
	}
}
