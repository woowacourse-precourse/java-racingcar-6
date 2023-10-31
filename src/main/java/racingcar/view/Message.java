package racingcar.view;

import java.util.List;

import racingcar.dto.CarDTO;

public class Message {
	public static void namingMessage() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}
	
	public static void roundingMessage() {
		System.out.println("시도할 회수는 몇회인가요?");
	}
	
	public static void lineSpaceMessage() {
		System.out.println();
	}
	
	public static void runResultGuideMessage() {
		System.out.println("실행 결과");
	}
	
	public static void resultMessage() {
		System.out.print("최종 우승자 : ");
	}
	
	public static void carNameMessage(String carName) {
		System.out.print(carName);
	}
	
	public static void commaMessage() {
		System.out.print(", ");
	}
	
	public static void colonMessage() {
		System.out.print(" : ");
	}
}