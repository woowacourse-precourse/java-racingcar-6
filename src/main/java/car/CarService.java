package car;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
	
	//값이 4이상일 경우 전진
	public static void forward(Car car,int num) {
		Stack<String> movementStack = car.getMovementStack();
		if(num >=FORWARD_ON_FOUR) {
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
	
	//car객체의 forward 자원의 양을 기준으로 rank TOP 구하기 (우승자 구하기)
	public static String rankTOPOfCarList(ArrayList<Car> car_list) {
		StringBuilder rank = new StringBuilder();
		if(car_list.size()>1) {
			List<Car> car_list_sort = new ArrayList<Car>(car_list);
			//stack 인스턴스변수 사이즈를 기준으로 오름차순 정렬
			car_list_sort.sort((p1,p2) -> p1.movementStack.size() - p2.movementStack.size() );
			//제일 큰 전진값 구하기
			int top_forward = car_list_sort.get(car_list_sort.size()-1).getMovementStack().size();
			for(Car c : car_list_sort) {
				//우승자 한명일떄
				if(c.getMovementStack().size()==top_forward && rank.isEmpty()) rank.append(c.getName());
				//공동우승자가 있을경우
				else if(c.getMovementStack().size()==top_forward && !rank.isEmpty()) rank.append(", "+c.getName());
			}
		}else return car_list.get(0).getName(); //1개밖에 없을경우
		
		return rank.toString();
	}
	
	
	
}
