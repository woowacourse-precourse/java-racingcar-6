package racingcar;

import java.util.HashMap;
import java.util.List;

// carList에 레이싱에 참여할 자동차 이름을 등록하는 메소드
public class SetCar {
	protected HashMap<String,Integer> carName = new HashMap<>();
	
	public HashMap<String,Integer> carRegister(List<String> carList) {
		for(int i=0;i<carList.size();i++) {
			// 자동차 이름의 길이가 5를 초과하면 예외 처리 진행
        	if(carList.get(i).length() > 5) throw new IllegalArgumentException();
        	this.carName.put(carList.get(i), 0);
        }
		return this.carName;
	}
}
