package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
	List<String> moved;
	String name;

	public Car(String name){
		this.name = name;
		moved = new ArrayList<>();
	}
	public void addMove(boolean move){
		if (move){
			moved.add("-");
		}
	}
	public int howManyMoved(){
		return moved.size();
	}
}
