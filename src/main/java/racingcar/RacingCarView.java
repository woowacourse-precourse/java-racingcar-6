package racingcar;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class RacingCarView {
	public String inputCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return Console.readLine();
	}
	
	public String inputCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		return Console.readLine();
	}
	public void printRacing(ArrayList<Car> cars) {
		for(Car c : cars) {
			System.out.println(c.getName() + " : " );
			printMove(c);
		}
	}
	
	void printMove(Car car) {
		for(int i = 0; i < car.getMove(); i++)
			System.out.print("-");
		System.out.println();
	}
}
