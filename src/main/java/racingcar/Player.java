package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	public int totalCar;
	public int attemptNumber;
	public List<String> carName = new ArrayList();
	
	public void inputCarName(){
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String registerCarName = Console.readLine();
			carName = Arrays.asList(registerCarName.split(","));
			totalCar = carName.size();
	}
	
	public List<Integer> carRecord() {
		List<Integer> car = new ArrayList<Integer>();
		while(car.size() < totalCar) {
			car.add(0);
		}
		return car;
	}

	public void inputAttemptNumber() {
		System.out.println("시도할 회수는 몇회인가요?");
		attemptNumber = Integer.parseInt(Console.readLine());
	}	
}
