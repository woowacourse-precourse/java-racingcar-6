package racingcar;

import java.util.StringTokenizer;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public int tryNumber;
	public int playerNumber;
	public class PlayerInfo{
		private String name;
		private int loc;
		public PlayerInfo(String name, int loc) {
			this.name = name;
			this.loc = loc;
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
		PlayerInfo[] data = new PlayerInfo[playerNumber];
		
		int i=0;
		while (st.hasMoreElements()) {
			data[i] = new PlayerInfo(st.nextToken(), 0);
			i++;
		}
	}
    public static void main(String[] args) {
    	Application game = new Application();
    	game.gameStart();
    }
}
