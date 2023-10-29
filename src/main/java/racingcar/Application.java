package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
	private static Map<String, Integer> carMap = new LinkedHashMap<>();
	private static int turnCount;

	public static int CAR_MOVE_CONDITION = 4;

	public static void main(String[] args) {
		setCarMap();
		// System.out.println(carMap);

		setTurnCount();
		// System.out.println(turnCount);
		System.out.println();

		for (int i = 0; i < turnCount; i++) {
			setCarValue();
			printCarMap();
		}

		printResult();
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

	public static int getRandomValue() {
		return pickNumberInRange(0, 9);
	}

	public static void setCarValue() {
		carMap.forEach((name, value) -> {
			if (getRandomValue() >= CAR_MOVE_CONDITION) {
				carMap.put(name, value + 1);
			}
		});
	}

	public static void printCarMap() {
		System.out.println("실행 결과");
		carMap.forEach((name, value) -> {
			System.out.println(name.concat(" : ").concat("-".repeat(value)));
		});
		System.out.println();
	}

	public static void printResult() {
		List<String> winnerList = new ArrayList<>();
		Integer maxValue = Collections.max(carMap.values());

		carMap.forEach((name, value) -> {
			if (value.equals(maxValue)) {
				winnerList.add(name);
			}
		});
		System.out.println("최종 우승자 : ".concat(String.join(", ", winnerList)));
	}
}
