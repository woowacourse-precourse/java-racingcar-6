package racingcar.controller;

import racingcar.service.Game;

public class Controller {
	public void start() {
		Game racingGame = new Game();
		setGame(racingGame);
		startGame(racingGame);
		endGame(racingGame);
	}
	
	private void setGame(Game racingGame) {
		racingGame.setGame();
	}
	
	private void startGame(Game racingGame) {
		racingGame.startGame();
	}
	
	private void endGame(Game racingGame) {
		racingGame.endGame();
	}
	
}