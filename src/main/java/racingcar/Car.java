package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Car {
	static List<Integer> indexList = new ArrayList<Integer>();
	static String[] carList;

	Ready ready = new Ready();

	public void init() {
		String str = "";
		String times = "";

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		str = Console.readLine();
		carList = ready.checkCondition(str);

		System.out.println("시도할 회수는 몇회인가요?");
		times = Console.readLine();
		System.out.println("\n" + "실행 결과");
		ready.isDigit(times);

		play(Integer.parseInt(times));
	}

	private void play(int finalR) {
		int round = 0;
		int size = carList.length;

		List<Integer> position = new ArrayList<Integer>();

		do {
			position = Racing.move(position, size);
			currentPrint(carList, position);
			round++;
		} while (round != finalR);

		checkReult(position);
	}

	private static void currentPrint(String[] c, List<Integer> p) {
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " : ");
			
			for(int j = 0; j < p.get(i); j++) {
				System.out.print("-");
			}
			System.out.println();
		}
	}

	private static void checkReult(List<Integer> p) {
		int max = Racing.findMax(p);
		indexList = Racing.findIndexes(p, max);

		System.out.print("\n" + "최종 우승자 : ");
		if (indexList.size() > 1)
			printWinner(indexList);
		else
			System.out.println(carList[indexList.get(0)]);
	}

	private static void printWinner(List<Integer> index) {
		int i = 0;
		System.out.print(carList[i]);

		for (int j = 1; j < index.size(); j++) {
			i = index.get(j);
			System.out.print(", " + carList[i]);
		}
	}
}