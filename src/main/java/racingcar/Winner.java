package racingcar;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// 레이싱 최종 결과를 출력하는 메소드
public class Winner {
	private int max;
	private int winnerCnt = 1;
	
	public void announce(HashMap<String,Integer> carName, List<String> carList) {
		this.max = Collections.max(carName.values());
		System.out.print("최종 우승자 : ");
		for(int i=0;i<carName.size();i++) {
        	if(carName.get(carList.get(i)) == max) {
        		if(winnerCnt > 1) System.out.print(", ");
        		System.out.print(carList.get(i));
        		this.winnerCnt++;
        	}        		
        }
	}
}
