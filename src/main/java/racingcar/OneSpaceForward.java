package racingcar;

import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

// 한 칸 전진을 진행하는 메소드
public class OneSpaceForward {
	private String forward;
	private int ranNum;
	
	public void oneSpace(HashMap<String,Integer> carName, List<String> carList, int number) {
    	for(int j=0;j<carName.size();j++) {
    		this.ranNum = Randoms.pickNumberInRange(0, 9);
    		// 랜덤으로 추출한 수가 4 이상일 때만 전진 진행
    		if(ranNum >= 4) carName.put(carList.get(j),carName.getOrDefault(carList.get(j), 0) + 1);
    		this.forward = "-".repeat(carName.get(carList.get(j)));
    		System.out.println(carList.get(j)+" : "+this.forward);
    	}
    	System.out.println();
	}
}
