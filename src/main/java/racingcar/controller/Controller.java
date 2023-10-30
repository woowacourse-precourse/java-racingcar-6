package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.InputCarName;
import racingcar.domain.RacingCar;
import racingcar.domain.TryNumber;
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
		setGame();
		OutputView.printResultMessage();
		do {
			service.tryOnce(racingCar, tryNumber);
			OutputView.printTryResult(racingCar);
		} while(isTryable());
	}

	private boolean isTryable() {
		return tryNumber.isTryable();
	}

	private void setGame() {
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
