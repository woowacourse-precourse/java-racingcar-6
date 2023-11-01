package racingcar.domain;

public class TryTimes {
	public static int checkTryTimes(String inputTimes) {
		int tryTimes = 0;
		try {
			tryTimes = Integer.parseInt(inputTimes);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		return tryTimes;
	}
}
