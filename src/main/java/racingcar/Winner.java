package racingcar;

import java.util.Collections;
import java.util.HashMap;

public class Winner extends SetRacing{
	private int max = Collections.max(carName.values());
	private int winnerCnt = 0;
	
	public void announce(HashMap<String,Integer> carName, String[] arr) {
		for(int i=0;i<carName.size();i++) {
        	if(carName.get(arr[i]) == max) {
        		if(winnerCnt > 1) System.out.print(", "+arr[i]);
        		else System.out.print(arr[i]);
        		winnerCnt++;
        	}        		
        }
	}
}
