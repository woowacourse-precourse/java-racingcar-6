package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class RacingCarView {

	public void printIntro() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public void printTryNumber() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

	public void printStatusIntro() {
		System.out.println("\n"+"실행 결과");
	}

	public void printCarStatus(Map<String,Integer> carStatus) {
		for (Map.Entry<String, Integer> entry : carStatus.entrySet()) {
			String carName = entry.getKey();
			int value = entry.getValue();
			String dashes = "-".repeat(value);
			System.out.println(carName + " : " + dashes);
		}
		System.out.print("\n");
	}

	public static void printResult(List<String> resultCarName) {
		StringJoiner result = new StringJoiner(", ", "최종 우승자 : ", "");
		resultCarName.forEach(result::add);
		System.out.println(result);
	}

}
