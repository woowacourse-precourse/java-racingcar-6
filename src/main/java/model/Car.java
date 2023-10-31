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
		numberList = new ArrayList<>();
		for(int i = 1; i <= totalMove; i++) {
			int number = Randoms.pickNumberInRange(0, 9);
			numberList.add(number);
		}
	}
	
	public void plusForword() {
		forword++;
	}
	
//	public void showMoving(int i) {
//		if(numberList.get(i) >= 4) {
//			forword++;
//		}
//		
//		for(int j = 1; j <= forword; j++) {
//			System.out.print("-");
//		}
//	}
	
	public String getName() {
		return name;
	}

	public List<Integer> getNumberList() {
		return numberList;
	}
	
	public void setNumberList(List<Integer> numberList) {
		this.numberList = numberList;
	}

	public int getForword() {
		return forword;
	}

	public void setForword(int forword) {
		this.forword = forword;
	}
}
