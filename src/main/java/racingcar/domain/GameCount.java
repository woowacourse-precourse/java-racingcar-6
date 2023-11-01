package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class GameCount {
	public static final int ICLASS_NUM = 2;
	public static int iGameCount = 0;

	public GameCount() {
	}

	public void setGameCount() {
		iGameCount = Integer.parseInt(Console.readLine());
	}

	public int getGameCount() {
		return iGameCount;
	}

}
