package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
	int advance = 0;
	
	public Car(String name) {
		this.name = name;
	}	
	public String getName() {
		return name;
	}
	public int getAdvance() {
		return advance;
	}
    public void addAdvance() {
		if(Randoms.pickNumberInRange(0,9) >= 4)
			advance++;
	}
    public void printAdvance() {
		System.out.print(getName() + " : ");
		for(int i = 0; i < getAdvance(); i++)
			System.out.print("-");
		System.out.println();
	}
}
