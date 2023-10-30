package racingcar;

import java.util.ArrayList;

public class RacingCarView {
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
