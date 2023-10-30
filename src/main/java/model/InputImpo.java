package model;

import java.util.ArrayList;
import java.util.List;

public class InputImpo {
	
	private String nameText;
	//private int totalMove;
	
	public InputImpo(String nameText) {
		this.nameText = nameText;
		//this.totalMove = totalMove;
	}
	
	public List<String> changeList() {
		List<String> carList = new ArrayList<>();
		
		String[] carNameArray = nameText.split(",");
		for(String name : carNameArray) {
			carList.add(name.trim());
		}
		return carList;
	}

	public static void checkCarName(String car) {
		if(car.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5글자를 넘어가면 안됩니다.");
		}
	}
}
