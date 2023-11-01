package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarContainer {
	public static final int ICLASS_NUM = 1;
	public static final int INAME_MAX_LENGTH = 5;
	public static List<String> ListCarName;

	public CarContainer() {
	}

	public void setcontainer(String _sInput) {
		ListCarName = new ArrayList<>();
		int iCarNameNum = 0;

		for (String InputSplit : _sInput.split(",")) {
			iCarNameNum++;
			if (InputSplit.length() > INAME_MAX_LENGTH) {
				throw new IllegalArgumentException(iCarNameNum + "번 사용자가 잘못된 값을 입력하였습니다.");
			}
			ListCarName.add(InputSplit);
		}
	}

	public List<String> Get_CarContainer() {
		return ListCarName;
	}
}
