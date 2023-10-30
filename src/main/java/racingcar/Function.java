package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Function {
	
	public static boolean check() {
		int number= Randoms.pickNumberInRange(0,9);
		boolean result= false;
		
		if(number>=4) {
			result= true;
		}
		return result;
	}
	
}
