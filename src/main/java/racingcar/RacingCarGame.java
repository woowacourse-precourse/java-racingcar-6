package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarGame {
	void start(){
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String userInput = Console.readLine();

		List<String> users = List.of(userInput.split(","));
		checkUserName(users);

		System.out.println("시도할 회수는 몇회인가요?");
		String InputLoop = Console.readLine();

		int loop = checkLoop(InputLoop);
	}

	private int checkLoop(String  InputLoop) {
		int loop;

		try {
			loop = Integer.parseInt(InputLoop);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException();
		}

		return loop;
	}

	private void checkUserName(List<String> users) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).length() > 6) {
				throw new IllegalArgumentException();
			}
		}
	}
}
