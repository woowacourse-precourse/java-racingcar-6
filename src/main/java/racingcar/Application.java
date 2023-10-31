package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;

class Car {
	String name;
	int step;
	String show;

	public Car(String n) {
		name = n;
		step = 0;
		show = "";
	}

	public void go() {
		int randomNumber = Randoms.pickNumberInRange(1, 9);

		if (randomNumber >= 4) {
			step++;
			show = show + "-";
		}
	}

	public void print() {
		System.out.printf("%s : %s\n", name, show);
	}
}

public class Application {
	public static void result(Car[] c, int N) {
		for (int i = 0; i < N; i++) {
			c[i].go();
			c[i].print();
		}
	}

	public static int findMax(Car[] c, int N) {
		int maxStep = 0;
		for (int i = 0; i < N; i++) {
			if (c[i].step > maxStep) {
				maxStep = c[i].step;
			}
		}
		return maxStep;
	}

	public static String winner(Car[] c, int maxStep, int N) {
		ArrayList<String> winners = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			if (maxStep == c[i].step) {
				winners.add(c[i].name);
			}
		}
		return String.join(", ", winners);
	}

	public static void main(String[] args) throws IllegalArgumentException {
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = sc.nextLine();
		System.out.println("시도할 회수는 몇회인가요?");
		int trial = sc.nextInt();
		sc.close();

		ArrayList<String> carNames = new ArrayList<String>();
		Collections.addAll(carNames, input.split(","));
		int N = carNames.size();

		for (int i = 0; i < N; i++) {
			String tmp = carNames.get(i);
			if (tmp.length() > 5) {
				throw new IllegalArgumentException();
			}
		}

		Car[] cars = new Car[N];
		for (int i = 0; i < N; i++) {
			cars[i] = new Car(carNames.get(i));
		}

		System.out.println("\n실행 결과");

		for (int i = 0; i < trial; i++) {
			result(cars, N);
			System.out.println();
		}

		System.out.println("최종 우승자 : " + winner(cars, findMax(cars, N), N));
	}
}
