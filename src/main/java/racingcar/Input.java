package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
	public String readCarName(){
		return readLine();
	}
	public int readCount(){
		String count = readLine();
		return Integer.parseInt(count);
	}
}
