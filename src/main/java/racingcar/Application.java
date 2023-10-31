package racingcar;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		Exception InputCarName = new Exception();

		System.out.println("차의 이름 : ");
		List<String> CarName = InputCarName.CarName();

		System.out.println("시도 회수 : ");
		int MovingCount = InputCarName.MovingCount();

		CarMoving carMoving = new CarMoving();


	}
	
}
