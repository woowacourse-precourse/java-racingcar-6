package racingcar.controller;

import static racingcar.exception.ErrorMessage.*;
import static racingcar.utility.InputValidation.*;
import static racingcar.utility.constant.InputRegex.*;
import static racingcar.view.constant.InputConstant.*;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private final InputView inputView;
	private final OutputView outputView;
	private final GameService gameService;

	public GameController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
		gameService = new GameService();
	}

	public void run() {
		inputView.printNamesRequest();
		gameService.createGame(getCars());

		inputView.printRoundRequest();
		play(getRoundCount());
	}

	public void play(Long roundCount) {
		while (roundCount-- > 0) {
			gameService.playRound();
			outputView.stackRoundResult(outputView.getRoundResult(gameService.findAll()));
		}
		outputView.printGameResult();
		outputView.printWinner(gameService.getWinners());
	}

	public List<Car> getCars() {
		String[] names = inputView.getInput().split(INPUT_DELIMITER.getValue(), -1);
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			Car car = new Car(validateName(name).replaceAll(WHITE_SPACE_REGEX.getRegex(), ""));
			if (cars.contains(car)) {
				throw new IllegalArgumentException("\"" + name + "\"" + DUPLICATED_ERROR.getMessage());
			}
			cars.add(car);
		}
		return cars;
	}

	public Long getRoundCount() {
		return validateNumber(inputView.getInput());
	}
}
