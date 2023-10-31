package racingcar.view;

import racingcar.io.OutputViewPrinter;
import racingcar.util.message.ProgressMessage;

public class OutputView {
	
	private static final OutputViewPrinter PRINTER = new OutputViewPrinter();
	
	public void printInputCarName() {
		PRINTER.printLine(ProgressMessage.INPUT_CARNAME.getMessage());
	}
	
	public void printInputTryNumber() {
		PRINTER.printLine(ProgressMessage.INPUT_TRY_NUMBER.getMessage());
	}
	
	public void printExecutionResult() {
		PRINTER.printLine(ProgressMessage.EXECUTION_RESULT.getMessage());
	}
	
	public void printCurrentSituationOfCarLocation(String result) {
		PRINTER.printLine(result);
	}	
	
	public void printWinner(String winner) {
		PRINTER.printFormat(ProgressMessage.WINNER.getMessage(), winner);
	}
}
