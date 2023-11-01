package model;

import java.util.ArrayList;
import java.util.List;

import validators.InputValidator;

public class InputImpo {
	
	public static List<String> changeList(String nameText) {
		List<String> carList = new ArrayList<>();
		
		String[] carNameArray = nameText.split(",");
		for(String name : carNameArray) {
			InputValidator.checkCarName(name);
			carList.add(name.trim());
		}
		return carList;
	}
	
	public static int changeInt(String totalMoveText) {
		int totalMove = Integer.valueOf(totalMoveText);
		InputValidator.checkCarMove(totalMove);
		
		return totalMove;
	}
}
