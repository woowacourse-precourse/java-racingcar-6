package model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

	private String name;
	private List<Integer> numberList;
	private int forword;
	
	public Car(String name) {
		this.name = name;
	}
	
	public void getRandomNumberList(int totalMove){
		for(int i = 1; i <= totalMove; i++) {
			int number = Randoms.pickNumberInRange(0, 9);
			numberList = new ArrayList<>();
			numberList.add(number);
			
			if(number >= 4) {
				forword++;
			}
		}
	}
	
	public String getName() {
		return name;
	}

	public List<Integer> getNumberList() {
		return numberList;
	}

	public int getForword() {
		return forword;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", numberList=" + numberList + ", forword=" + forword + "]";
	}
	
}
