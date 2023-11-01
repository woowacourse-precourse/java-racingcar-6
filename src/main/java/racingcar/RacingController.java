package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 레이싱 출발 및 종료를 관리하는 메소드
public class RacingController {
	private HashMap<String,Integer> carName;
	private String[] arr;
	private List<String> carList = new ArrayList<String>();
	private int number;
	
	public void start() {
		InputCar car = new InputCar();
		SetCar register = new SetCar();
		SetTryNumber num = new SetTryNumber();
		CarList list = new CarList();
		
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		this.arr = car.inputArr();
		carList = list.keepCarList(carList,arr);
		this.carName = register.carRegister(carList);
		
		System.out.println("시도할 회수는 몇회인가요?");
		this.number = num.inputNumber();
	}
	
	public void result() {
		System.out.println("실행 결과");
		RepeatForward forward = new RepeatForward();
		forward.repeat(this.carName, this.carList, this.number);
		Winner win = new Winner();
		win.announce(this.carName, this.carList);
	}
}
