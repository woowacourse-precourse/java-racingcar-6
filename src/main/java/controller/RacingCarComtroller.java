package controller;

import java.util.ArrayList;
import java.util.List;

import model.Car;
import model.InputImpo;
import view.InputView;
import view.OutView;

public class RacingCarComtroller {

	public static void raceStart() throws IllegalArgumentException {
		String nameText = InputView.nameText().trim();
		String totalMoveText = InputView.totalMove().trim();
		
		List<String> carNameList = InputImpo.changeList(nameText);
		int totalMove = InputImpo.changeInt(totalMoveText);
		
		List<Car> carList = new ArrayList<>();
		for(String carName : carNameList) {
			Car car = new Car(carName);
			car.getRandomNumberList(totalMove);
			carList.add(car);
		}
		
		OutView.showResultMessage();
		for(int i = 0; i < totalMove; i++) {
			for(Car car : carList) {
				OutView.showResult(car, i);
			}
			System.out.println();
		}
		OutView.showWinner(carList);
	}
	

}
