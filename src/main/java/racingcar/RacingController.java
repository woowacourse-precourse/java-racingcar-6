package racingcar;

import java.util.HashMap;

public class RacingController {
	private HashMap<String,Integer> carName;
	private String[] arr;
	private int number;
	
	public void start() {
		SetRacing racing = new SetRacing();
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		arr = racing.inputArr();
		this.carName = racing.carRegister();
		System.out.println("시도할 회수는 몇회인가요?");
		this.number = racing.tryNumber();
	}
	
	public void result() {
		System.out.println("실행 결과");
		Forward forward = new Forward();
		forward.carForward(this.carName, this.arr, this.number);
		Winner win = new Winner();
		win.announce(this.carName, this.arr);
	}
}
