package racingcar.controller;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.view.RacingCarView;

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
		String[] winner = findWinner();
		view.printWinner(winner);
	}
	
	public String[] findWinner() {
		int max = findMax();
		List<String> winnerList = new ArrayList<String>();
		
		for(Car c : carRepository.findCarList()) {
			if(c.getMove() == max)
				winnerList.add(c.getName());
		}
		return winnerList.toArray(new String[winnerList.size()]);
	}
	
	public int findMax() {
		int max = 0;
		for(Car c : carRepository.findCarList())
			if(max <= c.getMove())
				max = c.getMove();
		return max;
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
