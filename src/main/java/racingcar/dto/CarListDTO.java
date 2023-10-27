package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarListDTO {
	static final int CAR_START_LOCATION = 0;
	List<Car> carList = new ArrayList();
	
	public List<Car> makeCarList(String[] carStringArray) {
		for (int i=0; i<carStringArray.length; i++) {
			CarDTO carDTO = new CarDTO();
			carDTO.setCar(carStringArray[i], CAR_START_LOCATION);
			carList.add(carDTO.getCar());
		}
		return carList;
	}
}