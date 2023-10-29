package racingcar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	static List<Car> participants;

	public static void main(String[] args) {
		participants = new ArrayList<>();
		// 차 이름 입력 받기
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String[] carNameInput = Console.readLine().split(","); // 공백 입력 처리 필요
		for (String name : carNameInput) {
			participants.add(new Car(name));
		}
		System.out.println("시도할 회수는 몇회인가요?");
		int tryCount = Integer.parseInt(Console.readLine()); // 예외 처리 필요
		System.out.println(); // 한칸 띄우고
		System.out.println("실행 결과");
		while (tryCount-- > 0) {
			participants.forEach(Car::rollDice);
			participants.forEach(car -> {
				try {
					car.printStatus();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});
			System.out.println();
		}

		System.out.print("최종 우승자 : ");
		participants.sort((o1, o2) -> o2.advance - o1.advance);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Car firstWinner = participants.get(0);

		try {
			bw.write(firstWinner.name);
			if (participants.size() > 1) {
				for (int i = 1; i < participants.size(); i++) {
					if (Objects.equals(participants.get(i).advance, firstWinner.advance)) {
						bw.write(", ");
						bw.write(participants.get(i).name);
					}
				}
			}
			bw.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		System.out.println();
	}
}
