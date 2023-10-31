package game;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
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
		Validate.inputPlayerDateIsNumValidate(String.valueOf(try_count));
		return try_count;
	}
	//게임 시작
	public static void gameStart(int tryCount, ArrayList<Car> car_list) {
		System.out.println("\n실행 결과");
		for(int i=1;i<=tryCount;i++) {
			for(Car car : car_list) {
				CarService.forward(car, Randoms.pickNumberInRange(0, 9));
				System.out.println(car.getName()+" : "+CarService.outputCarMOVEMENT(car));
			}
			System.out.println();
		}
	}
	
	//최종우승자(엔딩)
	public static void gameWinner(ArrayList<Car> car_list) {
		String winner = CarService.rankTOPOfCarList(car_list);
		System.out.println("최종 우승자 : "+winner);
	}
	
}
