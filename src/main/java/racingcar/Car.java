package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Car {
	static List<Integer> indexList = new ArrayList<Integer>();
	static String[] carList;

	Ready ready = new Ready();

	public void init() {
		String str = "";
		String times = "";

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		str = Console.readLine();
		carList = ready.checkCondition(str);

		System.out.println("시도할 회수는 몇회인가요?");
		times = Console.readLine();
		System.out.println("\n" + "실행 결과");
		ready.isDigit(times);

		//레이싱 플레이
	}

}
