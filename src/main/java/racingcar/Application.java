package racingcar;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		Exception InputCarName = new Exception();
		CarMoving CarMoving = new CarMoving();
		Winner Winner = new Winner();

		System.out.println("차의 이름 : ");
		List<String> CarName = InputCarName.CarName();

		System.out.println("시도 회수 : ");
		int TryCount = InputCarName.MovingCount();

		List<Integer> WinnerList = CarMoving.CarMovingPrint(CarName, TryCount);
		Winner.PrintWinnerList(WinnerList, CarName);

	}

}
