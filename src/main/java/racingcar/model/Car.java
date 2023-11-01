package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	String name;
	int count;

	public Car(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public void carDrive(int randomNum) {
		if (randomNum >= 4) {
			this.count++;
		}
	}
}
