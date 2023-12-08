package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
	String name;
	List<String> moved;

	public Car(String name){
		this.name = name;
		moved = new ArrayList<>();
	}
	public void printMoved(){
		moved.forEach(System.out::print);
	}
	public void addMove(boolean move){
		if (move){
			moved.add("-");
		}
	}
}
