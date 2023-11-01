package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.GameData;

public class Input {
	private static final int WORDS_LIMIT_NUMBER = 5;

	public void getCarName(GameData data) {
		String carName = Console.readLine();
		String[] carNameList = carName.split(",");
		checkWordsLimit(carNameList);
		data.setCarList(carNameList);
	}

	public int getTrialNumber() {
		String strTrialNumber = Console.readLine();
		int trialNumber = Integer.parseInt(strTrialNumber);
		return trialNumber;
	}

	// input exception1: 이름 5자 이하
	public void checkWordsLimit(String[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].length() > WORDS_LIMIT_NUMBER) {
				throw new IllegalArgumentException("이름은 5자리 이하만 입력해야 합니다.\n게임 종료!");
			}
		}
	}

}
