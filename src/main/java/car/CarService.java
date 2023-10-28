package car;
import java.util.ArrayList;

import car.Car;
public class CarService {
	// 쉼표(')가 포함된 문자열에서 객체 생성 및 리스트
	public static ArrayList<Car> getCarListOfString(String str){
		ArrayList<Car> car_list = new ArrayList<Car>();
		String[] str_arr = str.split(",");
		for(String word : str_arr) car_list.add(new Car(word));
		return car_list;
	}
	
}
