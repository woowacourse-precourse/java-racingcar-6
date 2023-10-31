package controller;

import view.MessageView;

public class RacingGameController {
	MessageView messageView = new MessageView();

	public void startGame() {
		initCarData();
	}

	public void initCarData() {
		messageView.printCarNameMessage();
	}
}
