package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Judgement {
	private static final int STANDARD_NUMBER = 4;
	
	public static void goStop(GameData data) {
		for (int i = 0; i < data.getNumberList().size(); i++) {
			if (data.getNumberList().get(i) >= STANDARD_NUMBER) {
				data.getPositionList().set(i, (data.getPositionList().get(i) + 1)); // 원래 값에 1 추가   
			}
		}
	}
	

	
}
