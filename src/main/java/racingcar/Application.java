package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String cars = Console.readLine();

		List<String> carsList = splitComma(cars);
		checkLength(carsList);

		System.out.println("시도할 회수는 몇회인가요?");

		int loop;
		try {
			loop = Integer.parseInt(Console.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자를 입력해주세요.");
		}

		System.out.println();
		System.out.println("실행 결과");

		Map<String, String> carsMap = new LinkedHashMap<>();
		for (String car : carsList) {
			carsMap.put(car, "");
		}

		for (int i = 0; i < loop; i++) {

			moveCars(carsMap);
			System.out.println();
		}
		
		//우승자 출력 및 다수일 시 쉼표(,)를 이용하여 출력하는 기능
		String winner = "";
		int length = 0;
		for (String car : carsMap.keySet()) {

			if (carsMap.get(car).length() > length) {
				length = carsMap.get(car).length();
				winner = car;
			} else if (carsMap.get(car).length() == length) {
				winner = winner + ", " + car;
			}
		}
		System.out.println("최종 우승자 : " + winner);
	}

	// 자동차 이름을 쉼표(,) 기준으로 구분하는 메소드
	private static List<String> splitComma(String cars) {

		String[] carsArr = cars.split(",");
		List<String> carsList = Arrays.asList(carsArr);

		return carsList;
	}
	
	// 5자 이하만 가능하게 하는 메소드
	private static void checkLength(List<String> carsList) {

		for (String cars : carsList) {
			if (cars.length() > 5) {
				throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
			}
		}
	}
	
	// 랜덤 값 생성 및 그 값을 자동차에게 사용하고 이름을 같이 출력하는 메소드
	private static void moveCars(Map<String, String> carsMap) {

		for (String car : carsMap.keySet()) {

			int random = Randoms.pickNumberInRange(0, 9);
			if (random >= 4) {
				String result = carsMap.get(car) + "-";
				carsMap.replace(car, result);
			}
			System.out.println(car + " : " + carsMap.get(car));
		}

	}

}
