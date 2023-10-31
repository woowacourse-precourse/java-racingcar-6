package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.InputCarName;
import racingcar.domain.RacingCar;
import racingcar.domain.TryNumber;
import racingcar.domain.Winner;
import racingcar.service.Service;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
	private RacingCar racingCar;
	private TryNumber tryNumber;
	private Service service;

	public Controller() {
		this.service = new Service();
	}

	public void run() {
		setRace();
		OutputView.printResultMessage();
		do {
			service.tryRace(racingCar, tryNumber);
			OutputView.printResult(racingCar);
		} while(isTryable());
		printWinner();
	}

	private void printWinner() {
		Winner winner = new Winner(racingCar.getRacingCar());
		OutputView.printWinner(winner);
	}

	private boolean isTryable() {
		return tryNumber.isTryable();
	}

	private void setRace() {
		setCar();
		setTryNumber();
	}

	private void setCar() {
		this.racingCar = new RacingCar(getCarName());
	}

	private InputCarName getCarName() {
		InputView.askInputCarName();
		return new InputCarName(Console.readLine());
	}

	private void setTryNumber() {
		InputView.askTryNumber();
		this.tryNumber = new TryNumber(Console.readLine());
		System.out.println();
	}
}
