package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.CarList;
import racingcar.View.InputView;

public class CarListMaker {
	public static CarList makeList() {
		InputView.printCarList();
		String enteredCarList = Console.readLine();

		return new CarList(enteredCarList);

	}

}
