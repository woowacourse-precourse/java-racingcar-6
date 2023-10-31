package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

class GameInput {
	protected static List<Pair> parseNames(String namesInput) throws IllegalArgumentException {
		List<String> names = Arrays.asList(namesInput.split(","));
		
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).length() > 5) {
				throw new IllegalArgumentException();
			}
		}
		
		Pair[] tmpInformation = new Pair[names.size()];
		
		for (int i = 0; i < tmpInformation.length; i++) {
			tmpInformation[i] = new Pair();
			tmpInformation[i].setName(names.get(i));
			tmpInformation[i].setLocation(0);
		}
		
		return Arrays.asList(tmpInformation);
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
