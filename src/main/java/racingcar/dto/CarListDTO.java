package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class CarListDTO {
	static final int CAR_START_LOCATION = 0;
	List<CarDTO> carList = new ArrayList<CarDTO>();
	
	public List<CarDTO> makeCarList(String[] carStringArray) {
		for (int i=0; i<carStringArray.length; i++) {
			CarDTO carDTO = new CarDTO();
			carDTO.setCar(carStringArray[i], CAR_START_LOCATION);
			carList.add(carDTO);
		}
		return carList;
	}
}