package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	int randomNum;

	public int randomNumber() {
		randomNum = Randoms.pickNumberInRange(0,9);
		return randomNum;
	}
	
	public List<Integer> driveCar(int totalCar, List<Integer> carRecord) {
		int i = 0;
		
		while(i < totalCar) {
			if(randomNumber() > 3) {
				carRecord.set(i, (carRecord.get(i)+1));
			}
			i++;
		}
		return carRecord;
	}
}
