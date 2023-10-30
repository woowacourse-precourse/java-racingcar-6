package controller;

import java.util.ArrayList;
import java.util.List;

import model.Car;
import model.InputImpo;
import view.InputView;
import view.OutView;

public class RacingCarComtroller {

	public static void raceStart() throws IllegalArgumentException {
		InputView input = new InputView();
		String nameText = input.nameText();
		int totalMove = Integer.valueOf(input.totalMove());
		
		InputImpo carInfo = new InputImpo(nameText);
		List<String> carNameList = carInfo.changeList();
		List<Car> carList = new ArrayList<>();
		for(String carName : carNameList) {
			InputImpo.checkCarName(carName);
			
			Car car = new Car(carName);
			car.getRandomNumberList(totalMove);
			carList.add(car);
		}
		
		OutView out = new OutView();
		out.showResult(carList);
	}
	

}
