package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	private static String name = "";
	private static String splitResult = "";

	public Player() {}
	
	public String createName(){
		System.out.println(PrintMessage.START_MESSAGE);
		name = Console.readLine();
		return name;
	}
	
	public String splitNameDisplay() {
		splitResult = String.join(",", name);
		return splitResult;
	}

	public List<String> memberList(){
		List<String> players = new ArrayList<>();
		players = Arrays.asList(splitResult);
		return players;
	}



}
