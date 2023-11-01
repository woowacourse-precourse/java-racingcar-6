package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		Cars cars = new Cars(Console.readLine());

		System.out.println("시도할 회수는 몇회인가요?");
		TryCount tryCount = new TryCount(Console.readLine());

		System.out.println("\n실행 결과");
		Race race = new Race();
		race.start(cars, tryCount);

		WinnerCalculator winnerCalculator = new WinnerCalculator();
		System.out.print("최종 우승자 : ");
		System.out.println(winnerCalculator.getWinners(cars));
	}
}
