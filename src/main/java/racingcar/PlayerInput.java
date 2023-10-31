package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class PlayerInput {
	private String PreCarNameInput() {
		
		return Console.readLine();
	}

	public List<String> PreCarName() {
		List<String> CarName = Arrays.stream(PreCarNameInput().split(",")).collect(Collectors.toList());

		return CarName;
	}

	public String PreMovingCountInput() {
		return Console.readLine();
	}

}
