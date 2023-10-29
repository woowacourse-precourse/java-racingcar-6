package racingcar.controller;

import java.util.List;

import org.junit.platform.commons.function.Try;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.InputCarName;
import racingcar.domain.RacingCar;
import racingcar.domain.TryNumber;
import racingcar.view.InputView;

public class Controller {
	private RacingCar racingCar;
	private TryNumber tryNumber;

	public void run() {
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
	}
}
