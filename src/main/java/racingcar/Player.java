package racingcar;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	private static String name = "";
	
	public Player() {}
	
	public String createName(){
		System.out.println(PrintMessage.START_MESSAGE);
		name = Console.readLine();
		return name;
	}
	
	public List<String> memberList(){
		List<String> players = Arrays.asList(name);
		return players;
	}
	
	public String splitNameDisplay() {
		String splitResult = String.join(",", name);
		return splitResult;
	}
	
}
