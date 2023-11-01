package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.util.CommaDetector;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
	private final GameService gameService = new GameService();
	private final CommaDetector commaDetector = new CommaDetector();
	private final Validator validator = new Validator();
	private final Car car = new Car();

	public void run() {
		saveCars(commaDetector.divideCarNames(getNamesByUserInput()));
		play(createGame());
	}

	private Game createGame() {
		Game game = new Game(getCarList(), getTrialNumber());
		gameService.save(game);
		return game;
	}

	private void play(Game game) {
		OutputView.printHead();
		while (!gameService.isEnd(game)) {
			gameService.play(game);
			OutputView.printScore(game.getCars());
		}
		OutputView.printWinners(gameService.getWinners(game));
	}

	private int getTrialNumber() {
		return commaDetector.divideNumberOfTrial(getTrialByUserInput());
	}

	private List<Cars> getCarList() {
		return car.findAll();
	}

	private void saveCars(List<String> carNames) {
		for (String carName : carNames) {
			car.save(new Cars(carName));
		}
	}

	private String getTrialByUserInput() {
		InputView.requestNumberOfTrialMessage();
		return checkValidationNumberOfTrialInput(Console.readLine());
	}

	private String checkValidationNumberOfTrialInput(String input) {
		try {
			validator.checkNumberOfTrialInput(input);
			return input;
		} catch (IllegalArgumentException e) {
			OutputView.printException(e.getMessage());
			throw e;
		}
	}

	private String getNamesByUserInput() {
		InputView.requestCarNamesMessage();
		String input = Console.readLine();
		return checkValidationCarNamesInput(input);
	}

	private String checkValidationCarNamesInput(String input) {
		try {
			validator.validateInputNames(input);
			return input;
		} catch (IllegalArgumentException e) {
			OutputView.printException(e.getMessage());
			throw e;
		}
	}
}
