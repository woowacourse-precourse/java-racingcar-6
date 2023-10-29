package racingcar.view;

import racingcar.util.message.ProgressMessage;

public class OutputView {
	
	public void printInputCarName() {
		System.out.println(ProgressMessage.INPUT_CARNAME.getMessage());
	}
	
	public void printInputTryNumber() {
		System.out.println(ProgressMessage.INPUT_TRY_NUMBER.getMessage());
	}
	
	public void printExecutionResult() {
		System.out.println(ProgressMessage.EXECUTION_RESULT.getMessage());
	}
	
	public void printCarLocationCurrentSituation(String result) {
		System.out.println(result);
	}	
	
	public void printWinner(String winner) {
		System.out.printf(ProgressMessage.WINNER.getMessage(), winner);
	}
}
