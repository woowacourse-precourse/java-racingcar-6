package racingcar;


import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String enterName = Console.readLine();
		List<String> playerName = splitPlayerName(enterName);
		playerNameCheck(playerName);
	}
	
	//입력받은 플레이어 이름 쉼표 기준으로 나누는 함수
	public static List<String> splitPlayerName(String enterName){
		List<String> playerName = Arrays.asList(enterName.split(","));
		return playerName;
	}

	//playerName List에 저장된 플레이어 이름 글자수 검사하는 함수
	public static void playerNameCheck(List<String> playerName){
		for (String pName : playerName) {
			if(pName.length()>5) {
				throw new IllegalArgumentException();
			}
		} 
	}
}