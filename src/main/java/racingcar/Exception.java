package racingcar;

import java.util.List;


public class Exception {

	PlayerInput Input = new PlayerInput();

	public List<String> CarName() {
		List<String> Name = Input.PreCarName();
		InputRangeException(CarName_Max_LengthSize(Name));

		return Name;
	}

	public Integer MovingCount() {
		String Count = Input.PreMovingCountInput();
		int MoveCount = InputStrException(Count);

		return MoveCount;
	}

	private void InputRangeException(Integer LengthSize) {
		if (LengthSize > 5) {
			throw new IllegalArgumentException("5자 이하로 입력하십시오.");
		}
	}

	private Integer CarName_Max_LengthSize(List<String> InputName) {
		List<String> lines = InputName;
		return lines.stream().mapToInt(String::length).max().getAsInt();
	}

	private static int InputStrException(String PreCount) {
		int num = 0;

		try {
			num = Integer.parseInt(PreCount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자를 입력하십시오.");
		}

		return num;
	}

}
