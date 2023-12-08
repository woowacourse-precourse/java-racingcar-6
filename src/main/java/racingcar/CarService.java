package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarService {
	public List<Car> makeCarList(String name){
		List<Car> cars = new ArrayList<>();
		String[] nameArr = name.split(",");
		for (String s : nameArr) {
			cars.add(new Car(s));
		}
		return cars;
	}

	public int makeRandomNumberForCarMove(){
		return Randoms.pickNumberInRange(0,9);
	}
}
