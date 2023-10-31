package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarGame {
	void start(){
		String userInput = Console.readLine();

		List<String> users = List.of(userInput.split(","));
		checkUserName(users);
	}

	private void checkUserName(List<String> users) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).length() > 6) {
				throw new IllegalArgumentException();
			}
		}
	}
}
