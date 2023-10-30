package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class PlayerInput {
	public List<String> PreCarNameInput() {
		String CarName =  Console.readLine();
		List<String> CarName2 = Arrays.stream(CarName.split(", ")).collect(Collectors.toList());
		
		return CarName2;
	}
	
	public Integer PreMovingCount() {
		String MovingCountStr = Console.readLine();
		int MovingCountInt = Integer.parseInt(MovingCountStr);
		
		return MovingCountInt;
	}
}
