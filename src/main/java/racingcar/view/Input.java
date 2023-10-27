package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.utilities.Parse;
import racingcar.dto.Rule;

public class Input {
	static final String splitter = ",";
	
	public static String[] requestCarName() {
		Message.namingMessage();
		String carNames = Console.readLine();
		String[] cars = parseCarNames(carNames);
		return cars;
	}
	
	private static String[] parseCarNames(String carNames) {
		String[] cars;
		try {
			Rule.isStringBlank(carNames);
			cars = Parse.splitString(carNames, splitter);
			// parse -> 몇개인지 확인 -> for (개수) {Car 만들어?} -> List<Car>
			isRuleCorrect(cars);
			return cars;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}
	
	private static boolean isRuleCorrect(String[] cars) {
		Rule.isRuleCorrect(cars);
		return true;
	}
	
	public static void requestRoundNumber(Round round) {
		Message.roundingMessage();
		
	}
}