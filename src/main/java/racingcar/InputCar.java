package racingcar;

import camp.nextstep.edu.missionutils.Console;

// 사용자가 입력한 자동차 이름을 배열로 반환하는 메소드
public class InputCar {
	protected String[] arr;
	
	public String[] inputArr() {
		this.arr = Console.readLine().split(",");
		return this.arr;
	}
}
