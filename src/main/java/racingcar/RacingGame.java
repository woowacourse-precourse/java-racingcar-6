package racingcar;

import java.util.*;

import org.assertj.core.util.Arrays;

public class RacingGame {
	static final int NAME_LENGTH = 5;
	
	private CarRepository carRepository = CarRepository.getInstance();
	private RacingCarView v = new RacingCarView();
	private String[] nameArr;
	private String inputName;
	private String inputCount;
	private int racingCount;
	
	public void gameStart() {
		setCarName();
		setRacingCount();
	}
	
	public void setCarName() {
		inputName = v.inputCarName();
		checkNull(inputName);
		splitNames(inputName);
		setCarList();
	}
	
	public void setRacingCount() {
		inputCount = v.inputCount();
		checkNull(inputCount);
		checkDigit(inputCount);
		setRacingCount();
	}
	
	void splitNames(String t) {
		nameArr = t.split(",");
		checkLength();
	}
	
	void setCarList() {
		for (String s : nameArr)
			carRepository.insertCar(new Car(s, 0));
	}
	
	void setRacingCount(String inputCount) {
		racingCount = Integer.parseInt(inputCount);
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
		while(s.charAt(i) != '\n') {
			if(!Character.isDigit(s.charAt(i)))
					throw new IllegalArgumentException();
			i++;
		}
	}
}
