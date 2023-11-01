package racingcar;

import camp.nextstep.edu.missionutils.Console;

// 레이싱 시도 횟수를 설정하는 메소드
public class SetTryNumber {
	protected int number;
	
	public int inputNumber() {
		this.number = Integer.parseInt(Console.readLine());
		return this.number;
	}
}
