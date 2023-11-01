package racingcar.output;

public class OutputController {

	public void printCarNameInputMessage() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public void printTryingCountsInputMessage() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public void printResult(String racingCarResult) {
		System.out.println(racingCarResult);
	}
}
