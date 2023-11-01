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

	// Car 클래스 생성
	public Car(String name) {
		validation = new Validation();
		validateAndSetName(name);
		this.name = name;
		this.distance = 0;
	}

	public void moveCondition() { // 전진 조건
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

	private void validateAndSetName(String name) { // 이름 입력에 대한 예외처리
		validation.validateCarName(name);
		this.name = name;
	}
}
