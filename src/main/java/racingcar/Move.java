package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Move{
	static String[] carLocation;
	
	public static void isMove(ArrayList<Car> carList, String[] carLocation){	
		for(int i=0; i<carLocation.length; i++) {
			if(Randoms.pickNumberInRange(0, 9) >= 4) {
				carLocation[i] += "-";
			}
			System.out.println(carList.get(i).name + " : " + carLocation[i]);
			Move.carLocation = carLocation;
		}
	}
}
