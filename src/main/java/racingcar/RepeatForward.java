package racingcar;

import java.util.HashMap;
import java.util.List;

// 시도 횟수만큼 전진/정지를 반복하는 메소드
public class RepeatForward {

	public void repeat(HashMap<String,Integer> carName, List<String> carList, int number) {
		for(int i=0;i<number;i++) {
        	OneSpaceForward one = new OneSpaceForward();
        	one.oneSpace(carName, carList, number);
        }
	}
}
