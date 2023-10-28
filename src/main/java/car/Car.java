package car;

import java.util.Stack;

public class Car {
	String name; //이름
	Stack<String> movementStack; //전진스택
	
	Car(String name){
		this.name = name;
		this.movementStack = new Stack<String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stack<String> getMovementStack() {
		return movementStack;
	}

	public void setMovementStack(Stack<String> movementStack) {
		this.movementStack = movementStack;
	}
	
	
	
	
}
