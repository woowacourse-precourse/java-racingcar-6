package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

class GameInput {
	protected static List<String> parseNames(String namesInput) throws IllegalArgumentException {
		List<String> names = Arrays.asList(namesInput.split(","));
		
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).length() > 5) {
				throw new IllegalArgumentException();
			}
		}
		
		return names;
	}
	
	protected static String getNames() {
		return Console.readLine();
	}
	
	protected static int getTrial() throws IllegalArgumentException {
		String trialInput = Console.readLine();
		
		try {
			return Integer.valueOf(trialInput);
		}
		catch(NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}
