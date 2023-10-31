package racingcar;

import camp.nextstep.edu.missionutils.Console;
import view.InputView;
import view.OutputView;

public class Application {

	public static void main(String[] args) {
		final CarList carList = new CarList();
		final InputView inputView = new InputView();
		final OutputView outputView = new OutputView();

		inputView.printCarNameInputMessage();
		String carNames = Console.readLine();
		carList.splitCarNames(carNames);

		inputView.printAttemptNumberInputMessage();
		int attempt = Integer.parseInt(Console.readLine());

		for (int i = 0; i < attempt; i++) {
			outputView.printResult(carList);
		}

		outputView.printWinners(carList.getWinners());

	}
}
