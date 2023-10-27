package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CreateNumber {

	public boolean makeRandomNumber() {
		
		int ran = Randoms.pickNumberInRange(1, 9);
		
		if(ran<5)
			return false;
		
		return true;
		
	}
	
	public String addString() {
		
		boolean a = makeRandomNumber();
		
		if(a == true)
			return "-";
		
		return "";
	}
	
}
