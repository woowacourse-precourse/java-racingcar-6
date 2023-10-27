package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utilities.Parse;
import racingcar.dto.Rule;

public class Input {
	static final String SPLITTER = ",";
	
	public static String[] requestCarName() {
		Message.namingMessage();
		return getCarNames();
	}
	
	private static String[] getCarNames() {
		try {
			String carNames = Console.readLine();
			String[] cars = parseCarNames(carNames);
			return cars;
		} catch(NullPointerException e) {
			throw new IllegalArgumentException("유효한 수가 아닙니다.");
		}
	}
	
	private static String[] parseCarNames(String carNames) {
		String[] cars;
		Rule.isStringBlank(carNames);
		cars = Parse.splitString(carNames, SPLITTER);
		Rule.isCarNameRuleCorrect(cars);
		return cars;
	}
	
	public static int requestRoundNumber() {
		Message.roundingMessage();
		return getRoundNumber();
	}
	
	private static int getRoundNumber() {
		try {
			String roundNumberString = Console.readLine();
			int roundNumber = parseRoundNumber(roundNumberString);
			return roundNumber;
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("유효한 수가 아닙니다.");
		}
	}
	
	private static int parseRoundNumber(String roundNumberString) {
		Rule.isRoundNumberRuleCorrect(roundNumberString);
		return Parse.parseStringToInt(roundNumberString);
	}
}