package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	public void inputCarName(){
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		List<String> carName = new ArrayList();
		String registerCarName = Console.readLine();
		carName = Arrays.asList(registerCarName.split(","));
		
		List<Integer> car = new ArrayList<Integer>();
		while(car.size() < carName.size()) {
			car.add(0);
		}
	}

	public void inputAttemptNumbers() {
		System.out.println("시도할 회수는 몇회인가요?");
		int attemptNumbers = Integer.parseInt(Console.readLine());
		System.out.println(attemptNumbers);
	}
} // end of Player
