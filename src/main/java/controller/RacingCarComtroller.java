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
		
		InputImpo carInfo = new InputImpo(nameText, totalMoveText);
		List<String> carNameList = carInfo.changeList();
		int totalMove = carInfo.changeInt();
		
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
