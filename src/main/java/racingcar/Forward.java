package racingcar;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Forward {
	public void carForward(HashMap<String,Integer> carName, String[] arr, int number) {
		for(int i=0;i<number;i++) {
        	for(int j=0;j<carName.size();j++) {
        		if(Randoms.pickNumberInRange(0, 9) >= 4)
        			carName.put(arr[j],carName.getOrDefault(arr[j], 0) + 1);
        		String forward = "-".repeat(carName.get(arr[j]));
        		System.out.println(arr[j]+" : "+forward);
        	}
        	System.out.println();
        }
	}
}
