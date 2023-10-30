package racingcar.util.io;

import camp.nextstep.edu.missionutils.Console;

public class InputViewReader implements Reader{
	
	@Override
	public String readLine() {
		return Console.readLine();
	}
}
