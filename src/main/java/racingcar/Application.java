package racingcar;

import racingcar.race.Race;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		Race race = new Race();
		race.init();
		race.start();
		race.announceWinner();
	}
}
