package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	int car = 0;
	int randomNum;
	int position = 0;
//	- 컴퓨터는 각 자동차마다 0에서 9 사이의 무작위 값을 구한다. randomNumber()
	public int randomNumber() {
		randomNum = Randoms.pickNumberInRange(0,9);
		return randomNum;
	}
	
//	- 무작위 값이 4 이상인 경우 전진 driveCar()
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
//	- 무작위 값이 4 미만인 경우 정지 stopCar()
//	- 사용자가 입력한 횟수만큼 위의 경우를 반복한다

} //end of Computer
