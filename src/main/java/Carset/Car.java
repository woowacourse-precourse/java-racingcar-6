package Carset;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import validation.Validation;

public class Car {
	private String name;
	private int distance;
	Validation validation;

	public Car(String name) {
		validation = new Validation();
		validation.validateCarName(name);
		
		this.name = name;
		this.distance = 0;
	}

	public void MoveCondition() {
		int randomNumber = Randoms.pickNumberInRange(0, 9);

		if (randomNumber >= 4) {
			distance++;
		}

	}

	public int getDistance() {
		return distance;
	}

	public String getName() {
		return name;
	}
}
