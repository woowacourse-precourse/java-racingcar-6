package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public int tryNumber;
	public int playerNumber;
	public PlayerInfo[] playerData;
	public String[] winnerArr;
	public class PlayerInfo{
		private String name;
		private int loc;
		
		public PlayerInfo(String name, int loc) {
			this.name = name;
			this.loc = loc;
		}
		
		public void locIncr() {
			loc++;
		}
	}
	
	public void gameStart() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = Console.readLine();
		StringTokenizer st = new StringTokenizer(input, ",");
		playerNumber = st.countTokens();

		System.out.println("시도할 회수는 몇회인가요?");
		String num = Console.readLine();
		tryNumber = Integer.parseInt(num);
		PlayerInfo[] playerData = new PlayerInfo[playerNumber];
		
		int i=0;
		while (st.hasMoreElements()) {
			playerData[i] = new PlayerInfo(st.nextToken(), 0);
			i++;
		}
		run();
	}
	
	public void move() {
		for (int i=0; i<playerNumber; i++) {
			int randNum = Randoms.pickNumberInRange(0,9);
			if (randNum >= 4) playerData[i].locIncr();
		}
	}
	
	public void printCurrent() {
		for (int i=0; i<playerNumber; i++) {
			System.out.print(playerData[i].name + " : ");
			for (int j = 0; j<playerData[i].loc; j++)
				System.out.print('-');
			System.out.println();
		}
		System.out.println();
	}
	
	public int findMaxValue() {
		int maxValue = 0;
		for (int i=0; i<playerNumber; i++) {
			if (maxValue < playerData[i].loc) 
				maxValue = playerData[i].loc;
		}
		return maxValue;
	}
	
	public void makeWinnerArr(int n) {
		int cnt = 0;
		for (int i=0; i<playerNumber; i++) {
			if (playerData[i].loc == n) cnt++;
		}
		
		this.winnerArr = new String[cnt];
		for (int i=0, j=0; i<playerNumber; i++) {
			if (playerData[i].loc == n) {
				winnerArr[j] = playerData[i].name;
				j++;
			}
		}
	}
	
	public void printWinner() {
		System.out.print("최종 우승자 : ");
		List<String> winner = new ArrayList<String>(Arrays.asList(winnerArr));
		String result = String.join(", ", winner);
		System.out.println(result);
	}
	
	public void run() {
		System.out.println("\n실행결과");
		for (int i=0; i<tryNumber; i++) {
			move();
			printCurrent();
		}
		makeWinnerArr(findMaxValue());
		printWinner();
	}
	
    public static void main(String[] args) {
    	Application game = new Application();
    	game.gameStart();
    }
}
