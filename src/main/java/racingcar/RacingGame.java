package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
	static final int NAME_LENGTH = 5;
	
	private CarRepository carRepository = CarRepository.getInstance();
	private RacingCarView view = new RacingCarView();
	private String[] nameArr;
	private String inputName;
	private String inputCount;
	private int racingCount;
	
	public void gameStart() {
		setCarName();
		setRacingCount();
		
		setRacingResults();
		printWinner();
	}
	
	public void setCarName() {
		inputName = view.inputCarName();
		checkNull(inputName);
		splitNames(inputName);
		setCarList();
	}
	
	public void setRacingCount() {
		inputCount = view.inputCount();
		checkNull(inputCount);
		checkDigit(inputCount);
		racingCount = Integer.parseInt(inputCount);
	}
	
	public void setRacingResults() {
		view.printResultMessage();
		for(int i = 0; i < racingCount; i++) {
			setGoNStop(carRepository.findCarList());
			printRacingResult();
		}
	}
	
	public void setGoNStop(ArrayList<Car> carList) {
		for(int i = 0; i < carList.size(); i++) {
			int n = Randoms.pickNumberInRange(0, 9);
			if(n >= 4)
				carList.get(i).move();
		}
	}
	
	public void printRacingResult() {
		view.printRacing(carRepository.findCarList());
	}
	
	public void printWinner() {
		
	}
	
	void splitNames(String t) {
		nameArr = t.split(",");
		checkLength();
	}
	
	void setCarList() {
		for (String s : nameArr)
			carRepository.insertCar(new Car(s, 0));
	}
	
	void checkNull(String s) {
		if(s.equals("\n"))
			throw new IllegalArgumentException();
	}

	void checkLength() {
		for (String name : nameArr)
			if(name.length() > NAME_LENGTH)
				throw new IllegalArgumentException();
	}
	
	void checkDigit(String s) {
		int i = 0;
		while(i < s.length()) {
			if(!Character.isDigit(s.charAt(i)))
					throw new IllegalArgumentException();
			i++;
		}
	}
}
