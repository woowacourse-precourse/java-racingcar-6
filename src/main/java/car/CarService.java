package car;
import java.util.ArrayList;
import java.util.Stack;

import car.Car;
public class CarService {
	private static final int FORWARD_ON_FOUR = 4;
	
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
		if(num ==FORWARD_ON_FOUR) {
			movementStack.push("-");
			car.setMovementStack(movementStack);
		}
	}
	
	//car객체의 movement 자원을 출력
	public static String outputCarMOVEMENT(Car car) {
		Stack<String> car_movement = car.getMovementStack();
		if(car_movement.isEmpty()) return ""; //없을 경우 공백 리턴
		StringBuilder sb = new StringBuilder();
		for(String move : car_movement) sb.append(move);
		
		return sb.toString();
	}
	
	
}
