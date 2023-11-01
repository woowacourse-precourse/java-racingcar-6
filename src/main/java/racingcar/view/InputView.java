package racingcar.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	static public List<String> readNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String line = Console.readLine();
		String[] words = line.split(",");

		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].trim();
		}
		return List.of(words);
	}

	static public int readTurnCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		String line = Console.readLine();
		System.out.println();

		if (isNumeric(line)) {
			return Integer.parseInt(line);
		}
		throw new IllegalArgumentException("올바르지 않은 입력입니다. 정수를 입력해주세요.");
	}

	private static boolean isNumeric(String str) {
		return str != null && str.matches("[0-9.]+");
	}
}
