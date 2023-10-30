package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

class TryTimes {
	public static String askTimes() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String tryTimes = Console.readLine();
		
		return tryTimes;
	}

}

class CarName {
	
	public static void inputCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carName = Console.readLine();
		String[] result = carName.split("[,]",0);
		carNameCheck(result);
		List<String> carNames = Arrays.asList(result);
		System.out.println(carNames);		
	}
	
	public static void carNameCheck(String[] str) {
		for(int i = 0; i < str.length; i++) {
			if(str[i].length() > 5) {
				throw new IllegalArgumentException();
			}
		}
	}
	
}