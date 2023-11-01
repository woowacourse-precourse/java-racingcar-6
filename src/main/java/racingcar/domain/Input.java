package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	public static final int ICLASS_NUM = 0;
	public String Sinput;

	public Input() {
	}

	public String readLine() {
		Sinput = Console.readLine();
		return Sinput;
	}
}
