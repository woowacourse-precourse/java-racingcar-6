package racingcar;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String enterName = Console.readLine();
		List<String> playerName = splitPlayerName(enterName);
		playerNameCheck(playerName);

		System.out.println("시도할 회수는 몇회인가요?");
		String tryStr = Console.readLine();
		int tryNum = 0;
		//입력받은 시도회수가 숫자가 아닐 때 exception 발생
		if(Pattern.matches("^[0-9]*$", tryStr)){
			tryNum = Integer.parseInt(tryStr);
		}else {
			throw new IllegalArgumentException();
		}

		System.out.println("\n실행결과");
		Map<String, String> resultMap = new LinkedHashMap<>();
		for (String keyName : playerName) {
			resultMap.put(keyName, "");
		}

		for(int i=0;i<tryNum;i++) {
			for (String key : resultMap.keySet()) {
				int ranNum = Randoms.pickNumberInRange(0, 9);
				forward(ranNum,resultMap,key);
				System.out.println(key+" : "+resultMap.get(key));
			}
			System.out.println();
		}

		//우승자
		int lengOfVal = 0;
		String winner = "";
		for(String key : resultMap.keySet()) {
			if(resultMap.get(key).length()>lengOfVal) {
				lengOfVal = resultMap.get(key).length();
				winner = key;
			}
			else if(resultMap.get(key).length()==lengOfVal) {
				winner += ", "+key;
			}
		}

		System.out.println("최종 우승자 : "+winner);

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

	//랜덤 숫자가 4이상일 때 전진하는 함수
	public static void forward(int ranNum, Map<String, String> resultMap, String key) {
		if(ranNum>=4) {
			String value = resultMap.get(key)+"-";
			resultMap.replace(key, value);
		}
	}
}