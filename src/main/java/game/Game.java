package game;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import car.Car;
import car.CarService;
import util.Validate;

public class Game {
	//게임 준비
	public static ArrayList<Car> gameReady() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carInputData = Console.readLine();
		Validate.inputPlayerDateValidate(carInputData);
		return CarService.getCarListOfString(carInputData);
	}
	//경주 시도할 횟수
	public static int gameTRYCount() {
		int try_count=0;
		System.out.println("시도할 회수는 몇회인가요?");
		try_count = Integer.parseInt(Console.readLine());
		return try_count;
	}
}
