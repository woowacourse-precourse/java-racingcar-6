package model;

import java.util.ArrayList;
import java.util.List;

import validators.InputValidator;

public class InputImpo {
	
	private String nameText;
	private String totalMoveText;
	
	public InputImpo(String nameText, String totalMoveText) {
		this.nameText = nameText;
		this.totalMoveText = totalMoveText;
	}
	
	public List<String> changeList() {
		List<String> carList = new ArrayList<>();
		
		String[] carNameArray = nameText.split(",");
		for(String name : carNameArray) {
			InputValidator.checkCarName(name);
			carList.add(name.trim());
		}
		return carList;
	}
	
	public int changeInt() {
		int totalMove = Integer.valueOf(totalMoveText);
		InputValidator.checkCarMove(totalMove);
		
		return totalMove;
	}
}
