package racingcar.controller;

public class DetermineNameController {

	private final String NAME_LENGTH_EXCEEDED_MESSAGE = "다섯 글자가 초과된 이름이 입력되었습니다.";
	private final int MAX_NAME_LENGTH = 5;

	public String[] isPossibleName(String names) {
		String[] carNames = convertStringToStringList(names);
		if (exceededNameLength(carNames))
			throw new IllegalArgumentException(NAME_LENGTH_EXCEEDED_MESSAGE);

		return carNames;
	}

	private String[] convertStringToStringList(String names) {

		String[] carNames = names.split(",");
		return carNames;
	}

	private boolean exceededNameLength(String[] names) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() > MAX_NAME_LENGTH)
				return true;
		}
		return false;
	}
}
