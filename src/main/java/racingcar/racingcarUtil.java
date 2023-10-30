package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class TryTimes {
	public static String askTimes() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String tryTimes = Console.readLine();
		
		return tryTimes;
	}

}
