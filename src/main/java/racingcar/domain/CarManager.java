package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CarManager {
	public static final int ICLASS_NUM = 5;
	public static List<Integer> iCarRandomState = new ArrayList<Integer>();

	public CarManager(int _CarContainerCount) {
		for (int i = 0; i < _CarContainerCount; i++) {
			iCarRandomState.add(0);
		}
	}

	public void setiCarRandomState() {
		for (int i = 0; i < iCarRandomState.size(); i++) {
			int iRandom = Randoms.pickNumberInRange(0, 9);
			if (iRandom >= 4) {
				int iCarState = iCarRandomState.get(i) + 1;
				iCarRandomState.set(i, iCarState);
			}
		}
	}

	public List<Integer> getiCarRandomState() {
		return iCarRandomState;
	}

}
