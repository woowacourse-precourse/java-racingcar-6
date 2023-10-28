package car;
import java.util.ArrayList;
import java.util.Stack;

import car.Car;
public class CarService {
	// 쉼표(')가 포함된 문자열에서 객체 생성 및 리스트
	public static ArrayList<Car> getCarListOfString(String str){
		ArrayList<Car> car_list = new ArrayList<Car>();
		String[] str_arr = str.split(",");
		for(String word : str_arr) car_list.add(new Car(word));
		return car_list;
	}
	
	//0에서 9사이 숫자중 4가 나왔을경우 forward
	public static void forward(Car car,int num) {
		Stack<String> movementStack = car.getMovementStack();
		if(num ==4) {
			movementStack.push("-");
			car.setMovementStack(movementStack);
		}
	}
	
	
}
