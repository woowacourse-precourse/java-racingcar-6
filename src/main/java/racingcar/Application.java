package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		List<Car> carList = carListInput();
		int carTryCount = carTryCount();
		System.out.println();

		System.out.println("실행 결과");
		for (int i = 0; i < carTryCount; i++) {
			diceThrow(carList);
			printCarCurrentState(carList);
		}

		getWinner(carList);
	}

	private static List<Car> carListInput() throws IllegalArgumentException {
		// 자동차 이름 입력
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

		List<Car> carList = new ArrayList<Car>();

		for (String str : Console.readLine().split(",")) {
			if (str.length() > 5)
				throw new IllegalArgumentException();

			carList.add(new Car(str));
		}

		return carList;
	}

	private static int carTryCount() {
		// 시도 회수 입력
		System.out.println("시도할 회수는 몇회인가요?");

		int carTryCount = Integer.parseInt(Console.readLine());

		return carTryCount;
	}

	private static void diceThrow(List<Car> carList) {
		// 전진 조건 확인
		for (Car car : carList)
			if (Randoms.pickNumberInRange(0, 9) > 3)
				car.setCarCount(car.getCarCount() + 1);
	}

	private static void printCarCurrentState(List<Car> carList) {
		// 자동차 현황 출력
		for (Car car : carList)
			System.out.println(car.toString());

		System.out.println();
	}

	private static void getWinner(List<Car> carList) {
		List<String> winnerList = new ArrayList<String>();
		int max = countMax(carList);

		winnerList = compareMax(carList, max);
		System.out.println("최종 우승자 : " + printWinner(winnerList));
	}

	private static String printWinner(List<String> winnerList) {
		// 승자 목록 출력
		return String.join(", ", winnerList);
	}

	private static int countMax(List<Car> carList) {
		// 최고 점수만 가져옴
		int max = 0;

		for (Car car : carList)
			if (car.getCarCount() > max)
				max = car.getCarCount();

		return max;
	}

	private static List<String> compareMax(List<Car> carList, int max) {
		// 승자 목록 생성
		List<String> winnerList = new ArrayList<String>();

		for (Car car : carList) {
			if (car.getCarCount() == max)
				winnerList.add(car.getCarName());
		}

		return winnerList;
	}

}