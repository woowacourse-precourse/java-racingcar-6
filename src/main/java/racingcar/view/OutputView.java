package racingcar.view;

import java.util.StringJoiner;
import java.util.stream.IntStream;

import racingcar.util.message.ProgressMessage;

public class OutputView {
	
	public void printInputCarName() {
		System.out.println(ProgressMessage.INPUT_CARNAME.getMessage());
	}
	
	public void printInputTryNumber() {
		System.out.println(ProgressMessage.INPUT_TRY_NUMBER.getMessage());
	}
	
	public void printExecutionResult(String result, int tryNumber) {
		StringJoiner strJoiner = new StringJoiner(System.lineSeparator());
		
		IntStream.range(0, tryNumber).forEach(x -> strJoiner.add(result));
		
		System.out.println(ProgressMessage.EXECUTION_RESULT.getMessage() + "\n" + strJoiner.toString());
	}
	
	public void printWinner(String winner) {
		System.out.printf(ProgressMessage.WINNER.getMessage(), winner);
	}
}
