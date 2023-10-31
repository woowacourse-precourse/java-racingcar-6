package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class RacingController {
	private final RacingGame racingGame;

	public RacingController(RacingGame racingGame) {
		this.racingGame = racingGame;
	}

	public void runGame() {
		int tryCount = getTryCount();
		System.out.println("\b실행 결과");
		racingGame.runRacing(tryCount);
		printResults();
	}

	private int getTryCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		return Integer.parseInt(Console.readLine());
	}

	private void printResults() {
		List<String> winners = racingGame.getWinners();
		System.out.println("최종 우승자 : " + String.join(", ", winners));
	}
}
