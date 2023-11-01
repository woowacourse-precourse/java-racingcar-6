package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarState {
	public static final int ICLASS_NUM = 4;
	public static List<Integer> iCarStateList = new ArrayList<Integer>();

	public CarState(int _CarContainerCount) {
		for (int i = 0; i < _CarContainerCount; i++) {
			iCarStateList.add(0);
		}
	}

	public void set_iCarStateList(List<Integer> _intiCarStateList) {
		for (int i = 0; i < iCarStateList.size(); i++) {
			iCarStateList.set(i, _intiCarStateList.get(i));
		}
	}

	public List<Integer> get_iCarStateList() {
		return iCarStateList;
	}
}
