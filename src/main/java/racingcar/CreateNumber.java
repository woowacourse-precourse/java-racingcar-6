package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class CreateNumber {

	public boolean make_number() {
		
		int ran = Randoms.pickNumberInRange(1, 9);
		
		if(ran<=4&&ran>=1)
			return false;
		
		return true;
		
	}
	
	public String addString() {
		
		boolean a = make_number();
		
		if(a == true)
			return "-";
		
		return "";
	}
	
}
