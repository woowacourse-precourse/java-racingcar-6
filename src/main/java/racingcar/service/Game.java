package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.dto.CarDTO;
import racingcar.dto.RoundDTO;

public class Game {
	List<CarDTO> carList = new ArrayList<CarDTO>();
	List<CarDTO> winnerList = new ArrayList<CarDTO>();
	RoundDTO round;
	static final int CAR_START_LOCATION = 0;
	
	public void setGame() {
		generateCarList();
		generateRound();
	}
	
	private void generateCarList() {
		String[] carStringArray = Input.requestCarName();
		for (int i=0; i<carStringArray.length; i++) {
			CarDTO carDTO = new CarDTO();
			carDTO.setCar(carStringArray[i], CAR_START_LOCATION);
			carList.add(carDTO);
		}
	}
	
	private void generateRound() {
		int roundNumber = Input.requestRoundNumber();
		round = new RoundDTO();
		round.setRound(roundNumber);
	}
	
	public void startGame() {
		Output.printRunResultGuide();
		startRound();
	}
	
	private void startRound() {
		for (int i=0; i<round.getRoundNumber(); i++) {
			decideCarAction();
			Output.printRound(carList, round);
		}
	}
	
	private void decideCarAction() {
		for (int i=0; i<carList.size(); i++) {
			carList.get(i).carMoveOrStop();
		}
	}
	
	public void endGame() {
		int maxCarLocation = findMaxCarLocation();
		findWinner(maxCarLocation);
		Output.printResult(winnerList);
	}
		
	private int findMaxCarLocation() {
		int max = 0;
		for (int i=0; i<carList.size(); i++) {
			max = compareLocation(i, max);
		}
		return max;
	}
	
	private int compareLocation(int i, int max) {
		int indexCarLocation = carList.get(i).getCarLocation();
		if (indexCarLocation > max) {
			return indexCarLocation;
		}
		return max;
	}
	
	private void findWinner(int maxCarLocation) {
		for (int i=0; i<carList.size(); i++) {
			addWinnerList(i, maxCarLocation);
		}
	}
	
	private void addWinnerList(int i, int maxCarLocation) {
		int carLocation = carList.get(i).getCarLocation();
		if (carLocation == maxCarLocation) {
			winnerList.add(carList.get(i));
		}
	}
}