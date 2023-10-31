package racingcar;

import java.util.ArrayList;

public class ScoreBoard { //String[] -> void
	public static void moveCar(ArrayList<Car> carList, int attemptNum) {
		String[] carLocation = new String[carList.size()];
		for(int i=0; i<carLocation.length; i++) {
			carLocation[i] = "";
		}
		
		System.out.println("실행 결과");
		for(int attempt=0; attempt<attemptNum; attempt++) {
			Move.isMove(carList, carLocation);
			System.out.println();
		}
	}
}
