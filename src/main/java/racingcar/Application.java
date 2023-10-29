package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Application {
	private static Map<String, Integer> carMap = new LinkedHashMap<>();
	private static int turnCount;

	public static void main(String[] args) {
		setCarMap();
		System.out.println(carMap);
		setTurnCount();
		System.out.println(turnCount);
	}

	public static void setCarMap() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = readLine().trim();
		for (String carName : input.split(",")) {
			if (carName.length() == 0) {
				throw new IllegalArgumentException("자동차 이름이 올바르지 않습니다.");
			}
			carMap.put(carName, 0);
		}
	}

	public static void setTurnCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		String input = readLine().trim();
		try {
			turnCount = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}
	}
}
