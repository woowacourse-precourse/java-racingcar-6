package racingcar;

import java.util.List;

public class Output {
	public void printStart(){
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}
	public void printTryCount(){
		System.out.println("시도할 회수는 몇회인가요?");
	}
	public void printMoveResult(List<Car> cars){
		cars.forEach(car -> {
			System.out.print(car.name + " : ");
			car.moved.forEach(System.out::print);
			System.out.println();
		});
	}
}
