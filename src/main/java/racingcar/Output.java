package racingcar;

import java.util.List;

public class Output {
	public static void printStart(){
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}
	public static void printTryCount(){
		System.out.println("시도할 회수는 몇회인가요?");
	}
	public static void printMoveResult(List<Car> cars){
		System.out.println("실행 결과");
		cars.forEach(car -> {
			System.out.print(car.name + " : ");
			car.moved.forEach(System.out::print);
			System.out.println();
		});
		System.out.println();
	}
	public static void printWinner(List<String> winner){
		System.out.print("최종 우승자 : ");
		if (winner.size() == 1){
			System.out.println(winner.get(0));
		}
		for (int i = 0; i < winner.size(); i++){
			if (i == winner.size()-1){
				System.out.println(winner.get(i));
				break;
			}
			System.out.print(winner.get(i) + ", ");
		}
	}
}
