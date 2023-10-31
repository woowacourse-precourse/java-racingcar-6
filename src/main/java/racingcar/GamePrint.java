package racingcar;

import java.util.List;

class GamePrint {
	protected static void printGetNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}
	
	protected static void printGetTrial() {
		System.out.println("시도할 회수는 몇회인가요?");
	}
	
	protected static void printStart() {
		System.out.println("\n실행 결과");
	}
	
	protected static void printRace(List<Pair> information) {
		for (int i = 0; i < information.size(); i++) {
			String name = information.get(i).getName();
			int location = information.get(i).getLocation();
			
			System.out.print(name + " : ");
			for (int j = 0; j < location; j++) {
				System.out.print("-");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	protected static void printWinner(List<String> winners) {
		System.out.print("최종 우승자 : ");
		System.out.print(winners.get(0));
		
		for (int i = 1; i < winners.size(); i++) {
			System.out.print(", ");
			System.out.print(winners.get(i));
		}
		
		System.out.println();
	}
}
